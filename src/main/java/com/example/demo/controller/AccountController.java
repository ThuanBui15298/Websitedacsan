package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.example.demo.dto.PasswordDTO;
import com.example.demo.entity.ResponseObject;
import com.example.demo.entity.Users;
import com.example.demo.service.UserService;

@Controller
@SessionAttributes("loggedInUser")
@RequestMapping("/")

public class AccountController {
	
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private DonHangService donHangService;
	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@ModelAttribute("loggedInUser")
	public Users loggedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.findByEmail(auth.getName());
	}

	public Users getSessionUser(HttpServletRequest request) {
		return (Users) request.getSession().getAttribute("loggedInUser");
	}
	
	@GetMapping("/account")
	public String accountPage(HttpServletRequest res, Model model) {
		Users users = getSessionUser(res);
		model.addAttribute("users", users);
	//	List<DonHang> list = Lists.reverse(donHangService.getDonHangByNguoiDung(currentUser));
	//	model.addAttribute("list",list);
		return "/account";
	}
	
	@GetMapping("/changeInformation")
	public String clientChangeInformationPage(HttpServletRequest res,Model model) {
		Users users = getSessionUser(res);
		model.addAttribute("user", users);
		return "/information";
	}

	@GetMapping("/changePassword")
	public String clientChangePasswordPage() {
		return "/passwordChange";
	}
	
	@PostMapping("/updateInfo")
	@ResponseBody
	public ResponseObject commitChange(HttpServletRequest res,@RequestBody Users users) {
		Users users2 = getSessionUser(res);
		users2.setUserName(users.getUserName());
		users2.setPhone(users.getPhone());
		users2.setAddress(users.getAddress());
		userService.updateUser(users2);
		return new ResponseObject();
	}
	
	@PostMapping("/updatePassword")
	@ResponseBody
	public ResponseObject passwordChange(HttpServletRequest res,@RequestBody PasswordDTO dto) {
		Users users = getSessionUser(res);
		if (!passwordEncoder.matches( dto.getOldPassword(), users.getPassword())) {
			ResponseObject re = new ResponseObject();
			re.setStatus("old");
			return re;
		}
		userService.changePass(users, dto.getNewPassword());
		return new ResponseObject();
	}

}

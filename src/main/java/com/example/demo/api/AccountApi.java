package com.example.demo.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.AccountDTO;
import com.example.demo.entity.ResponseObject;
import com.example.demo.entity.Users;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/admin/account")
public class AccountApi {

	@Autowired
	private UserService userService;

//	@Autowired
//	private RolerService rolerService;

	@GetMapping("/all")
	public Page<Users> getUsersByRoler(@RequestParam("nameRoler") String nameRoler,
			 Pageable pageable) {
//		Set<Roler> roler = new HashSet<>();
//		roler.add(rolerService.findByNameRoler(nameRoler));
		Page<Users> pages = new PageImpl<Users>(userService.getUsersByRoler(nameRoler), pageable, 10);
//		return userService.getUsersByRoler(roler, page);
		return pages;
	}

	@PostMapping("/save")
	public ResponseObject saveTaiKhoan(@RequestBody @Valid AccountDTO acc, BindingResult result, Model model) {
		
		ResponseObject ro = new ResponseObject();

		if(userService.findByEmail(acc.getEmail()) != null) {
			result.rejectValue("email", "error.email","Email đã được đăng ký");
		}
		if(!acc.getConfirmPassword().equals(acc.getPassword())) {
			result.rejectValue("confirmPassword", "error.confirmPassword","Nhắc lại mật khẩu không đúng");
		}

		if (result.hasErrors()) {
			setErrorsForResponseObject(result, ro);
		} else {
			ro.setStatus("success");
			userService.saveUserForAdmin(acc);
		}	
		return ro;
	}


	@DeleteMapping("/delete/{id}")
	public void deleteAccount(@PathVariable long id) {
		userService.deleteById(id);
	}
	public void setErrorsForResponseObject(BindingResult result, ResponseObject ro) {

		Map<String, String> errors = result.getFieldErrors().stream()
				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
		ro.setErrorMessages(errors);
		ro.setStatus("fail");
		
		List<String> keys = new ArrayList<String>(errors.keySet());			
		for (String key: keys) {
		    System.out.println(key + ": " + errors.get(key));
		}
		
		errors = null;
	}
}

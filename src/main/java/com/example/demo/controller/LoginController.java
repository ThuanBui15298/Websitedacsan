package com.example.demo.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.config.JwtProvider;
import com.example.demo.form.JwtResponse;
import com.example.demo.form.LoginForm;
import com.example.demo.repository.RolerRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.CategoryServiceImpl;
import com.example.demo.service.impl.ProductServiceImpl;
import com.example.demo.service.impl.UserDetailsServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api")
public class LoginController {
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RolerRepository roleRepository;

	@Autowired
	JwtProvider jwtProvider;
	
	@Autowired
	ProductServiceImpl productService;
	
	@Autowired
	CategoryServiceImpl categorySevice;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		final UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(loginRequest.getUsername());
		String jwt = jwtProvider.generateJwtToken(authentication, userDetails);
		return ResponseEntity.ok(new JwtResponse(jwt));
	}

	@PostMapping("/user")
	public String getUser(@RequestHeader String authorization) {
		String token = authorization.substring(7);
		String username = jwtProvider.getUserNameFromJwtToken(token);
		UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
		return userDetails.getUsername();
	}

	@GetMapping({ "", "/login" })
	public String authenticateUsers(Model model) {
		model.addAttribute("categorys", categorySevice.getAllCategory().getData());
		return "/login";
	}

//	@PostMapping({"/login"})
//	public String authenticatesds(Model model) {
//		return "/index";
//	}

	@PostMapping("/singup")
	public void authenticateUserSingin(@ModelAttribute("Username") String username,
			@ModelAttribute("Password") String password, BindingResult bindingResult, ModelMap model, Authentication authentication, HttpServletRequest request, HttpServletResponse response) 
					throws IOException, ServletException {

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		authorities.forEach(authority -> {
			
			if (authority.getAuthority().equals("ROLE_MEMBER")) {
				try {
					redirectStrategy.sendRedirect(request, response, "/user");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					model.addAttribute("errorLogin", "ten dang nhap ko dung");
				}
			} else if (authority.getAuthority().contains("ROLE_ADMIN")) {
				try {
					redirectStrategy.sendRedirect(request, response, "/admin");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					model.addAttribute("errorLogin", "ten dang nhap ko dung");
				}
			} else if (authority.getAuthority().equals("ROLE_SHIPPER")) {
				try {
					redirectStrategy.sendRedirect(request, response, "/shipper");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					model.addAttribute("errorLogin", "ten dang nhap ko dung");
				}
			} else {
				throw new IllegalStateException();
			}
			
		});
	}
	
}
		
//			try {
//			Authentication authentication = authenticationManager
//					.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//			SecurityContextHolder.getContext().setAuthentication(authentication);
////			final UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
////			String jwt = jwtProvider.generateJwtToken(authentication, userDetails);
////			model.addAttribute("token", jwt);
////			model.addAttribute("type", "Bearer");
////			if (null==jwt) {
////				model.addAttribute("errorLogin", "ten dang nhap ko dung");
////			}
////			if (authentication.getAuthorities().toString().equalsIgnoreCase("ADMIN")) {
////				return "/aimin/index";
////			} else {
//			
//			
////			if(authentication.getAuthorities().toString() == "admin") {
////				model.addAttribute("products", productService.getAllProduct());
////				return "admin/index";
////			}
////			
////			if (authentication.getAuthorities().toString() == "user") {
//////				List<String> name = new ArrayList<String>();
////////				
//////				for (Product product : productService.getAllProduct()) {
//////					name.add(product.getName());
//////				}
////				
////				model.addAttribute("products", productService.getAllProduct());
////				return "/index";
////			}	
//			return "/index";		
////			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			model.addAttribute("errorLogin", "ten dang nhap ko dung");
//		}
//
//		return "redirect:login";
//	}
	
//	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//			Authentication authentication) throws IOException, ServletException {

		

//	@GetMapping("/signin")
//	public String authenticateUser(Model model) {
//
////		Authentication authentication = authenticationManager.authenticate(
////				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
////
////		SecurityContextHolder.getContext().setAuthentication(authentication);
////		final UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(loginRequest.getUsername());
////		String jwt = jwtProvider.generateJwtToken(authentication,userDetails);
//		// return ResponseEntity.ok(new JwtResponse(jwt));
//
//		return "/login";
//	}


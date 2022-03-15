package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.service.SecurityService;
import com.example.demo.service.UserService;
import com.example.demo.validator.UserValidator;

@RestController
public class RegisterController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
	
	@GetMapping("/register")
	public String registerPage(Model model) {
		model.addAttribute("newUser", new Users());
		return "client/register";
	}
	
	@PostMapping("/register")
	
	public String registerProcess(@RequestBody Users user, BindingResult bindingResult, Model model) {
	    
		userValidator.validate(user, bindingResult);
		
        if (bindingResult.hasErrors()) {
            return "client/register";
        }
        
        userService.saveUserForMember(user);

       securityService.autologin(user.getEmail(), user.getConfirmPassword());

        return "redirect:/";
	}
}

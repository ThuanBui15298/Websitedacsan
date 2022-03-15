package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.service.RolerService;
import com.example.demo.service.UserService;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	public RolerService rolerService;
	
	@Autowired
	public UserService userService;
	
	@RequestMapping("/index")
	public String index(@RequestHeader String Authorization ) {
		return "admin";
	}
	
	@ModelAttribute("loggedInUser")
	public Users loggedInUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.findByEmail(auth.getName());
	}

	@RequestMapping("/product")
	public String productPage(Model model) {
		model.addAttribute("title", "Quản lý san pham");
		return "admin/product";
	}

	@RequestMapping("/category")
	public String categoryPage(Model model) {
		model.addAttribute("title", "Quản lý Danh muc");
		return "admin/category";
	}

	@RequestMapping("/producer")
	public String producerPage(Model model) {
		model.addAttribute("title", "Quản lý nha san xuat");
		return "admin/producer";
	}

	@RequestMapping("/supplier")
	public String supplierPage(Model model) {
		model.addAttribute("title", "Quản lý nha cung cap");
		return "admin/supplier";
	}

	@RequestMapping("/campaign")
	public String campaignPage(Model model) {
		model.addAttribute("title", "Quản lý chien dich");
		return "admin/campaign";
	}

	@RequestMapping("/news")
	public String newsPage(Model model) {
		model.addAttribute("title", "Quản lý tin tuc");
		return "admin/news";
	}

	@RequestMapping("/posts")
	public String postsPage(Model model) {
		model.addAttribute("title", "Quản lý bai viet");
		return "admin/posts";
	}

	@RequestMapping("/discaunt")
	public String discauntPage(Model model) {
		model.addAttribute("title", "Quản lý giam gia");
		return "admin/discaunt";
	}

	@RequestMapping("/rating")
	public String ratingPage(Model model) {
		model.addAttribute("title", "Quản lý danh gia");
		return "admin/rating";
	}
	
	@RequestMapping("/contact")
	public String contactPage(Model model) {
		model.addAttribute("title", "Quản lý lien he");
		return "admin/contact";
	}
	
	public Users getSessionUser(HttpServletRequest request) {
		return (Users) request.getSession().getAttribute("loggedInUser");
	}
	
	@GetMapping("/tai-khoan")
	public String accountPage(Model model) {
	    model.addAttribute("listVaiTro", rolerService.findAllRoler());
		return "admin/quanLyTaiKhoan";
	}
	
}

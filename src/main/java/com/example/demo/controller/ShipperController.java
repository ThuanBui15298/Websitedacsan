package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shipper")
public class ShipperController {

	@RequestMapping("/index")
	public String index(@RequestHeader String Authorization) {
		return "shipper";
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
}

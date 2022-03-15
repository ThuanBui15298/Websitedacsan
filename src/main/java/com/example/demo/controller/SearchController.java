package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.dto.SearchProductObject;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@Controller
public class SearchController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("search")
	public String searchProduct(@RequestParam(defaultValue = "1") int page,@RequestParam String name,@RequestParam(defaultValue = "") String sort,@RequestParam(defaultValue = "") String range,@RequestParam(defaultValue = "") String category,@RequestParam(defaultValue = "") String supplier, @RequestParam(defaultValue = "") String producer, Model model) {
		SearchProductObject obj = new SearchProductObject();
		obj.setKeyword(name.split(" "));
		obj.setSort(sort);
		obj.setPice(range);
		obj.setCategory(category);
		obj.setSupplier(supplier);
		obj.setProducer(producer);
		Page<Product> list = productService.getProductByNameProduct(obj,page,12);
		int totalPage = list.getTotalPages();
		model.addAttribute("totalPage",totalPage);
		model.addAttribute("list",list.getContent());
		model.addAttribute("currentPage",page);
		model.addAttribute("name",name);
		model.addAttribute("sort",sort);
		model.addAttribute("range",range);
		model.addAttribute("category",category);
		model.addAttribute("supplier",supplier);
		model.addAttribute("producer",producer);
		List<Integer> pagelist = new ArrayList<Integer>();
		
		if(page==1 || page ==2 || page == 3 || page == 4)
		{
			for(int i = 2; i <=5 && i<=totalPage; i++)
			{
				pagelist.add(i);
			}
		}else if(page == totalPage)
		{
			for(int i = totalPage; i >= totalPage - 3 && i> 1; i--)
			{
				pagelist.add(i);
			}
			Collections.sort(pagelist);
		}else
		{
			for(int i = page; i <= page + 2 && i<= totalPage; i++)
			{
				pagelist.add(i);
			}
			for(int i = page-1; i >= page - 2 && i> 1; i--)
			{
				pagelist.add(i);
			}
			Collections.sort(pagelist);
		}
		model.addAttribute("pageList",pagelist);
		
		Set<String> dm = new HashSet<String>();
		Set<String> nsx = new HashSet<String>();
		Set<String> ncc = new HashSet<String>();
		Iterable<Product> dum = productService.getProductByNameProductWithoutPaginate(obj);
		for(	Product product: dum)
		{
			dm.add(product.getCategory().getName());
			nsx.add(product.getSupplier().getName());
			ncc.add(product.getSupplier().getName());
		}
		model.addAttribute("category",category);
		model.addAttribute("supplier",supplier);
		model.addAttribute("producer",producer);
		
		return "/";
	}

}

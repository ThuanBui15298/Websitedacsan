package com.example.demo.api;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.entity.Product;
import com.example.demo.model.CreateProductRequest;
import com.example.demo.service.ProductService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
@RequestMapping("/admin/product")
public class ProductApi {

	private final ProductService productService;

	@GetMapping("/find-all")
	public String getAll(ModelMap model) {
		model.addAttribute("products",this.productService.getAllProduct());
		return "redirect:index";
	}

	@PostMapping("/create")
	public void createProduct(@RequestHeader String Authorization,
			@RequestBody CreateProductRequest createProductRequest) throws Exception {
		this.productService.createProduct(createProductRequest);
	}

	 @GetMapping("/update/{id}")
	    public void updateProduct(@RequestHeader String Authorization, @PathVariable("id") Long id , @RequestBody CreateProductRequest createProductRequest) {
	    	createProductRequest.setId(id);
	    	this.productService.updateProduct(createProductRequest);
	}	    

	@GetMapping(value = "/product")
	private String product(@RequestHeader(value = "Authorization", required=false) String Authorization , @ModelAttribute String name, ModelMap model) {
		List<Product> product= productService.findName(name);
		model.addAttribute("productList",product);
		return "/product";
	}
	
	@GetMapping("/delete/{productId}")
	public String deleteProduct(@RequestHeader String Authorization, @PathVariable("productId") Long productId) {
		productService.deleteById(productId);
		return "OK !";
	}
	
	@PostMapping(value = "priceFilter")
	private Product priceFilter(@RequestHeader String Authorization, @RequestParam Long id) {
		Product product = productService.findById(id).get();
		return product;
	}
		
	@GetMapping("/products/{categoryId}")
	public String listProduct(@RequestHeader String Authorization, @PathVariable("categoryId") Long categoryId, ModelMap model){
		List<Product> product= productService.findByCategory(categoryId);
		model.addAttribute("listProduct", product);
				return "/products";		 
		    	
		}	    
}


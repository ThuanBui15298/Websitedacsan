package com.example.demo.model;

import com.example.demo.entity.Posts;
import com.example.demo.entity.Product;
import lombok.Data;

@Data
public class CreateImageRequest {
	
	private Long id;
	
	private String path;
	
	private Product product;
	
	private Posts posts;
	
}

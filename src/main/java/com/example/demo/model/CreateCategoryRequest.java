package com.example.demo.model;

import lombok.Data;

@Data
public class CreateCategoryRequest {
	
	private Long id;
	
	private String name;
	
	private String desciption;
}

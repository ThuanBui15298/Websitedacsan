package com.example.demo.model;

import com.example.demo.entity.Category;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryModel {

	private String id;
	
	private String name;
	
	private String desciption;
	
	 public static CategoryModel conveter(Category category) {
	        return CategoryModel.builder().id(category.getId().toString())
	                .name(category.getName())
	                .desciption(category.getDesciption()).build();
	    }
}

package com.example.demo.model;

import com.example.demo.entity.Image;
import com.example.demo.entity.Posts;
import com.example.demo.entity.Product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageModel {

	private String id;
	
	private String path;
	
	private Product product;
	
	private Posts posts;
	
	 public static ImageModel conveter(Image image) {
	        return ImageModel.builder().id(image.getId().toString())
	                .path(image.getPath())
	                //.posts(image.getPosts())
	                .product(image.getProduct()).build();                	   
	 }

}
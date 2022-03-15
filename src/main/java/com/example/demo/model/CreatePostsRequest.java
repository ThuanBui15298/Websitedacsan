package com.example.demo.model;


import lombok.Data;

@Data
public class CreatePostsRequest {
	
	private Long id;
	
	private String name;
	
	private String detailDescription;
	
	private String images;
	
	private Long newsId;
	
	private Long views;
	
	
}

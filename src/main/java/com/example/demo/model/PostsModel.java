package com.example.demo.model;

import com.example.demo.entity.News;
import com.example.demo.entity.Posts;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostsModel {

	private String id;
	
	private String name;
	
	private String detailDescription;
	
	private String images;
	
	private News news;
	
	private Long views;
	
	 public static PostsModel conveter(Posts posts) {
	        return PostsModel.builder().id(posts.getId().toString())
	                .name(posts.getName())
	                .detailDescription(posts.getDetailDescription())
	                .images(posts.getImages()).news(posts.getNews())
	                .views(posts.getViews())
	                .build();                	   
	 }

}
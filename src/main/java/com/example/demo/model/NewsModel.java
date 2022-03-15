package com.example.demo.model;

import com.example.demo.entity.News;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewsModel {

	private String id;
	
	private String name;
	
	 public static NewsModel conveter(News news) {
	        return NewsModel.builder().id(news.getId().toString())
	                .name(news.getName()).build();                	   
	 }

}
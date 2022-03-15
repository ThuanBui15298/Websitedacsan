package com.example.demo.model;

import lombok.Data;

@Data
public class CreateCampaignRequest {
	
	private Long id;
	
	private String name;
	
	private String desciption;
	
	private String images;
}

package com.example.demo.model;

import com.example.demo.entity.Campaign;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CampaignModel {

	private String id;
	
	private String name;
	
	private String desciption;
	
	private String images;
	
	 public static CampaignModel conveter(Campaign campaign) {
	        return CampaignModel.builder().id(campaign.getId().toString())
	                .name(campaign.getName())
	                .desciption(campaign.getDesciption()).images(campaign.getImages()).build();                	   
	 }

}
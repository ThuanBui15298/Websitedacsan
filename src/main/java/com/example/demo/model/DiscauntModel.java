package com.example.demo.model;

import com.example.demo.entity.Discaunt;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DiscauntModel {

	private String id;
	
	private String name;
	
	private String desciption;
	
	 public static DiscauntModel conveter(Discaunt discaunt) {
	        return DiscauntModel.builder().id(discaunt.getId().toString())
	        		.name(discaunt.getName())           
	                .desciption(discaunt.getDesciption()).build();                	   
	 }

}
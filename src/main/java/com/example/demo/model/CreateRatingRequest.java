package com.example.demo.model;

import lombok.Data;

@Data
public class CreateRatingRequest {
	
	private Long id;
	
	private String rate;
	
	private Long productId;
	
	private Long userId;
}

package com.example.demo.model;

import com.example.demo.entity.Product;
import com.example.demo.entity.Rating;
import com.example.demo.entity.Users;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatingModel {

	private String id;

	private Users user;

	private String rate;

	private Product product;

	public static RatingModel conveter(Rating rating) {
		return RatingModel.builder().id(rating.getId().toString())				
				.rate(rating.getRate())
				.product(rating.getProduct())
				.user(rating.getUser()).build();
	}

}
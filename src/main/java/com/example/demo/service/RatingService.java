package com.example.demo.service;


import java.util.List;

import com.example.demo.entity.Rating;
import com.example.demo.model.RatingDatatablesModel;

public interface RatingService {

	RatingDatatablesModel getAllRating();

	List<Rating> findName(String likeName, Long productId);
	
	void deleteById(Long id);
}

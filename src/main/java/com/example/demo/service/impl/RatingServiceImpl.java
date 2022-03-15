package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Rating;
import com.example.demo.model.RatingDatatablesModel;
import com.example.demo.repository.RatingRepository;
import com.example.demo.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public RatingDatatablesModel getAllRating() {
		// TODO Auto-generated method stub
		return RatingDatatablesModel.converter(this.ratingRepository.findAll());
	}

	@Override
	public List<Rating> findName(String likeName, Long productId) {
		// TODO Auto-generated method stub
		return ratingRepository.findName(productId, productId);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		ratingRepository.deleteById(id);
		
	}

}

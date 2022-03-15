package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.demo.entity.Rating;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatingDatatablesModel {
	 private List<List<String>> data;

	    public static RatingDatatablesModel converter(List<Rating> ratings) {
	        List<List<String>> datas = new ArrayList<>();
	        ratings.forEach(rating -> datas.add(Arrays.asList(rating.getId().toString(),
	        		rating.getRate(),
	        		rating.getProduct().toString(),
	        		rating.getUser().toString())));
	        		
	        return RatingDatatablesModel.builder().data(datas).build();
	    }

}

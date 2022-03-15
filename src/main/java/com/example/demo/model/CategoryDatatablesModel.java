package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.entity.Category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDatatablesModel {
	 private List<List<String>> data;

	    public static CategoryDatatablesModel converter(List<Category> categorys) {
	        List<List<String>> datas = new ArrayList<>();
	        categorys.forEach(category -> datas.add(Arrays.asList(category.getId().toString(),
	        		category.getName(),
	        		category.getDesciption())));
	        return CategoryDatatablesModel.builder().data(datas).build();
	    }

}

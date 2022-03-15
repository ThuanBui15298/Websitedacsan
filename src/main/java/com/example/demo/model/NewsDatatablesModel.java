package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.demo.entity.News;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewsDatatablesModel {
	 private List<List<String>> data;

	    public static NewsDatatablesModel converter(List<News> newss) {
	        List<List<String>> datas = new ArrayList<>();
	        newss.forEach(news -> datas.add(Arrays.asList(news.getId().toString(),
	        		news.getName())));
	        return NewsDatatablesModel.builder().data(datas).build();
	    }

}

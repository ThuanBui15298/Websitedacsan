package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.demo.entity.Posts;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostsDatatablesModel {
	 private List<List<String>> data;

	    public static PostsDatatablesModel converter(List<Posts> postss) {
	        List<List<String>> datas = new ArrayList<>();
	        postss.forEach(posts -> datas.add(Arrays.asList(posts.getId().toString(),
	        		posts.getName(),
	        		posts.getDetailDescription(),
	        		posts.getImages(),
	        		posts.getViews().toString(),
	        		posts.getNews().toString())));
	        return PostsDatatablesModel.builder().data(datas).build();
	    }

}

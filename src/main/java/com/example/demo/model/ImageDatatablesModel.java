package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.demo.entity.Image;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageDatatablesModel {
	 private List<List<String>> data;

	    public static ImageDatatablesModel converter(List<Image> images) {
	        List<List<String>> datas = new ArrayList<>();
	        images.forEach(image -> datas.add(Arrays.asList(image.getId().toString(),
	        		image.getPath(),
	        		image.getProduct().toString())));
	        		//image.getPosts().toString())));
	        return ImageDatatablesModel.builder().data(datas).build();
	    }

}

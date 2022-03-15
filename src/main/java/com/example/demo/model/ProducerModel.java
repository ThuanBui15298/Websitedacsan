package com.example.demo.model;

import com.example.demo.entity.Producer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProducerModel {
	private String id;
	
	private String name;
	
	private String descipsion;
	
	public static ProducerModel conveter(Producer producer) {
	        return ProducerModel.builder().id(producer.getId().toString())
	                .name(producer.getName())
	                .descipsion(producer.getDescipsion()).build();
	    }
}

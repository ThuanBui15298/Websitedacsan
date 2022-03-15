package com.example.demo.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.demo.entity.Producer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProducerDatatablesModel {
	private List<List<String>> data;

    public static ProducerDatatablesModel converter(List<Producer> producers) {
        List<List<String>> datas = new ArrayList<>();
        producers.forEach(producer -> datas.add(Arrays.asList(producer.getId().toString(),
        		producer.getName(),
        		producer.getDescipsion())));
        return ProducerDatatablesModel.builder().data(datas).build();
    }
}

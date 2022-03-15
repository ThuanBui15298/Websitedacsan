package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.demo.entity.Discaunt;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DiscauntDatatablesModel {
	private List<List<String>> data;

	public static DiscauntDatatablesModel converter(List<Discaunt> discaunts) {
		List<List<String>> datas = new ArrayList<>();
		discaunts.forEach(discaunt -> datas
				.add(Arrays.asList(discaunt.getId().toString(), discaunt.getName(), discaunt.getDesciption())));
		return DiscauntDatatablesModel.builder().data(datas).build();
	}

}

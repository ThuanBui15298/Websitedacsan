package com.example.demo.dto;

import java.util.Arrays;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchProductObject {
	private String categoryId;
	private String supplierId;
	private String pice;
	private String producerId;
	
	// sap xep theo gia
	private String sortByPrice;
	private String[] keyword;
	private String sort;
	
	// sap xep theo danhmuc va hangsx
	private String category;
	private String producer;
	private String supplier;
	

	public SearchProductObject() {
		categoryId = "";
		supplierId = "";
		producerId = "" ;
		pice = "";
		sortByPrice = "ASC";
	}

	@Override
	public String toString() {
		return "SearchProductObject [categoryId=" + categoryId + ", supplierId=" + supplierId + ", pice=" + pice
				+ ", producerId=" + producerId + ", sortByPrice=" + sortByPrice + ", keyword="
				+ Arrays.toString(keyword) + ", sort=" + sort + ", category=" + category + ", producer=" + producer
				+ ", supplier=" + supplier + "]";
	}
	
}

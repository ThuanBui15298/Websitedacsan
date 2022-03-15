package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchContactObject {

	private String status;
	private String since;
	private String toDate;
	
	public SearchContactObject() {
		status = "";
		since = "";
		toDate = "";
	}
}

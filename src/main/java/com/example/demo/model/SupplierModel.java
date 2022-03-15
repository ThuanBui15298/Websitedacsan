package com.example.demo.model;

import com.example.demo.entity.Supplier;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class SupplierModel {
	
	private String id;
	
	private String name;
	
	private String desciption;
	
	 public static SupplierModel conveter(Supplier supplier) {
	        return SupplierModel.builder().id(supplier.getId().toString())
	                .name(supplier.getName())
	                .desciption(supplier.getDesciption()).build();
	    }
}

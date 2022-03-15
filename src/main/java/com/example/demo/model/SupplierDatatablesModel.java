package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.demo.entity.Supplier;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SupplierDatatablesModel {
	 private List<List<String>> data;

	    public static SupplierDatatablesModel converter(List<Supplier> suppliers) {
	        List<List<String>> datas = new ArrayList<>();
	        suppliers.forEach(supplier -> datas.add(Arrays.asList(supplier.getId().toString(),
	        		supplier.getName(),
	        		supplier.getDesciption())));
	        return SupplierDatatablesModel.builder().data(datas).build();
	    }
}

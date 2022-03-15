package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.example.demo.entity.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDatatablesModel {
	 private List<List<String>> data;

	    public static ProductDatatablesModel converter(List<Product> products) {
	        List<List<String>> datas = new ArrayList<>();
	        products.forEach(product -> datas.add(Arrays.asList(product.getId().toString(),
	        		product.getName(),
					product.getQuantity().toString(), product.getPrice().toString(), product.getDesciption(),
					product.getCategory().toString(), product.getProducer().toString(),
					product.getSupplier().toString(), product.getDiscaunt().toString(), product.getImgaes(),
					product.getOrderInfo().toString())));
			return ProductDatatablesModel.builder().data(datas).build();
	    }

}

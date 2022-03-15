package com.example.demo.model;

import java.math.BigDecimal;
import java.util.List;
import com.example.demo.entity.Category;
import com.example.demo.entity.Discaunt;
import com.example.demo.entity.OrderInfo;
import com.example.demo.entity.Producer;
import com.example.demo.entity.Product;
import com.example.demo.entity.Supplier;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductModel {
	
	private String id;
	
	private String name;
	
	private Integer quantity;
	
	private BigDecimal price;
	
	private String desciption;
	
    private String imgaes;	
	
	private Category category;
	
	private Producer producer;
	
	private Supplier supplier;
	
	private Discaunt discaunt;
	
	private List<OrderInfo> orderInfo;
	
	 public static ProductModel conveter(Product product) {
	        return ProductModel.builder().id(product.getId().toString())
	                .name(product.getName())
	                .desciption(product.getDesciption())
	                .quantity(product.getQuantity())
	                .price(product.getPrice())
	                .category(product.getCategory())
	                .producer(product.getProducer())
	                .imgaes(product.getImgaes())
	                .supplier(product.getSupplier())
	                .discaunt(product.getDiscaunt())
	                .orderInfo(product.getOrderInfo())	                
	                .build();                	   
	 }

}
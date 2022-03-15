package com.example.demo.model;

import java.math.BigDecimal;
import java.util.List;
import com.example.demo.entity.Image;
import com.example.demo.entity.OrderInfo;
import lombok.Data;

@Data
public class CreateProductRequest {
	
	private Long id;
	
	private String name;
	
	private Integer quantity;
	
	private BigDecimal price;
	
	private String desciption;	
	
    private String imgaes;	
	
	private Long categoryId;
		
	private Long producerId;
	
	private Long supplierId;
	
	private Long discauntId;
	
	private List<OrderInfo> orderInfo;
	
	private List<Image> image;

}

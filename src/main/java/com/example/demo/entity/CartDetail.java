package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "cartDetail")
public class CartDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "product_id")
	private Product product;
	    
	@ManyToOne(optional = false)
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	 @Column(name = "quanity")
	 private int quanity;

	 @Column(name = "totalmonney")
	 private String totalMonney;
}

package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.Getter;
import lombok.Setter;

@Table(name = "image")
@Entity
@Setter
@Getter
public class Image {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Lob
	@Column(name = "path")
	private String path;
	
	 @ManyToOne(optional = false)
	 @JoinColumn(name = "product_id", nullable = false)
	 private Product product;
	 
//	 @ManyToOne(optional = false)
//	 @JoinColumn(name = "posts_id", nullable = false)
//	 private Posts posts;

	
}

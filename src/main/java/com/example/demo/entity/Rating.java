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


@Getter
@Setter
@Entity
@Table(name = "rating")
public class Rating extends BaseTimeModel{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private Users user;
   
    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Product product;
    
    @Column(name = "rate")
    private String rate;
    
    @Column(name = "countRate")
    private Long countRate;
    
}

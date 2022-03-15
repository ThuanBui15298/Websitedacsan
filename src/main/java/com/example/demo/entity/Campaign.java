package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "campaign")
public class Campaign extends BaseTimeModel{
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "name")
	private String name;	 

	@Column(name = "desciption")
	private String desciption;	
	
	@Column(name = "images")
	private String images;
}

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
@Table(name = "posts")
public class Posts extends BaseTimeModel{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "detailDescription")
	private String detailDescription;
	
	@Column(name = "images")
	private String images;
	
	 @ManyToOne(optional = false)
	 @JoinColumn(name = "news_id")
	 private News news;
	
	 @Column(name = "views", nullable = false)
	 private Long views;
	
}

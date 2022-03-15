package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="category")
public class Category extends BaseTimeModel{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@NotEmpty(message = "Tên danh mục không được trống")
    @Column(name = "name")
    private String name;
	
	@Column(name = "desciption")
	private String desciption;


}

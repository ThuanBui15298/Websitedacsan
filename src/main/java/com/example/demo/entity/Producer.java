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
@Table(name="producer")
public class Producer extends BaseTimeModel{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	@NotEmpty(message = "Tên nha san xuat không được trống")
    @Column(name = "name")
    private String name;
	
	@Column(name = "descipsion")
	private String descipsion;

}

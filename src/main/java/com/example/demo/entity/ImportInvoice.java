package com.example.demo.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "importInvoice")
public class ImportInvoice extends BaseTimeModel{
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	 @ManyToOne(optional = false)
	 @JoinColumn(name = "producer_id")
	 private Producer producer;
	    
	 @ManyToOne(optional = false)
	 @JoinColumn(name = "supplier_id")
	 private Supplier supplier;
	 
	 @ManyToOne(optional = false)
	 @JoinColumn(name = "product_id")
	 private Product product;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+7")
	@Column(name="timeUpdate")
	private Date timeUpdate;
}

package com.example.demo.entity;

import java.math.BigDecimal;
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
@Table(name = "ordersInfo")
public class OrderInfo extends BaseTimeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@Column(name = "totalMonney")
	private BigDecimal totalMonney;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+7")
	@Column(name = "timeupdate")
	private Date timeUpdate;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+7")
	@Column(name = "timedelivery")
	private Date timeDelivery;

	@Column(name = "status", nullable = false)
	private Integer status;

	@ManyToOne
	@JoinColumn(name = "produc_id", insertable = false, updatable = false )
	private Product product;
}

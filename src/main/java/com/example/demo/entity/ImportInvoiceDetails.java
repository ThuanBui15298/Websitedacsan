package com.example.demo.entity;


import java.io.Serializable;
import java.math.BigDecimal;

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
@Table(name = "importInvoiceDetails")
public class ImportInvoiceDetails  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	 @Column(name = "nameproduct")
	 private String nameProduct;

	 @Column(name = "price")
	 private BigDecimal price;

	 @Column(name = "quantity")
	 private Integer quantity;
	 
	 @Column(name = "totalmonney")
	 private Integer totalMonney;
	
	 @ManyToOne(optional = false)
	 @JoinColumn(name = "discaunt_id")
	 private ImportInvoice importInvoice;
}

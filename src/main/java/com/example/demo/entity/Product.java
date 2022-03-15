package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "product")
public class Product extends BaseTimeModel {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	 	@NotEmpty(message = "Tên san pham không được trống")
	    @Column(name = "name")
	    private String name;

	    @Column(name = "price")
	    private BigDecimal price;

	    @Column(name = "quantity")
	    private Integer quantity;

	    @Column(name = "desciption")
	    private String desciption;	  
	    
	    @Column(name = "images")
	    private String imgaes;	
	    
	    @ManyToOne(optional = false)
	    @JoinColumn(name = "category_id")
	    private Category category;
	    
	    @ManyToOne(optional = false)
	    @JoinColumn(name = "producer_id")
	    private Producer producer;
	    
	    @ManyToOne(optional = false)
	    @JoinColumn(name = "supplier_id")
	    private Supplier supplier;
	    
	    @ManyToOne(optional = false)
	    @JoinColumn(name = "discaunt_id")
	    private Discaunt discaunt;
	    
	    @OneToMany(fetch = FetchType.LAZY,mappedBy = "id")
	    private List<OrderInfo> orderInfo;
	    
	    @OneToMany(fetch = FetchType.LAZY,mappedBy = "id")
	    private List<Image> image;

	    
	 //   @OneToMany(cascade = CascadeType.ALL, mappedBy = "product"
	//			, fetch = FetchType.EAGER, orphanRemoval = true)
		//private List<Image> productImages = new ArrayList<Image>();
}

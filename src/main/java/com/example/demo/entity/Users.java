package com.example.demo.entity;


import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;


@Table(name = "user")
@Entity
@Setter
@Getter
public class Users extends BaseTimeModel {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	
		@Column(name = "username")
    	private String userName;
	
		@Lob
	    @Column(name = "avatar")
	    private String avatar;

	    @Column(name = "email")
	    private String email;

	    @Column(name = "phone")
	    private String phone;

	    @Column(name = "address")
	    private String address;

	    @Column(name = "password")
	    private String password;
	    
	    @Transient
		@JsonIgnore
		private String confirmPassword;
	    
	    @ManyToMany
		@JoinTable(name="user_roler",
		           joinColumns=@JoinColumn(name="user_id"), 
		           inverseJoinColumns=@JoinColumn(name="roler_id"))
		private Set<Roler> roler;
	    
	    @Column(name = "position")
	    private Integer position;

}

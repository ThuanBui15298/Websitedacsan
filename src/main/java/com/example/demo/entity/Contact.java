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
@Table(name="contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @Column(name = "email")
    private String email;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "contentcontact")
	private String contentContact;
	
	@Column(name = "contentrep")
	private String contentRep;
	
	@Column(name = "subject")
	private String subject;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+7")
	@Column(name="timecontact")
	private Date timeContact;

	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm", timezone = "GMT+7")
	@Column(name="timerep")
	private Date timeRep;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users users;
	
}

package com.example.demo.dto;

import java.util.Date;
import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContactDTO {

private long id;
	
	@NotEmpty(message="Nội dung trả lời không được trống")
	private String contentRep;
	
	private String subject;
	
	private String email;
	
	private Date timeRep;

	@Override
	public String toString() {
		return "ContactDto [id=" + id + ", contentRep=" + contentRep + ", subject=" + subject + ", email=" + email
				+ ", timeRep=" + timeRep + "]";
	}
}

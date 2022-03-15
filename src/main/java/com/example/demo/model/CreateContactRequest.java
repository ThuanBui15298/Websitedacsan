package com.example.demo.model;

import java.util.Date;
import lombok.Data;

@Data
public class CreateContactRequest {
	
	 	private Long id;
		
	    private String email;
		
		private String status;
		
		private String contentContact;		

		private String contentRep;		

		private String subject;
		
		private Date timeContact;

		private Date timeRep;
		
		private Long usersId;
		
		

}

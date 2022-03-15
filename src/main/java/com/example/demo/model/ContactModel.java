package com.example.demo.model;

import java.util.Date;
import com.example.demo.entity.Contact;
import com.example.demo.entity.Users;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ContactModel {

	private String id;
	
    private String email;
	
	private String status;
	
	private String contentContact;		

	private String contentRep;		

	private String subject;
	
	private Date timeContact;

	private Date timeRep;
	
	private Users users;
	
	public static ContactModel conveter(Contact contact) {
        return ContactModel.builder().id(contact.getId().toString())
                .email(contact.getEmail())
                .status(contact.getStatus())
                .contentContact(contact.getContentContact())
                .contentRep(contact.getContentRep())
                .timeContact(contact.getTimeContact())
                .subject(contact.getSubject())
                .timeRep(contact.getTimeRep())
                .users(contact.getUsers())	
                .build();
    }
}

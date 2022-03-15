package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Contact;
import com.example.demo.model.CreateContactRequest;

public interface ContactService {
	
	void deleteById(Long id);
	
	void updateById(Contact contact); 
	
	void updateContact(CreateContactRequest createContactRequest);
	
	List<Contact> findAllContact();

}

package com.example.demo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.entity.Contact;
import com.example.demo.model.CreateContactRequest;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;


public class ContactServiceImpl implements ContactService{

	
	@Autowired
	private ContactRepository contactRepository;

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		contactRepository.deleteById(id);
	}

	@Override
	public List<Contact> findAllContact() {
		// TODO Auto-generated method stub
		return this.contactRepository.findAll();
	}

	@Override
	public void updateById(Contact contact) {
		// TODO Auto-generated method stub
		contactRepository.save(contact);
		
	}

	@Override
	public void updateContact(CreateContactRequest createContactRequest) {
		// TODO Auto-generated method stub
		
		Contact contact = new Contact();
		contact.setContentContact(createContactRequest.getContentContact());
		contact.setContentRep(createContactRequest.getContentContact());
		contact.setEmail(createContactRequest.getEmail());
		contact.setSubject(createContactRequest.getSubject());
		contact.setStatus(createContactRequest.getStatus());
		contact.setTimeContact(createContactRequest.getTimeContact());
		contact.setContentRep(createContactRequest.getContentRep());
		
		this.contactRepository.save(contact);  	
	
	}






	

	
}

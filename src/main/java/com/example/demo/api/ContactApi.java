package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import com.example.demo.entity.Contact;
import com.example.demo.model.CreateContactRequest;
import com.example.demo.service.ContactService;


public class ContactApi {

	@Autowired
	private ContactService contactService;
	
//	@Autowired
//	private EmailUlti emailUlti;
	
	@GetMapping("/find-all")
	public List<Contact> getContact() {
		List<Contact> contact = contactService.findAllContact();
		return contact;
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCategory(@RequestHeader String Authorization, @PathVariable("id") Long id) {
		contactService.deleteById(id);
		return "OK !";
	}
	
	 @GetMapping("/update/{id}")
	    public void updateContact(@RequestHeader String Authorization, @PathVariable("id") Long id , @RequestBody CreateContactRequest createContactRequest) {
	    	createContactRequest.setId(id);
	    	this.contactService.updateContact(createContactRequest);	    
	    }
}

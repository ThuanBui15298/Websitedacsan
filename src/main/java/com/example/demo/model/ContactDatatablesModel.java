package com.example.demo.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.entity.Contact;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDatatablesModel {
	 private List<List<String>> data;

	    public static ContactDatatablesModel converter(List<Contact> contacts) {
	        List<List<String>> datas = new ArrayList<>();
	        contacts.forEach(contact -> datas.add(Arrays.asList(contact.getId().toString(),
	        		contact.getEmail(),
	        		contact.getStatus(),
	        		contact.getContentContact(),
	        		contact.getContentRep(),
	        		contact.getSubject(),
	        		contact.getTimeContact().toString(),
	        		contact.getTimeRep().toString(),
	        		contact.getUsers().toString())));
	        return ContactDatatablesModel.builder().data(datas).build();
	    }

}

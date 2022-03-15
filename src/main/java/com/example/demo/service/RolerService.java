package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Roler;



public interface RolerService {
	Roler findByNameRoler(String nameRoler);
	
	List<Roler> findAllRoler();
}

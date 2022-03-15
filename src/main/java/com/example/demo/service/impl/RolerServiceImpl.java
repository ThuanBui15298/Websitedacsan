package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Roler;
import com.example.demo.repository.RolerRepository;
import com.example.demo.service.RolerService;


@Service
public class RolerServiceImpl implements RolerService{

	@Autowired
	private RolerRepository rolerRepository;

	@Override
	public Roler findByNameRoler(String nameRoler) {
		return rolerRepository.findByNameRoler(nameRoler);
	}

	@Override
	public List<Roler> findAllRoler() {
		return rolerRepository.findAll();
	}
}

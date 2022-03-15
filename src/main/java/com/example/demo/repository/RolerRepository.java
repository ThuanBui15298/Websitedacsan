package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Roler;

@Repository
public interface RolerRepository extends JpaRepository<Roler, Long> {
	
	Roler findByNameRoler(String nameRoler);

}

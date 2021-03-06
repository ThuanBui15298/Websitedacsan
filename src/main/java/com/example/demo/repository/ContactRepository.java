package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.demo.entity.Contact;


public interface ContactRepository extends JpaRepository<Contact, Long>{
	
	@Modifying
	@Query(value = "DELETE FROM contact WHERE id = :id ", nativeQuery = true)
	void deleteById(@Param("id") Long id);
	
}

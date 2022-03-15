package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {
	@Query(value = "SELECT * FROM producer p \r\n" + "WHERE name LIKE %:likeName% ", nativeQuery = true)	
	List <Producer> findName(@Param("likeName") String likeName);
	
	
	@Modifying
	@Query(value = "DELETE FROM producer WHERE id = :id ", nativeQuery = true)
	void deleteById(@Param("id") Long id);
	
	
	@Query(value = "SELECT * FROM producer p WHERE p.name = :name ", nativeQuery = true)
	Producer getByFindName(String name);
}

package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Supplier;
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{

	@Query(value = "SELECT * FROM supplier s \r\n" + "WHERE name LIKE %:likeName% ", nativeQuery = true)	
	List <Supplier> findName(@Param("likeName") String likeName);
	
	
	@Modifying
	@Query(value = "DELETE FROM supplier WHERE id = :id ", nativeQuery = true)
	void deleteById(@Param("id") Long id);
	
	
	@Query(value = "SELECT * FROM supplier s WHERE s.name = :name ", nativeQuery = true)
	Supplier getByFindName(String name);
}

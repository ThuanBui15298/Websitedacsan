package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
	
	@Modifying
	@Query(value = "DELETE FROM image WHERE product_id = :productId ", nativeQuery = true)
	void deleteImageProductId(@Param("productId") Long productId);
}

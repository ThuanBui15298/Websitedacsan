package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Rating;
@Repository
public interface RatingRepository extends JpaRepository<Rating, Long>{

	@Query(value = "SELECT * FROM rating r WHERE user_id = :userId and product_id = :productId" , nativeQuery = true)	
	List<Rating> findName(@Param("userId") Long userId, @Param("productId") Long  productId);

	@Modifying
	@Query(value = "DELETE FROM rating WHERE id = :id ", nativeQuery = true)
	void deleteById(@Param("id") Long id);

}

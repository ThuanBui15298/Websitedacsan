package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Category;



@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	@Query(value = "SELECT * FROM category c \r\n" + "WHERE name LIKE %:likeName% ", nativeQuery = true)	
	List <Category> findName(@Param("likeName") String likeName);	
	
	@Modifying
	@Query(value = "DELETE FROM category WHERE id = :id ", nativeQuery = true)
	void deleteById(@Param("id") Long id);
	
	@Query(value = "SELECT * FROM category c WHERE c.name = :name ", nativeQuery = true)
	Category getByFindName(String name);

}

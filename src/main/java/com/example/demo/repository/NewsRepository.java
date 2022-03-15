package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.News;
@Repository
public interface NewsRepository extends JpaRepository<News, Long>{

	@Query(value = "SELECT * FROM news n \r\n " + " WHERE name LIKE %:likeName% " , nativeQuery = true)	
	List <News> findName(@Param("likeName") String likeName);
		
	@Modifying
	@Query(value = "DELETE FROM news WHERE id = :id ", nativeQuery = true)
	void deleteById(@Param("id") Long id);
	
	@Query(value = "SELECT * FROM news n WHERE n.name = :name ", nativeQuery = true)
	News getByFindName(String name);
}

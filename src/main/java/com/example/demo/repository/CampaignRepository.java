package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Campaign, Long>{

	@Query(value = "SELECT * FROM campaign c \r\n " + " WHERE name LIKE %:likeName% " , nativeQuery = true)	
	List <Campaign> findName(@Param("likeName") String likeName);
		
	@Modifying
	@Query(value = "DELETE FROM campaign WHERE id = :id ", nativeQuery = true)
	void deleteById(@Param("id") Long id);
		
	@Query(value = "SELECT * FROM campaign c WHERE c.name = :name ", nativeQuery = true)
	Campaign getByFindName(String name);
}

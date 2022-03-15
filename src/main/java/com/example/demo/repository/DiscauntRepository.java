package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Discaunt;

@Repository
public interface DiscauntRepository extends JpaRepository<Discaunt, Long>{
	@Query(value = "SELECT * FROM discaunt d \r\n" + " WHERE name LIKE %:likeName% " , nativeQuery = true)	
	List <Discaunt> findName(@Param("likeName") String likeName);
		
	@Modifying
	@Query(value = "DELETE FROM discaunt WHERE id = :id ", nativeQuery = true)
	void deleteById(@Param("id") Long id);
	
	@Query(value = "SELECT * FROM discaunt d WHERE d.name = :name ", nativeQuery = true)
	Discaunt getByFindName(String name);
}

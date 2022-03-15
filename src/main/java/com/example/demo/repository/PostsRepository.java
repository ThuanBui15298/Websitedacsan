package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Posts;


@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
	@Query(value = "SELECT * FROM posts p \r\n" + " WHERE name LIKE %:likeName% " , nativeQuery = true)	
	List <Posts> findName(@Param("likeName") String likeName);
		
	@Modifying
	@Query(value = "DELETE FROM posts WHERE id = :id ", nativeQuery = true)
	void deleteById(@Param("id") Long id);

	@Query(value = "SELECT * FROM posts p WHERE p.name = :name ", nativeQuery = true)
	Posts getByFindName(String name);
	
	@Modifying
    @Transactional
    @Query( value = "update posts p set p.views = :views where p.id = :id" , nativeQuery = true)
    void updateViews(@Param("views") Long views);


}

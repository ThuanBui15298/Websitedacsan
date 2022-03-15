package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(value = "SELECT * FROM product p \r\n" + "WHERE name LIKE %:likeName% ", nativeQuery = true)
	List <Product> findName(@Param("likeName") String likeName);

	@Query(value = "SELECT * FROM product p WHERE p.name = :name ", nativeQuery = true)
	Product getByFindName(String name);
	
	@Query(value = "SELECT price \r\n"
			+ "FROM product p \r\n"
			+ "WHERE price BETWEEN price= :price AND price= :price", nativeQuery = true)
	Optional<Product> findPrice(@Param("price") Long price);

	
	@Query(value = "select * from product p\r\n"
			+ "\r\n"
			+ "INNER JOIN category c\r\n"
			+ "\r\n"
			+ "where category_id = :categoryId ", nativeQuery = true)
	List <Product> findByCategory (@Param("categoryId") Long categoryId);
	
}

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.SearchProductObject;
import com.example.demo.entity.Product;
import com.example.demo.model.CreateProductRequest;

public interface ProductService {

	List<Product> getAllProduct();

	@Transactional
    void createProduct(CreateProductRequest createProductRequest) throws Exception;

    void updateProduct(CreateProductRequest createProductRequest);

	void deleteProductBySpringData(Long id);
	
	Product getProductById(Long id);
	
	List <Product> findName(String likeName);
	
	void deleteById(Long productId);
	
	void updateById(Product product);

	Iterable<Product> getProductByNameProductWithoutPaginate(SearchProductObject obj);

	Page<Product> getProductByNameProduct(SearchProductObject obj, int page, int i);
	
	Optional<Product> findById(Long id);
	
	List <Product> findByCategory (Long categoryId);
	
}

package com.example.demo.service;


import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Category;
import com.example.demo.model.CategoryDatatablesModel;
import com.example.demo.model.CreateCategoryRequest;

public interface CategoryService {

	CategoryDatatablesModel getAllCategory();

	@Transactional
    void createCategory(CreateCategoryRequest createCategoryRequest) throws Exception;

    void updateCategory(CreateCategoryRequest createCategoryRequest);

	List <Category> findName(String likeName);
	
	void deleteById(Long id);

	void updateById(Category Category);
}

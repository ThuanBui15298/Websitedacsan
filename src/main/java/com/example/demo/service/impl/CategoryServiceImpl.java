package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.internal.engine.messageinterpolation.parser.MessageDescriptorFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Category;
import com.example.demo.model.CategoryDatatablesModel;
import com.example.demo.model.CreateCategoryRequest;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public CategoryDatatablesModel getAllCategory() {
		// TODO Auto-generated method stub
		return CategoryDatatablesModel.converter(this.categoryRepository.findAll());
	}

	 @Transactional
	 @Override
	    public void createCategory(CreateCategoryRequest createCategoryRequest) throws Exception{
			Category category = new Category();			
			Category categoryName = categoryRepository.getByFindName(createCategoryRequest.getName());
			
			if (null == categoryName) {
				category.setName(createCategoryRequest.getName());
				category.setDesciption(createCategoryRequest.getDesciption());
		        this.categoryRepository.save(category);				
			} else {
				System.out.println("da ton tai san pham");
				throw new MessageDescriptorFormatException("da ton tai san pham");
			}
	}		

	@Transactional
	@Override
	public void updateCategory(CreateCategoryRequest createCategoryRequest) {
		Optional<Category> categoryItems = categoryRepository.findById(createCategoryRequest.getId());
		Category category = categoryItems.get();
		if(categoryItems.isPresent()) {
			
			Category categoryName = categoryRepository.getByFindName(createCategoryRequest.getName());
			
			if (null == categoryName) {
				category.setName(createCategoryRequest.getName());
				category.setDesciption(createCategoryRequest.getDesciption());
				this.categoryRepository.save(category);
			} else {
				System.out.println("San pham da ton tai");
				throw new MessageDescriptorFormatException("moi nhap lai");
			}

			categoryRepository.save(category);  			
			 
		} else {
			System.out.println("Lỗi không update được CSDL");
		}
	}	

	
	public List<Category> findName(String likeName) {
		return categoryRepository.findName(likeName);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
	}

	@Override
	public void updateById(Category category) {
		categoryRepository.save(category);
	}

}

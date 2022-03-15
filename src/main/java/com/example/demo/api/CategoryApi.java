package com.example.demo.api;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Category;
import com.example.demo.model.CategoryDatatablesModel;
import com.example.demo.model.CreateCategoryRequest;
import com.example.demo.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/category")
public class CategoryApi {

	 private final CategoryService categoryService;
	    @GetMapping("/find-all")
	    public CategoryDatatablesModel getAll() {
	        return this.categoryService.getAllCategory();
	    }

	    @PostMapping("/create")
	    public void createCategory(@RequestHeader String Authorization, @RequestBody CreateCategoryRequest createCategoryRequest) throws Exception {
	        this.categoryService.createCategory(createCategoryRequest);
	    }
	    @GetMapping("/update/{id}")
	    public void updateCategory(@RequestHeader String Authorization, @PathVariable("id") Long id , @RequestBody CreateCategoryRequest createCategoryRequest) {
	    	createCategoryRequest.setId(id);
	    	this.categoryService.updateCategory(createCategoryRequest);	    
	    }
	    
	    @PostMapping(value = "/category")
	    private List<Category> category(@RequestHeader String Authorization, @RequestParam String name) {
		List<Category> category= categoryService.findName(name);
			return category;
		}
	    
	    @GetMapping("/delete/{id}")
		public String deleteCategory(@RequestHeader String Authorization, @PathVariable("id") Long id) {
			categoryService.deleteById(id);
			return "OK !";
		}
}

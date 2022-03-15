package com.example.demo.service;


import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.News;
import com.example.demo.model.CreateNewsRequest;
import com.example.demo.model.NewsDatatablesModel;

public interface NewsService {

	NewsDatatablesModel getAllNews();

	@Transactional
    void createNews(CreateNewsRequest createNewsRequest) throws Exception;

    void updateNews(CreateNewsRequest createNewsRequest);
	
	List <News> findName(String likeName);
	
	void deleteById(Long id);
	
	void updateById(News news);
}

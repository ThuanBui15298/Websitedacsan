package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.validator.internal.engine.messageinterpolation.parser.MessageDescriptorFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.News;
import com.example.demo.model.CreateNewsRequest;
import com.example.demo.model.NewsDatatablesModel;
import com.example.demo.repository.NewsRepository;
import com.example.demo.service.NewsService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsRepository newsRepository;

	@Override
	public NewsDatatablesModel getAllNews() {
		return NewsDatatablesModel.converter(this.newsRepository.findAll());
	}

	@Transactional
	@Override
	public void createNews(CreateNewsRequest createNewsRequest) throws Exception {
		News news = new News();

		News newsName = newsRepository.getByFindName(createNewsRequest.getName());

		if (null == newsName) {
			news.setName(createNewsRequest.getName());
			this.newsRepository.save(news);
		} else {
			System.out.println("da ton tai san pham");
			throw new MessageDescriptorFormatException("da ton tai san pham");
		}
	}

	@Transactional
	@Override
	public void updateNews(CreateNewsRequest createNewsRequest) {
		Optional<News> newsItems = newsRepository.findById(createNewsRequest.getId());
		News news = newsItems.get();
		if (newsItems.isPresent()) {

			News newsName = newsRepository.getByFindName(createNewsRequest.getName());
			if (null == newsName) {
				news.setName(createNewsRequest.getName());
				this.newsRepository.save(news);
			} else {
				System.out.println("da ton tai san pham");
				throw new MessageDescriptorFormatException("da ton tai san pham");
			}

			newsRepository.save(news);
			
		} else {
			System.out.println("Lỗi không update được CSDL");
		}
	}

	@Override
	public List<News> findName(String likeName) {
		// TODO Auto-generated method stub
		return newsRepository.findName(likeName);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		newsRepository.deleteById(id);
	}

	@Override
	public void updateById(News news) {
		// TODO Auto-generated method stub
		newsRepository.save(news);
	}

}

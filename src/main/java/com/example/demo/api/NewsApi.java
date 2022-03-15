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
import com.example.demo.entity.News;
import com.example.demo.model.CreateNewsRequest;
import com.example.demo.model.NewsDatatablesModel;
import com.example.demo.service.NewsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/news")
public class NewsApi {
	private final NewsService newsService;
    @GetMapping("/find-all")
    public NewsDatatablesModel getAll() {
        return this.newsService.getAllNews();
    }

    @PostMapping("/create")
    public void createNews(@RequestHeader String Authorization, @RequestBody CreateNewsRequest createNewsRequest) throws Exception {
        this.newsService.createNews(createNewsRequest);
    }
    @GetMapping("/update/{id}")
    public void updateNews(@RequestHeader String Authorization, @PathVariable("id") Long id , @RequestBody CreateNewsRequest createNewsRequest) {
    	createNewsRequest.setId(id);
    	this.newsService.updateNews(createNewsRequest);
    }
    
    @PostMapping(value = "/news")
    private List<News> news(@RequestHeader String Authorization, @RequestParam String name) {
	List<News> news= newsService.findName(name);
		return news;
	}
    
    @GetMapping("/delete/{id}")
	public String deleteNews(@RequestHeader String Authorization, @PathVariable("id") Long id) {
    	newsService.deleteById(id);
		return "OK !";
	}
}

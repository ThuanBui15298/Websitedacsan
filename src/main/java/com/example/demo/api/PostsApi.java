package com.example.demo.api;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Posts;
import com.example.demo.model.CreatePostsRequest;
import com.example.demo.model.PostsDatatablesModel;
import com.example.demo.service.PostsService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/posts")
public class PostsApi {

	 private final PostsService postsService;
	    @GetMapping("/find-all")
	    public PostsDatatablesModel getAll() {
	        return this.postsService.getAllPosts();
	    }

	    @PostMapping("/create")
	    public void createPosts(@RequestHeader String Authorization,
	    		@RequestBody CreatePostsRequest createPostsnRequest) throws Exception{
	    	
	    	this.postsService.createPosts(createPostsnRequest);
	    }
	    @GetMapping("/update/{id}")
	    public void updatePosts(@RequestHeader String Authorization, @PathVariable("id") Long id, @RequestBody CreatePostsRequest createPostsnRequest) {
	    	createPostsnRequest.setId(id);
	    	this.postsService.updatePosts(createPostsnRequest);
	    }
	    
	    @GetMapping(value = "/posts")
	    private List<Posts> posts(@RequestHeader String Authorization, @RequestParam String name) {
		List<Posts> posts= postsService.findName(name);
			return posts;
		}
	    
	    @GetMapping("/delete/{id}")
		public String deletePosts(@RequestHeader String Authorization, @PathVariable("id") Long id) {
	    	postsService.deleteById(id);
			return "OK !";
		}
	    
	    @GetMapping("/views/{id}")
	    public boolean viewCheck (Model model,
	    		@RequestHeader String Authorization,
	    		HttpSession session,
	    		CreatePostsRequest createPostsRequest) {
	    	
	    	return postsService.viewCheck(session, createPostsRequest);
	
	    }
}

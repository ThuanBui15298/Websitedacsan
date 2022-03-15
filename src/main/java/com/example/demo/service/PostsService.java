package com.example.demo.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.Posts;
import com.example.demo.model.CreatePostsRequest;
import com.example.demo.model.PostsDatatablesModel;


public interface PostsService {

	PostsDatatablesModel getAllPosts();

	@Transactional
    void createPosts(CreatePostsRequest createPostsRequest) throws Exception;

	void deletePostsBySpringData(Long id);
	
	Posts getPostsById(Long id);

	void updatePosts(CreatePostsRequest createPostsRequest);
	
	List <Posts> findName(String likeName);
	
	void deleteById(Long id);
	
	void updateById(Posts posts);
	
	boolean viewCheck(HttpSession session, CreatePostsRequest createPostsRequest);
}

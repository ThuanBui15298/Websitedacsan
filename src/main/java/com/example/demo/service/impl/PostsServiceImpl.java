package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.hibernate.validator.internal.engine.messageinterpolation.parser.MessageDescriptorFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.entity.News;
import com.example.demo.entity.Posts;
import com.example.demo.model.CreatePostsRequest;
import com.example.demo.model.PostsDatatablesModel;
import com.example.demo.repository.NewsRepository;
import com.example.demo.repository.PostsRepository;
import com.example.demo.service.PostsService;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService{

	@Autowired
	private PostsRepository postsRepository;
	
	@Autowired
	private NewsRepository newsRepository ;
	
	private final long VIEW_COOLDOWN = 10000;
	
	private final Map<String, Long> lastViews = new HashMap<>();
	
	@Override
	public PostsDatatablesModel getAllPosts() {
		// TODO Auto-generated method stub
		return PostsDatatablesModel.converter(this.postsRepository.findAll());
	}

	@Transactional
	@Override
	public void createPosts(CreatePostsRequest createPostsRequest) throws Exception {
		Posts posts = new Posts();
		Posts postsName = postsRepository.getByFindName(createPostsRequest.getName());
		// check dữ iêu trong DB xem có trùng khớp hay không
		if (null == postsName) {
			if (createPostsRequest.getNewsId() != null) {
				Optional<News> news = newsRepository.findById(createPostsRequest.getNewsId());
				if (news.isPresent()) {
					posts.setNews(news.get());
				}
			} else {
				// thông báo khi bị lỗi
				throw new MessageDescriptorFormatException("Lỗi khong co category ");
			}	
			posts.setName(createPostsRequest.getName());
			posts.setDetailDescription(createPostsRequest.getDetailDescription());
			posts.setImages(createPostsRequest.getImages());			
			this.postsRepository.save(posts);
		} else {
			System.out.println("da ton tai san pham");
			throw new MessageDescriptorFormatException("da ton tai san pham");
		}

	}

	@Transactional
	@Override
	public void updatePosts(CreatePostsRequest createPostsRequest) {
		Optional<Posts> postsItems = postsRepository.findById(createPostsRequest.getId());
		Posts posts = postsItems.get();
		if (postsItems.isPresent()) {

			Posts postsName = postsRepository.getByFindName(createPostsRequest.getName());
			// check dữ iêu trong DB xem có trùng khớp hay không
			if (null == postsName) {
				if (createPostsRequest.getNewsId() != null) {
					Optional<News> news = newsRepository.findById(createPostsRequest.getNewsId());
					if (news.isPresent()) {
						posts.setNews(news.get());
					}
				} else {
					// thông báo khi bị lỗi
					throw new MessageDescriptorFormatException("Lỗi khong co category ");
				}
				posts.setName(createPostsRequest.getName());
				posts.setDetailDescription(createPostsRequest.getDetailDescription());
				posts.setImages(createPostsRequest.getImages());

				this.postsRepository.save(posts);
			} else {
				System.out.println("da ton tai san pham");
				throw new MessageDescriptorFormatException("da ton tai san pham");
			}

			postsRepository.save(posts);
		} else {
			System.out.println("Lỗi không update được CSDL");
		}
	}
	
	@Override
	public void deletePostsBySpringData(Long id) {
		// TODO Auto-generated method stub
		Optional<Posts> posts = postsRepository.findById(id);
		posts.ifPresent(postsRepository::delete);
	}

	@Override
	public Posts getPostsById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Posts> findName(String likeName) {
		// TODO Auto-generated method stub
		return postsRepository.findName(likeName);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		postsRepository.deleteById(id);
	}

	@Override
	public void updateById(Posts posts) {
		// TODO Auto-generated method stub
		postsRepository.save(posts);
	}

	@Override
	public boolean viewCheck(HttpSession session, CreatePostsRequest createPostsRequest) {
		
		var id = session.getId();
	
        if (lastViews.containsKey(id) && lastViews.get(id) > System.currentTimeMillis())
        	return false;
        lastViews.put(id, System.currentTimeMillis() + VIEW_COOLDOWN);

        createPostsRequest.setViews(createPostsRequest.getViews() + 1);  
        
        var postId = createPostsRequest.getId();
        postsRepository.updateViews(postId);
        return true;

	}


}

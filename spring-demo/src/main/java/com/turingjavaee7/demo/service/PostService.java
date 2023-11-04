package com.turingjavaee7.demo.service;

import java.util.List;
import java.util.Optional;

import com.turingjavaee7.demo.model.Post;
import com.turingjavaee7.demo.model.dto.PostDto;

public interface PostService {
	Iterable<Post> getAllPost();
	Optional<PostDto> getPostById(Long id);
	PostDto savePost(PostDto post);
	PostDto updatePost(PostDto post);
	void deletePostById(Long id);
}

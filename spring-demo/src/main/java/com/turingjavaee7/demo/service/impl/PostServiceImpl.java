package com.turingjavaee7.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turingjavaee7.demo.dao.PostDao;
import com.turingjavaee7.demo.model.Post;
import com.turingjavaee7.demo.model.dto.PostDto;
import com.turingjavaee7.demo.service.PostService;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	PostDao postDao;
	
	ModelMapper modelMapper = new ModelMapper();
	@Override
	public Iterable<Post> getAllPost() {	
		return this.postDao.findAll();
	}

	@Override
	public PostDto savePost(PostDto postDto) {
		Post post = modelMapper.map(postDto, Post.class);

		post = this.postDao.save(post);
		
		PostDto savedDto = modelMapper.map(post, PostDto.class);
		return savedDto;
	}
	@Override
	public PostDto updatePost(PostDto postDto) {
		Post post = modelMapper.map(postDto, Post.class);
		
		post = this.postDao.save(post);
		
		PostDto savedDto = modelMapper.map(post, PostDto.class);
		return savedDto;
	}

	@Override
	public Optional<PostDto> getPostById(Long id) {
		
		Optional<Post> result =this.postDao.findById(id);
		if(result.isPresent())
		{
			Post post = result.get();
			PostDto postDto = modelMapper.map(post, PostDto.class);
			
			return Optional.of(postDto);
		}
		else
		{
			return Optional.empty();
		}
		
	}

	@Override
	public void deletePostById(Long postId) {
		this.postDao.deleteById(postId);
		
	}
}

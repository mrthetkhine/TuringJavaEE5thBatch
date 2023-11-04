package com.turingjavaee7.demo.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turingjavaee7.demo.controller.rest.error.ApiErrorResponse;
import com.turingjavaee7.demo.model.Book;
import com.turingjavaee7.demo.model.Post;
import com.turingjavaee7.demo.model.dto.PostDto;
import com.turingjavaee7.demo.service.BookService;
import com.turingjavaee7.demo.service.PostService;
import com.turingjavaee7.demo.service.exception.BusinesLogicException;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/posts")
public class PostApiController {
	@Autowired
	PostService postService;
	
	@GetMapping
	Iterable<Post> getAllPost()
	{
		log.info("GET /api/post");
		return this.postService.getAllPost();
	}
	@GetMapping("/{postId}")
	ResponseEntity<Object> getPostById(@PathVariable Long postId)
	{
		log.info("GET /api/posts/"+postId);
		
		Optional<PostDto> result = this.postService.getPostById(postId);
		if(result.isPresent())
		{
			return ResponseEntity.ok(result.get());
		}
		else
		{
		
			ApiErrorResponse error = new ApiErrorResponse("1001", "No such post with postId "+postId);
			return ResponseEntity.badRequest()
								 .body(error);
		}
	}
	@PostMapping
	ResponseEntity<Object> savePost(@RequestBody @Valid PostDto post,
									BindingResult result)
	{
		log.info("POST savePost "+post);
		if(result.hasErrors())
		{
			log.info("Validation error in creating book "+result);
			return ResponseEntity.badRequest()
							 	.body(result.getAllErrors());	
		}
		else
		{
			PostDto savedPost = this.postService.savePost(post);
			return ResponseEntity.status(HttpStatus.CREATED)
								.body(savedPost);
		}
	}
	@PutMapping("/{postId}")
	ResponseEntity<Object> updatePost(@PathVariable String postId,
			@RequestBody @Valid PostDto postDto,
									BindingResult result)
	{
		log.info("PUT updatePost id "+postId+"  "+postDto);
		if(result.hasErrors())
		{
			log.info("Validation error in updating book "+result);
			return ResponseEntity.badRequest()
							 	.body(result.getAllErrors());	
		}
		else
		{
			PostDto updatedPost = this.postService.updatePost(postDto);
			return ResponseEntity.ok()
								.body(updatedPost);
		}
	}
	@DeleteMapping("/{postId}")
	ResponseEntity<Object> deletePost(@PathVariable Long postId)
	{
		log.info("Delete post id "+postId+"  ");
		try {
			this.postService.deletePostById(postId);
			return ResponseEntity.ok()
					.body(null);
		} catch (Exception e) {
			return ResponseEntity.badRequest()
				 	.body(e);
		}
		
	}
}

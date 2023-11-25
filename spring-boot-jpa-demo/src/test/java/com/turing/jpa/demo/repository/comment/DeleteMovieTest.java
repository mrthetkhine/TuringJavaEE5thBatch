package com.turing.jpa.demo.repository.comment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.turing.jpa.demo.controller.rest.MovieApiController;
import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.model.dto.GenreCountDto;
import com.turing.jpa.demo.model.dto.GenreCountDtoTwo;
import com.turing.jpa.demo.model.entity.Comment;
import com.turing.jpa.demo.model.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Rollback(false)
public class DeleteMovieTest {

	@Autowired
	MovieRepository movieRepository;
	
	@Test
	@Transactional
	public void testCommentCRUD()
	{
		log.info("Test case testCommentCRUD");
		//Movie movie = this.movieRepository.getOne(2L);
		Movie movie = new Movie();
		movie.setTitle("Test new movie");
		
		Comment comment1 =new Comment();
		comment1.setComment("Comment 1 for Avatar");
		comment1.setMovie(movie);
		
		Comment comment2 =new Comment();
		comment2.setComment("Coment 2 for Avatar");
		comment2.setMovie(movie);
		
		List<Comment> comments = new ArrayList<Comment>();
		comments.add(comment1);
		comments.add(comment2);
		
		movie.getComments().add(comment1);
		movie.getComments().add(comment2);
		try
		{
			this.movieRepository.save(movie);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}

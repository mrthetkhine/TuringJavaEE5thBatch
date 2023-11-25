package com.turing.jpa.demo.repository.movie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.turing.jpa.demo.dao.ActorRepository;
import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.model.entity.Actor;
import com.turing.jpa.demo.model.entity.Movie;
import com.turing.jpa.demo.repository.comment.UpdateComment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Rollback(false)
public class MovieTestManyToMany {
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	ActorRepository actorRepository;
	
	@Test
	@Transactional
	public void testUpdateComment()
	{
		/*
		log.info("Test case testCommentCRUD");
		Movie movie = this.movieRepository.getById(1L);
		
		System.err.println("Title "+movie.getTitle());
		movie.getActors().forEach(System.err::println);
		*/
		Actor actor = this.actorRepository.getById(1L);
		System.err.println("Name "+actor.getFullName());
		
		actor.getMovies().forEach(System.err::println);
	}
}

package com.turing.jpa.demo.repository.movie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.turing.jpa.demo.dao.ActorRepository;
import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.model.entity.Actor;
import com.turing.jpa.demo.model.entity.Gender;
import com.turing.jpa.demo.model.entity.Movie;
import com.turing.jpa.demo.repository.comment.UpdateComment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@Rollback(false)
public class MovieTestManyToManyAddActor {
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	ActorRepository actorRepository;
	
	@Test
	@Transactional
	public void testUpdateComment()
	{
	
		Movie movie = this.movieRepository.getById(2L);
		
		Actor actor = new Actor();
		
		actor.setFirstName("Susan");
		actor.setLastName("Alexandra");
		actor.setGender(Gender.Female);
		
		movie.getActors().add(actor);
		
		this.movieRepository.save(movie);
	}
}

package com.turing.jpa.demo.repository.movie;

import java.util.ArrayList;
import java.util.List;

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
public class MovieTestAddActorToMovie {
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	ActorRepository actorRepository;
	
	@Test
	@Transactional
	public void testUpdateComment()
	{
		
		Actor actor = this.actorRepository.getById(2L);
		
		Movie movie =new Movie();
		movie.setTitle("Quill");
		movie.setGenre("Drama");
		movie.setYear(2000);
		
		List<Actor> actors = new ArrayList<Actor>();
		actors.add(actor);
		movie.setActors(actors);
		
		List<Movie> movies = new ArrayList<Movie>();
		movies.add(movie);
		actor.setMovies(movies);
		
		this.actorRepository.save(actor);
	}
}

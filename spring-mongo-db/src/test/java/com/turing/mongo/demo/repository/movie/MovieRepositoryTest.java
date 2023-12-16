package com.turing.mongo.demo.repository.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.turing.mongo.demo.model.Actor;
import com.turing.mongo.demo.model.Movie;
import com.turing.mongo.demo.model.MovieDetail;
import com.turing.mongo.demo.repository.ActorRepository;
import com.turing.mongo.demo.repository.MovieRepository;

@SpringBootTest
class MovieRepositoryTest {

	 @Autowired 
	 MovieRepository movieRepository;
	 
	 @Autowired 
	 ActorRepository actorRepository;
	
	 
	 @Test
	 void testMovieCRUD() {
		 
		 Movie movie = new Movie();
		 MovieDetail movieDetail = new MovieDetail();
		 
		 movie.setName("Movie 3");
		 movie.setDirector("Chrisopher Nolan");
		 movie.setYear(2010);
		 
		 movieDetail.setDetails("Good sci-fi-movies");
		 movie.setDetails(movieDetail);
		 
		 Actor actor = this.actorRepository.findById("657868667fdcb23c8e616359").get();
		 Actor actor2 = this.actorRepository.findById("65786b944df196549f9f1ec4").get();
		
		 List<Actor> actors = new ArrayList<>();
		 actors.add(actor);
		 actors.add(actor2);
		 
		 //movie.setActors(actors.stream().map(act->act.getId()).collect(Collectors.toList()));
		 movie.setActors(actors);
		 this.movieRepository.save(movie);
		 
	 }
	 
	 /*
	 @Test
	 public void addGenere()
	 {
		 Optional<Movie> result = this.movieRepository.findById("65786c0cf5309b4b72942321");
		 Movie movie = result.get();
		 
		 ArrayList<String> genres = new ArrayList<>();
		 genres.add("Sci-Fi");
		 genres.add("Drama");
		 movie.setGenres(genres);
		 
		 this.movieRepository.save(movie);
				 
	 }
	 */

}

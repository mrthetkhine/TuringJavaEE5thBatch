package com.turing.mongo.demo.repository.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.turing.mongo.demo.model.Actor;
import com.turing.mongo.demo.model.Movie;
import com.turing.mongo.demo.model.MovieDetail;
import com.turing.mongo.demo.repository.ActorRepository;
import com.turing.mongo.demo.repository.MovieRepository;

@SpringBootTest
class ActorRepositoryTest {

	 @Autowired 
	 ActorRepository actorRepository;
	
	 @Test
	 void testMovieCRUD() {
		 
		 
		 Actor actor = new Actor();
		 actor.setFirstName("Elliot");
		 actor.setLastName("Page");
		 
		 this.actorRepository.save(actor);
		
		 /*
		 List<Actor> actors = this.actorRepository.findAll();
		 actors.forEach(System.err::println);
		 */
		 /*
		 Optional<Actor> result = this.actorRepository.findById("657868667fdcb23c8e616359");
		 if(result.isPresent())
		 {
			 System.out.println("Actor "+result.get());
		 }
		 */
	 }

}

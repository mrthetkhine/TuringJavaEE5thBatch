package com.turing.mongo.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.turing.mongo.demo.model.Movie;

public interface MovieRepository extends MongoRepository<Movie,String>{
	List<Movie> findByDirector(String director);
	
	/*
	@Query("{ 'actors.firstName': ?0}")
	List<Movie> findByActorName(String name);
	*/
	@Query("{ 'genre': ?0}")
	List<Movie> findMovieWhereGeneresIs(String genre);
}

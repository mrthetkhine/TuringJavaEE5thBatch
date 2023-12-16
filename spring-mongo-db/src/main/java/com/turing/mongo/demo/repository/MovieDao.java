package com.turing.mongo.demo.repository;
import java.util.List;

import com.turing.mongo.demo.model.Movie;

public interface MovieDao {
	List<Movie> getAllMovieInYear(int year);
}

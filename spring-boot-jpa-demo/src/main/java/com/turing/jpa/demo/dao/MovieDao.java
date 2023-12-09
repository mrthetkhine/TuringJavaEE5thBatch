package com.turing.jpa.demo.dao;
import java.util.List;

import com.querydsl.core.Tuple;
import com.turing.jpa.demo.model.entity.*;


public interface MovieDao {
	List<Movie> getAllMovieByYear(Integer year);
	List<Movie> getAllMovieByYearOrGene(Integer year,String genre);
	List<Tuple> getGenreAndCount();
	List<Movie> getAllMovieWhereGenresIn(List<String> genres);
	
	List<Movie> getAllMovieActoredBy(String fullName);
	void deleteMovieById(Long id);
	void updateTitleById(String title,Long id);
}

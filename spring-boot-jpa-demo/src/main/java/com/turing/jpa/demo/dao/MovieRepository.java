package com.turing.jpa.demo.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.turing.jpa.demo.model.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	List<Movie> findByYear(Integer year);
	List<Movie> findByTitle(String title);
	List<Movie> findByGenreAndYear(String genre,Integer year);
	List<Movie> findByGenreOrYear(String genre,Integer year);
	List<Movie> findDistinctByGenre(String genre);
	List<Movie> findByYearBetween(Integer startYear,Integer endYear);
	List<Movie> findByYearLessThan(Integer year);
	List<Movie> findByCreatedAtIsNull();
	List<Movie> findByTitleLike(String title);
	List<Movie> findAllByOrderByYear();
	List<Movie> findAllByYearIn(Collection<Integer> years);
	
	Movie findTopByOrderByYearDesc();
}

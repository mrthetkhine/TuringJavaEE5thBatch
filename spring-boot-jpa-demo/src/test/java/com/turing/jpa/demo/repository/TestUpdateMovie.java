package com.turing.jpa.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.turing.jpa.demo.controller.rest.MovieApiController;
import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.model.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class TestUpdateMovie {

	@Autowired
	MovieRepository movieRepository;
	
	int add(int a, int b)
	{
		return a+b;
	}
	@Test
	public void testUpdateMovie()
	{
		log.info("Test case testUpdateMovie");
		/*
		int row = this.movieRepository.updateYearByMovieId(10L, 2010);
		*/
		int row = this.movieRepository.deleteMovieById(10L);
		System.out.println("Row "+row);
	}
}

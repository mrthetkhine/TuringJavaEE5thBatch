package com.turing.jpa.demo.repository.actor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.turing.jpa.demo.controller.rest.MovieApiController;
import com.turing.jpa.demo.dao.ActorRepository;
import com.turing.jpa.demo.dao.MovieRepository;
import com.turing.jpa.demo.model.dto.GenreCountDto;
import com.turing.jpa.demo.model.dto.GenreCountDtoTwo;
import com.turing.jpa.demo.model.entity.Actor;
import com.turing.jpa.demo.model.entity.Movie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class TestActorFormula {

	@Autowired
	ActorRepository actorRepository;
	
	
	@Test
	public void testFormula()
	{
		//List<Actor> actors = this.actorRepository.findAll();
		List<Actor> actors = this.actorRepository.findByAgeGreaterThan(40);
		actors.forEach(System.err::println);
	}
}

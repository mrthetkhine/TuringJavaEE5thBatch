package com.turing.mongo.demo.service.impl;

import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.mongo.demo.dto.MovieDetailsDto;
import com.turing.mongo.demo.dto.MovieDto;
import com.turing.mongo.demo.model.Movie;
import com.turing.mongo.demo.repository.MovieReactiveRepository;
import com.turing.mongo.demo.service.MovieService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieServiceImpl implements MovieService{
	ModelMapper modelMapper = new ModelMapper();
	@Autowired
	MovieReactiveRepository movieRepository;

	@Override
	public Flux<MovieDto> getAllMovie() {
		
		return this.movieRepository.findAll()
						.map(this::entityToDto);
	}

	private MovieDto entityToDto(Movie movie) {
		MovieDto dto = modelMapper.map(movie, MovieDto.class);
		MovieDetailsDto movieDetailsDto =modelMapper.map(movie.getDetails(), MovieDetailsDto.class); 
		dto.setMovieDetails(movieDetailsDto);
		return dto;
	}

	@Override
	public Mono<Movie> getMovieById(String id) {
		return this.movieRepository.findById(id);
	}

	@Override
	public Flux<Movie> getMovieByYear(Long year) {
		
		return this.movieRepository.findByYear(year);
	}
	
}

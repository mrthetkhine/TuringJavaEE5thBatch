package com.turing.mongo.demo.service.impl;

import java.util.List;
import java.util.function.Function;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.mongo.demo.controller.rest.exception.BusinessException;
import com.turing.mongo.demo.dto.ActorDto;
import com.turing.mongo.demo.dto.MovieDetailsDto;
import com.turing.mongo.demo.dto.MovieDto;
import com.turing.mongo.demo.model.Actor;
import com.turing.mongo.demo.model.Movie;
import com.turing.mongo.demo.model.MovieDetail;
import com.turing.mongo.demo.repository.ActorRepository;
import com.turing.mongo.demo.repository.MovieReactiveRepository;
import com.turing.mongo.demo.service.MovieService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovieServiceImpl implements MovieService{
	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	MovieReactiveRepository movieRepository;
	
	@Autowired
	ActorRepository actorRepository;

	@Override
	public Flux<MovieDto> getAllMovie() {
		
		return this.movieRepository.findAll()
						.map(this::entityToDto);
	}

	private MovieDto entityToDto(Movie movie) {
		MovieDto dto = modelMapper.map(movie, MovieDto.class);
		MovieDetailsDto movieDetailsDto =modelMapper.map(movie.getDetails(), MovieDetailsDto.class); 
		dto.setDetails(movieDetailsDto);
		
		List<ActorDto> actors = modelMapper.map(movie.getActors(), new TypeToken<List<ActorDto>>() {}.getType());
		dto.setActors(actors);
		
		return dto;
	}
	private Movie dtoToEntity(MovieDto movieDto) {
		Movie movie = modelMapper.map(movieDto, Movie.class);
		
		MovieDetail movieDetails =modelMapper.map(movieDto.getDetails(), MovieDetail.class); 
		movie.setDetails(movieDetails);
		
		List<Actor> actors = modelMapper.map(movieDto.getActors(), new TypeToken<List<Actor>>() {}.getType());
		movie.setActors(actors);
		
		return movie;
	}
	@Override
	public Mono<Movie> getMovieById(String id) {
		return this.movieRepository.findById(id);
	}

	@Override
	public Flux<Movie> getMovieByYear(Long year) {
		
		return this.movieRepository.findByYear(year);
	}

	@Override
	public Mono<Movie> saveMovie(MovieDto movieDto) {
		Movie movie = this.dtoToEntity(movieDto);
		return this.actorRepository.saveAll(movie.getActors())
							.collectList()//Mono<List<Actor>>
							.flatMap(actors->{
								movie.setActors(actors);
								return this.movieRepository.save(movie);
							});
	
	}

	@Override
	public Mono<MovieDto> updateMovieById(String movieId,MovieDto movieDto) {
		return this.movieRepository.findById(movieId)
									.switchIfEmpty(Mono.error(new BusinessException("Movie id not found")))
									.flatMap(entity->saveMovie(movieDto))
									.map(movie->entityToDto(movie));
									
									
	}
	
}

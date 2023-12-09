package com.turing.jpa.demo.dao.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.data.util.MethodInvocationRecorder.Recorded.ToCollectionConverter;
import org.springframework.stereotype.Repository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.turing.jpa.demo.dao.MovieDao;
import com.turing.jpa.demo.model.entity.Movie;
import com.turing.jpa.demo.model.entity.QActor;
import com.turing.jpa.demo.model.entity.QMovie;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class MovieDaoImpl implements MovieDao{

	 @PersistenceContext
	 private EntityManager em;

	 private JPAQueryFactory queryFactory;
	 
	
	 @PostConstruct
	 public void init()
	 {
		 this.queryFactory = new JPAQueryFactory(JPQLTemplates.DEFAULT, em);
	 }
	 @Override
	public List<Movie> getAllMovieByYear(Integer year) {
		 final JPAQuery<Movie> query = new JPAQuery<>(em);
		 final QMovie movie = QMovie.movie;
		 return query
				 	.from(movie)
				 	.where(movie.year.eq(year))
				 	.fetch();
	}

	@Override
	public List<Movie> getAllMovieByYearOrGene(Integer year, String genre) {
		final JPAQuery<Movie> query = new JPAQuery<>(em);
		final QMovie movie = QMovie.movie;
		return query
				 	.from(movie)
				 	.where(movie.year.eq(year)
				 				.or(movie.genre.eq(genre)))
				 	.orderBy(movie.year.asc())
				 	.fetch();
	}

	@Override
	public List<Tuple> getGenreAndCount() {
		final JPAQuery<Movie> query = new JPAQuery<>(em);
		final QMovie movie = QMovie.movie;
		return query
				 	.select(movie.genre,movie.genre.count())
				 	.from(movie)
				 	.groupBy(movie.genre)
				 	.fetch();
	}

	@Override
	public List<Movie> getAllMovieWhereGenresIn(List<String> genres) {
		//genres.stream().collect();
		final JPAQuery<Movie> query = new JPAQuery<>(em);
		final QMovie movie = QMovie.movie;
		return query
				 	.from(movie)
				 	.where(movie.genre.in(genres))
				 	.fetch();
	}

	@Override
	public List<Movie> getAllMovieActoredBy(String fullName) {
		final JPAQuery<Movie> query = new JPAQuery<>(em);
		final QMovie movie = QMovie.movie;
		final QActor actor = QActor.actor;
		return query
				 	.from(movie)
				 	.leftJoin(movie.actors,actor)
				 	.where(actor.fullName.eq(fullName))
				 	.fetch();
	}

	@Override
	public void deleteMovieById(Long id) {
		final QMovie movie = QMovie.movie;
		this.queryFactory
				.delete(movie)
				.where(movie.id.eq(id))
				.execute();
					
	}
	@Override
	public void updateTitleById(String title, Long id) {
		final QMovie movie = QMovie.movie;
		this.queryFactory
				.update(movie)
				.where(movie.id.eq(id))
				.set(movie.title, title)
				.execute();
		
	}
}

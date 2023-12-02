package com.turing.jpa.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.persister.collection.mutation.RowMutationOperations.Restrictions;

import org.springframework.data.jpa.domain.Specification;

import com.turing.jpa.demo.model.*;
import com.turing.jpa.demo.model.entity.Movie;
import com.turing.jpa.demo.model.entity.Actor;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Order;
public class MovieSpecification {
	 public static Specification<Movie> getMovieByYear(Long i) {
		return new Specification<Movie>() {
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Movie> root,
					CriteriaQuery<?> query, 
					CriteriaBuilder cb) {
				return cb.equal(root.<Long>get("year"), i);
			}
			
		};  
	 }
	 public static Specification<Movie> getMovieByGenereOrYear(String genre,Long year) {
			return new Specification<Movie>() {
				private static final long serialVersionUID = 1L;

				@Override
				public Predicate toPredicate(Root<Movie> root,
						CriteriaQuery<?> query, 
						CriteriaBuilder cb) {
					ArrayList<Predicate> predicates = new ArrayList<Predicate>();
					if(genre != null)
					{
						predicates.add(cb.equal(root.get("genre"), genre));
					}
					if(year != null)
					{
						predicates.add(cb.equal(root.get("year"), year));
					}
					Predicate or = cb.or(predicates.toArray(new Predicate[] {}));
					query.where(or);
					return or;
				}
				
			};  
		 }
	 public static Specification<Movie> getMovieByTitle(String title) {
		    return (root, query, builder) -> {
		      return builder.like(root.get("title"), "%"+title+"%");
		  };
	 }
	 public static Specification<Movie> getMovieNotGenere(String genre) {
		    return (root, query, builder) -> {
		      return builder.not(
		    		  builder.like(root.get("genre"), "%"+genre+"%")
		    		  );
		  };
	 }
	 public static Specification<Movie> getMovieInGenere(List<String> genres) {
		    return (root, query, builder) -> {
		    In<String> inClause = builder.in(root.get("genre"));	
		    for (String genre : genres) {
		        inClause.value(genre);
		    }
		    return inClause;
		  };
	 }
	 public static Specification<Movie> getMovieWhereActorIn(String actor) {
		    return (root, query, builder) -> {
		    Join<Movie, Actor> actors = root.join("actors");
		    return builder.equal(actors.get("fullName"), actor);
		  };
	 }
	 public static Specification<Movie> getMovieGroupByGenere(String genres) {
		    return (root, query, builder) -> {
		   
		    query.orderBy(builder.asc(root.get("genre")));
		    return query.getRestriction();
		  };
	 }
}

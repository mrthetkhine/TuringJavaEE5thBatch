package com.turing.jpa.demo.dao;

import org.springframework.data.jpa.domain.Specification;

import com.turing.jpa.demo.model.*;
import com.turing.jpa.demo.model.entity.Movie;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

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
}

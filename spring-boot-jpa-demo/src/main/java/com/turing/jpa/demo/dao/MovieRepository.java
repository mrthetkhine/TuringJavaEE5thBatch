package com.turing.jpa.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.turing.jpa.demo.model.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}

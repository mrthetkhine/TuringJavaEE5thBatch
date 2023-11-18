package com.turing.jpa.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turing.jpa.demo.model.entity.Actor;
import com.turing.jpa.demo.model.entity.Movie;

public interface ActorRepository extends JpaRepository<Actor, Long>{
	List<Actor> findByAgeGreaterThan(Integer age);
}

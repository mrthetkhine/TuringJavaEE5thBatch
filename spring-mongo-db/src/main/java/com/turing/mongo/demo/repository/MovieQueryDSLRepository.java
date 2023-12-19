package com.turing.mongo.demo.repository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import com.turing.mongo.demo.model.*;

public interface MovieQueryDSLRepository extends CrudRepository<Movie,String>,QuerydslPredicateExecutor<Movie>{

}

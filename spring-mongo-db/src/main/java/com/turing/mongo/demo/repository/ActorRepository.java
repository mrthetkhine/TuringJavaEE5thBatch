package com.turing.mongo.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.turing.mongo.demo.model.Actor;
import com.turing.mongo.demo.model.Movie;

public interface ActorRepository extends ReactiveMongoRepository<Actor,String>{

}

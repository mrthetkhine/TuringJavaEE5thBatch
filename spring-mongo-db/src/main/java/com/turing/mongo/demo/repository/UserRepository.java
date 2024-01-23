package com.turing.mongo.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.turing.mongo.demo.model.User;

import reactor.core.publisher.Mono;


@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
	Mono<User> findByUsername(String username);
}

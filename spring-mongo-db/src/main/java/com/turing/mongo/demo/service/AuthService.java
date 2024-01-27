package com.turing.mongo.demo.service;

import com.turing.mongo.demo.model.User;
import com.turing.mongo.demo.security.jwt.JWTToken;

import reactor.core.publisher.Mono;

public interface AuthService {
	Mono<JWTToken> register(User user);
	Mono<JWTToken> login(User user);
	
}

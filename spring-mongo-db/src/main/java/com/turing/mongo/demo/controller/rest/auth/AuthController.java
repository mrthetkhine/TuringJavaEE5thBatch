package com.turing.mongo.demo.controller.rest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.turing.mongo.demo.model.User;
import com.turing.mongo.demo.repository.UserRepository;
import com.turing.mongo.demo.security.jwt.JWTReactiveAuthenticationManager;
import com.turing.mongo.demo.security.jwt.JWTToken;
import com.turing.mongo.demo.security.jwt.TokenProvider;
import com.turing.mongo.demo.service.AuthService;

import jakarta.validation.Valid;
import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@CrossOrigin(value = { "http://localhost:4200/" })
@RestController
@Slf4j
public class AuthController {

    private final Validator validation;

	@Autowired
	AuthService authService;
	
    public AuthController(Validator validation) {
    
        this.validation = validation;
    }
    @RequestMapping("/register")
    @PostMapping
    public Mono<JWTToken> register(@Valid @RequestBody User user) {
    	log.info("register");
        if (!this.validation.validate(user).isEmpty()) {
            return Mono.error(new RuntimeException("Bad request"));
        }
        return this.authService.register(user);
    }
    
   
    @RequestMapping("/login")
    @PostMapping
    public Mono<JWTToken> login(@Valid @RequestBody User user) {
    	log.info("login");
        if (!this.validation.validate(user).isEmpty()) {
            return Mono.error(new RuntimeException("Bad request"));
        }

        return this.authService.login(user);
    }
}

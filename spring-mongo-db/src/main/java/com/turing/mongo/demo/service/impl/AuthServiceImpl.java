package com.turing.mongo.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.turing.mongo.demo.controller.rest.auth.AuthController;
import com.turing.mongo.demo.model.User;
import com.turing.mongo.demo.repository.UserRepository;
import com.turing.mongo.demo.security.jwt.JWTReactiveAuthenticationManager;
import com.turing.mongo.demo.security.jwt.JWTToken;
import com.turing.mongo.demo.security.jwt.TokenProvider;
import com.turing.mongo.demo.service.AuthService;

import jakarta.validation.Validator;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService{

	private final TokenProvider tokenProvider;
    private final JWTReactiveAuthenticationManager authenticationManager;
    
    @Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;

    public AuthServiceImpl(TokenProvider tokenProvider,
            JWTReactiveAuthenticationManager authenticationManager,
            Validator validation) {
		this.tokenProvider = tokenProvider;
		this.authenticationManager = authenticationManager;
	}
    
    @Override
	public Mono<JWTToken> register(User user) {
		return this.userRepository.findByUsername(user.getUsername())
			    .map(userEntity->{
					throw new RuntimeException("User already exist");
				})
			    .switchIfEmpty(Mono.defer(()->this.registerUser(user)))
			    .cast(User.class)
			    .flatMap(saveUser->{
			    	log.info("New user have been saved "+saveUser);
			    	return this.login(user);
			    });
	}
	 Mono<User> registerUser(User user)
	    {
	    	User saveUser = new User();
	    	saveUser.setUsername(user.getUsername());
	    	saveUser.setPassword(this.passwordEncoder.encode(user.getPassword()));
	    	saveUser.setEmail(user.getEmail());
	    	saveUser.setRoles(user.getRoles());
	    	return this.userRepository.save(saveUser);
	    }
	@Override
	public Mono<JWTToken> login(User user) {
		Authentication authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        Mono<Authentication> authentication = this.authenticationManager.authenticate(authenticationToken);
        authentication.doOnError(throwable -> {
            throw new BadCredentialsException("Bad crendentials");
        });
        ReactiveSecurityContextHolder.withAuthentication(authenticationToken);

        return authentication.map(auth -> {
            String jwt = tokenProvider.createToken(auth);
            return new JWTToken(jwt);
        });
	}

}

package com.turing.mongo.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.turing.mongo.demo.model.User;
import com.turing.mongo.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@Slf4j
public class ReactiveUserDetailsServiceImpl implements ReactiveUserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
    public Mono<UserDetails> findByUsername(String username) {
		log.info("FindBy username "+username);
        return userRepository.findByUsername(username)
                .filter(Objects::nonNull)
                .switchIfEmpty(Mono.error(new BadCredentialsException(String.format("User %s not found in database", username))))
                .doOnNext(data->{
                	System.out.println("User data "+data);
                })
                .map(this::createSpringSecurityUser);
    }
	private org.springframework.security.core.userdetails.User createSpringSecurityUser(User user) {
        List<GrantedAuthority> grantedAuthorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                grantedAuthorities);
    }
}

package com.turing.mongo.demo.reactive.webclient.model;

import com.turing.mongo.demo.dto.ActorDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {
	String email;
	String password;
}

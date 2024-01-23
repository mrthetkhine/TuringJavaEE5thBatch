package com.turing.mongo.demo.security.jwt;

import lombok.*;


@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JWTToken {
	private String token;
}

package com.turing.mongo.demo.dto;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto {
	
    String id;
	
	String firstName;
	String lastName;
}

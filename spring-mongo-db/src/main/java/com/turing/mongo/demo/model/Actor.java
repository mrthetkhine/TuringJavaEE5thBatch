package com.turing.mongo.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("actors")
@Data
public class Actor {
	@Id
    private String id;
	
	String firstName;
	String lastName;
}

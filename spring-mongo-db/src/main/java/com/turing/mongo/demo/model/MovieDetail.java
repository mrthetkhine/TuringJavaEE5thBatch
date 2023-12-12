package com.turing.mongo.demo.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Document("movie_detail")
public class MovieDetail {
	
	
	@Id
    private String id;
	 
    @NotBlank
    @Size(max = 140)
    private String details;
}

package com.turing.mongo.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
	 	@Id
	    private String id;

	    @NotBlank
	    @Size(max = 140)
	    private String name;
	    
	    @NotNull
	    private Integer year;

	    @NotNull
	    private String director;
	    
	    //@NotNull
	    private Date createdAt;
	    
	    //Reference model
	    @DBRef
	    private List<Actor> actors;
		
	    //embedded model
	    MovieDetail details;
	    
	    ArrayList<String> genres;

}

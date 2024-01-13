package com.turing.mongo.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.turing.mongo.demo.model.Actor;
import com.turing.mongo.demo.model.Movie;
import com.turing.mongo.demo.model.MovieDetail;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
	private String id;

    @NotBlank(message="movie name must not be blank")
    @Size(max = 140)
    private String name;
    
    @NotNull
    private Integer year;

    @NotNull
    private String director;
    
    //@NotNull
    private Date createdAt;
    
    MovieDetailsDto details;
    
    ArrayList<String> genres;
    
    private List<ActorDto> actors;
   

}

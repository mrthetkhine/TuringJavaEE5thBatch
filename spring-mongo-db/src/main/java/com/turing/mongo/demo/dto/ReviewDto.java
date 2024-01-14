package com.turing.mongo.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.turing.mongo.demo.model.Actor;
import com.turing.mongo.demo.model.Movie;
import com.turing.mongo.demo.model.MovieDetail;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
	private String id;
	
	@NotBlank(message="movie Id should not be blank")
	String movieId;
	
	@NotBlank(message="movie review should not be blank")
	String review;
	
	@NotNull(message="movie rating should not be blank")
	Integer rating;
}

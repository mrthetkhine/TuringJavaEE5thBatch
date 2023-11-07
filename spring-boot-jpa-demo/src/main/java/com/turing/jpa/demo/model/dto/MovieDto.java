package com.turing.jpa.demo.model.dto;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MovieDto {
	
	Long id;
	
	@NotBlank(message = "{required.movie.title}")
	@Size(min = 3, max = 100, message 
      = "{size.movie.title}")
	String title;
	
	@NotNull(message = "{required.movie.year}")
	Integer year;

	@NotBlank(message = "{required.movie.genre}")
	String genre;
	
	Date createdAt;

	Date updatedAt;
}

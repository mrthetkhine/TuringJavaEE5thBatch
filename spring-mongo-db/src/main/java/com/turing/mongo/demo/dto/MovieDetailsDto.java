package com.turing.mongo.demo.dto;

import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetailsDto {
	@Id
    private String id;
	 
    @NotBlank
    @Size(max = 140)
    private String details;
}

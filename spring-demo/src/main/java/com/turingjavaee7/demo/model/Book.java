package com.turingjavaee7.demo.model;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@NotBlank(message = "{required.book.id}")
	String id;
	
	@NotBlank(message = "{required.book.title}")
	@Size(min = 3, max = 100, message 
      = "{size.book.title}")
	String title;
	
	@NotBlank(message = "{required.book.author}")
	String author;
}

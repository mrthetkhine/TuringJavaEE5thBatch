package com.turingjavaee7.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
	String id;
	String title;
	String author;
}

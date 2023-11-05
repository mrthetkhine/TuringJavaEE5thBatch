package com.turing.jpa.demo.model.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Movie implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	Long id;
	
	@Column
	String title;
	
	@Column
	Integer year;
	
	@Column
	String genre;
	
	@Column
	Date createdAt;
	
	@Column
	Date updatedAt;
}

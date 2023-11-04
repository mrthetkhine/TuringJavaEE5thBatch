package com.turingjavaee7.demo.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table
public class Post implements Serializable{

	private static final long serialVersionUID = 1L;

	 @Id
     private Long id;
	 
	 @Column
	 private String title;
	 
	 @Column
	 private String content;
}

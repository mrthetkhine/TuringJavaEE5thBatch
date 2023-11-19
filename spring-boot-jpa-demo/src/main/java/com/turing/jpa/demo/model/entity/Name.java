package com.turing.jpa.demo.model.entity;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.ToString;

@ToString
@Embeddable
public class Name {
	@Column
	//@ColumnTransformer(read="UPPER(first_name)")
	private String firstName;
	
	@Column
	private String lastName;
	
	@Formula(value = "CONCAT(first_name,\" \",last_name)")
	private String fullName;
}

package com.turing.jpa.demo.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@MappedSuperclass
public class Human extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column
	//@ColumnTransformer(read="UPPER(first_name)")
	private String firstName;
	
	@Column
	private String lastName;
	
	@Formula(value = "CONCAT(first_name,\" \",last_name)")
	private String fullName;
	
	@Column
	private Date birthday;
}

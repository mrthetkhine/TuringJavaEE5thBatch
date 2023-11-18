package com.turing.jpa.demo.model.entity;

import java.util.Date;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.ToString;

@Data
@ToString//(callSuper=true)
@Entity
public class Actor extends BaseEntity{
	private static final long serialVersionUID = 1L;

	@Column
	//@ColumnTransformer(read="UPPER(first_name)")
	private String firstName;
	
	@Column
	private String lastName;
	
	@Formula(value = "CONCAT(first_name,\" \",last_name)")
	private String fullName;
	
	@Column
	private String gender;
	
	@Column
	private Date birthday;
	
	@Formula(value="DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(), birthday)), '%Y') + 0")
	Integer age;
}

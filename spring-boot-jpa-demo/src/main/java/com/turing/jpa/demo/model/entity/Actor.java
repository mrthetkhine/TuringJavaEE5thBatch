package com.turing.jpa.demo.model.entity;

import java.util.Date;
import java.util.List;



import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper=true)
@Entity
public class Actor extends Human{
	private static final long serialVersionUID = 1L;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Formula(value="DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(), birthday)), '%Y') + 0")
	Integer age;
	
	@ToString.Exclude
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, 
				cascade = CascadeType.ALL, 
				mappedBy = "actors")
	private List<Movie> movies;
}

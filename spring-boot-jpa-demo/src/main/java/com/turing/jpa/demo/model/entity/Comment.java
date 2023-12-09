package com.turing.jpa.demo.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@Data
@Slf4j
@EqualsAndHashCode(callSuper=true)
public class Comment extends BaseEntity{

	private static final long serialVersionUID = 1L;
	
	@Column
	private String comment;

	@JsonIgnore
	@ToString.Exclude
	@ManyToOne(
			cascade= CascadeType.ALL
			)
	@JoinColumn(name="movie_id")
	Movie movie;
}

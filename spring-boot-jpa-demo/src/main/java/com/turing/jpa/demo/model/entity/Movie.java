package com.turing.jpa.demo.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString//(callSuper=true)
@Entity
@EqualsAndHashCode(callSuper=true)
public class Movie extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column
	private String title;

	@Column(nullable = false)
	private Integer year;

	@Column
	private String genre;

	@Transient
	private String something;

	@OneToOne(mappedBy = "movie", 
			cascade = { CascadeType.ALL }, 
			fetch = FetchType.LAZY, 
			optional = false,
			orphanRemoval=true)
	private MovieDetails movieDetails;
	
	@OneToMany(
			cascade= CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.LAZY 
			)
	@JoinColumn(name="movie_id")
	List<Comment> comments;

	@ManyToMany(
			fetch=FetchType.LAZY,
			cascade=CascadeType.ALL)
	@JoinTable(name="actor_in_movie",
			joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "actor_id") })
	List<Actor> actors;
}

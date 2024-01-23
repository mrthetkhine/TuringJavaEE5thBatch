package com.turing.mongo.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import org.springframework.data.mongodb.core.mapping.Document;

//@Jacksonized 
//@Builder
//@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  private String id;

  @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
  private String username;

 
  private String email;

  @Size(min = 4, message = "Minimum password length: 8 characters")
  private String password;

 
  private List<Role> roles;


	public String getId() {
		return id;
	}
	
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	

	  
}

package com.turing.jpa.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@Entity
@EqualsAndHashCode(callSuper=true)
public class BankAccount extends BaseEntity{
	private static final long serialVersionUID = 1L;
	
	@Column
	private String accountName;
	
	@Column
	private Double balance;
}

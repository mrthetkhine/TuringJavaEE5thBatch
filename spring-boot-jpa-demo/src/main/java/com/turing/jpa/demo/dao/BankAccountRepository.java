package com.turing.jpa.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turing.jpa.demo.model.entity.Actor;
import com.turing.jpa.demo.model.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long>{

}

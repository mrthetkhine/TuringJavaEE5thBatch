package com.turing.jpa.demo.service.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.turing.jpa.demo.dao.BankAccountRepository;
import com.turing.jpa.demo.model.entity.BankAccount;
import com.turing.jpa.demo.model.entity.Movie;
import com.turing.jpa.demo.service.TransactionDemoService;

@Service
public class TransactionDemoServiceImpl implements TransactionDemoService{

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	BankAccountRepository bankAccountRepository;
	/*
	@Override
	public void saveMovie(Movie movie) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		try
		{
			session.save(movie);
			this.anotherMethod();
			session.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		session.close();
	}*/
	@Transactional
	@Override
	public void saveMovie(Movie movie) {
		Session session = this.sessionFactory.openSession();
		session.save(movie);
		//this.anotherMethod();
		session.close();
	}
	void anotherMethod()
	{
		throw new RuntimeException("Something got wrong");
	}
	@Transactional(rollbackFor = BusinessLogicException.class
			/*,noRollbackFor=Exception.class*/)
	@Override
	public void sendMoney(Long fromAccount, Long toAccount, Double amount)throws BusinessLogicException {
		
		this.credit(toAccount, amount);
		this.debit(fromAccount, amount);
		//anotherMethod();
	}
	void debit(Long account,Double amount)throws BusinessLogicException
	{
		BankAccount bankAccount = this.bankAccountRepository.getById(account);
		if(bankAccount.getBalance() >= amount)
		{
			bankAccount.setBalance( bankAccount.getBalance()-amount);
			this.bankAccountRepository.save(bankAccount);
		}
		else
		{
			throw new BusinessLogicException("Invalid balance for debit");
		}
	}
	void credit(Long account,Double amount)throws BusinessLogicException
	{
		BankAccount bankAccount = this.bankAccountRepository.getById(account);
		if(amount>=0)
		{
			bankAccount.setBalance( bankAccount.getBalance()+amount);
			this.bankAccountRepository.save(bankAccount);
		}
		else
		{
			throw new BusinessLogicException("Invalid amount for credit");
		}
	}
}

package com.turing.jpa.demo.service;

import com.turing.jpa.demo.model.entity.Movie;
import com.turing.jpa.demo.service.impl.BusinessLogicException;

public interface TransactionDemoService {
	void saveMovie(Movie movie);
	void sendMoney(Long fromAccount, Long toAccount, Double amount)throws BusinessLogicException;
}

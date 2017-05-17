package com.accenture.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.banking.model.Account;
import com.accenture.banking.model.Transaction;
import com.accenture.banking.respository.OfficeRepository;
import com.accenture.banking.respository.TransactionRepository;
import com.accenture.banking.service.TransactionService;


@Service ("transactionService")
@Transactional
public class TransactionServiceImpl implements TransactionService{
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public Page<Transaction> findAll(String description, Long amountH, Long amountL,  Long officeId, Long accountId, Pageable pageable) {
				
		
		return transactionRepository.findAll(description, amountH,amountL,  officeId,  accountId, pageable);		
	}

	@Override
	public Double findAvg(String description, Long amountH, Long amountL, Long officeId, Long accountId) {
		return transactionRepository.findAvg(description, amountH, amountL, officeId, accountId);	
	}
}

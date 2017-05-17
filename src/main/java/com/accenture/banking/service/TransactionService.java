package com.accenture.banking.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.accenture.banking.model.Account;
import com.accenture.banking.model.Transaction;

public interface TransactionService {
	Page<Transaction> findAll(Long officeId, Long accountId, Pageable pageable);
	
	Double findAvg(Long officeId, Long accountId);
}

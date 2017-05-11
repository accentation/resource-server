package com.accenture.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.banking.respository.AccountRepository;

/**
 * Service layer implementation to develop all business methods regarding
 * Accounts.
 * 
 * @author r.lazcano.pello
 *
 */

@Service ("accountService")
@Transactional
public class AccountServiceImp {
	@Autowired
	private AccountRepository accountRepository;


	/**
	 * Return account by Id
	 * 
	 * @param id:
	 *            id of the entity
	 * @return Office
	 */
	@Override
	public Account getAccountById(Long id) {
		return this.accountRepository.findOne(id);
	}

}

package com.accenture.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.banking.model.Account;
import com.accenture.banking.respository.AccountRepository;
import com.accenture.banking.service.AccountService;

/**
 * Service layer implementation to develop all business methods regarding
 * Accounts.
 * 
 * @author r.lazcano.pello
 *
 */

@Service("accountService")
@Transactional
public class AccountServiceImp implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account getAccountByIban(String iban) {
		
		
		
		Account newAccount = this.accountRepository.findByIbanAllIgnoringCase(iban);
		
		
		System.out.println(" cuenta " + newAccount.getIban());
		
		return this.accountRepository.findByIbanAllIgnoringCase(iban);
	}
	@Override
	public Account getAccountById(Long id) {
		return this.accountRepository.findOne(id);
	}

}

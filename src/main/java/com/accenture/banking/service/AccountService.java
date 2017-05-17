package com.accenture.banking.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.accenture.banking.model.Account;
import com.accenture.banking.model.Office;

public interface AccountService {

	
	Account getAccountByIban(Long officeId, String iban);
	Account getAccountById(Long officeId,Long id);
//	Page <Account> findByOfficeId(long officeId, Pageable pageable);
	Page<Account> listAllByOfficeId(long officeId, Pageable pageable);
//	Page<Account> listAllByClientId(long clientId, Pageable pageable);
	Page<Account> listAllByClientId(long clientId,Pageable pageable);
	

}

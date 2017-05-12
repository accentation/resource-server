package com.accenture.banking.service;

import com.accenture.banking.model.Account;

public interface AccountService {

	
	Account getAccountByIban(String iban);
	Account getAccountById(Long id);

}

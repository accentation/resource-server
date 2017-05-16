package com.accenture.banking.service.impl;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.banking.model.Account;
import com.accenture.banking.model.Office;
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
	public Account getAccountByIban(Long officeId, String iban) {

		Account newAccount = this.accountRepository.findByIbanAllIgnoringCase(iban);
		if (!newAccount.getOffice().getId().equals(officeId)) {
			newAccount = null;
		}

		return this.accountRepository.findByIbanAllIgnoringCase(iban);
	}

	@Override
	public Account getAccountById(Long officeId, Long id) {
		Account newAccount = this.accountRepository.findOne(id);
		if (!newAccount.getOffice().getId().equals(officeId)) {
			newAccount = null;
		}
		return newAccount;
	}

	@Override
	public Page<Account> listAllByOfficeId(long officeId,Pageable pageable) {
		return accountRepository.findByOfficeId(officeId, pageable);
		//Page<User> findByOfficeId(long officeId, Pageable pageable);
	}

}

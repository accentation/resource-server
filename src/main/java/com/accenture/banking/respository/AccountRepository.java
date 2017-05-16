package com.accenture.banking.respository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.banking.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Page<Account> findAll(Pageable pageable);

	Account findByIbanAllIgnoringCase(String iban);
//	Account findByIdAllIgnoringCase(long id);
}

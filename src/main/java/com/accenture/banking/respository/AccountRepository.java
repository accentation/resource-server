package com.accenture.banking.respository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accenture.banking.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Page<Account> findAll(Pageable pageable);

	Account findByIbanAllIgnoringCase(String iban);
	// Account findByIdAllIgnoringCase(long id);

	Page<Account> findByOfficeId(long officeId, Pageable pageable);

	//Page<Account> listAllByClientId(long clientId, long accountId, Pageable pageable);

	@Query("SELECT a FROM Account a, AccountClient ac WHERE((a.id) = ac.id.accountId) AND (ac.client.id) = :idClient)")
	Page<Account> findByClientId(@Param("idClient") Long clientId, Pageable pageable);
}

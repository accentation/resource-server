package com.accenture.banking.respository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accenture.banking.model.Account;
import com.accenture.banking.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	//@Query("SELECT p FROM Transaction p WHERE(p.account.id = :idAccount ) AND (p.account.office.id = :idOffice))")
	Page<Transaction> findAll(String description, Long amountH, Long amountL,  Long officeId, Long accountId, Pageable pageable);
	
	
//	@Query("SELECT AVG(p.amount) FROM Transaction p WHERE(p.account.id = :idAccount ) AND (p.account.office.id = :idOffice))")
//	Double findAvg(@Param("idOffice") Long officeId,@Param("idAccount") Long accountId);


	Double findAvg(String description, Long amountH, Long amountL, Long officeId, Long accountId);
}




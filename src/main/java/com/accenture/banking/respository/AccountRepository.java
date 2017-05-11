package com.accenture.banking.respository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.banking.model.Office;

public interface AccountRepository extends JpaRepository<Office, Long> {

	Page<Office> findAll(Pageable pageable);

	Account findByIbanAllIgnoringCase(String address);
}

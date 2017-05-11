package com.accenture.banking.respository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.banking.model.Office;

public interface OfficeRepository extends JpaRepository<Office, Long> {

	Page<Office> findAll(Pageable pageable);

	Office findByAddressAllIgnoringCase(String address);

}

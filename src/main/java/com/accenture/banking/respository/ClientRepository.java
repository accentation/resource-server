package com.accenture.banking.respository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.accenture.banking.model.Account;
import com.accenture.banking.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	Page<Client> findAll(Pageable pageable);

	Client findByNameAllIgnoringCase(String name);

	Client findByNameAndSurname(String name, String surname);

}

package com.accenture.banking.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.accenture.banking.model.Client;

public interface ClientService {

	Page<Client> listAllByPage(Pageable pageable);

	Client getClientById(Long id);

	Client getClientByName(String name);

	Client getClientByNameSurname(String name, String surname);

}

package com.accenture.banking.service;

import com.accenture.banking.model.Client;

public interface ClientService {
	
	Client getClientById(Long id);
	
	Client getClientByName(String name);
	
	Client getClientByNameSurname(String name, String surname);

}

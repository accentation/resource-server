package com.accenture.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.banking.model.Client;
import com.accenture.banking.respository.ClientRepository;
import com.accenture.banking.service.ClientService;

@Service ("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	
	/**
	 * Return client by Id
	 * 
	 * @param id:
	 *            id of the entity
	 * @return Client
	 */
	@Override
	public Client getClientById(long id) {
		return this.clientRepository.findOne(id);
	}

}

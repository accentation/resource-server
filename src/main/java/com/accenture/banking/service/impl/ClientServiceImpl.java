package com.accenture.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.banking.model.Client;
import com.accenture.banking.respository.ClientRepository;
import com.accenture.banking.service.ClientService;

@Service("clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;

	/**
	 * Return paged client
	 * 
	 * @param pageable:
	 * 
	 * @return Page<Client>
	 */
	@Override
	public Page<Client> listAllByPage(Pageable pageable) {
		return clientRepository.findAll(pageable);
	}

	/**
	 * Return client by Id
	 * 
	 * @param id:
	 *            id of the entity
	 * @return Client
	 */
	@Override
	public Client getClientById(Long id) {
		return this.clientRepository.findOne(id);
	}

	@Override
	public Client getClientByName(String name) {
		return this.clientRepository.findByNameAllIgnoringCase(name);
	}

	@Override
	public Client getClientByNameSurname(String name, String surname) {
		return this.clientRepository.findByNameAndSurname(name, surname);
	}

}

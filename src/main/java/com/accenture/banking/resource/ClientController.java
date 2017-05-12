package com.accenture.banking.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.banking.model.Client;
import com.accenture.banking.resource.builder.EntityToDtoBuilder;
import com.accenture.banking.resource.dto.ClientDto;
import com.accenture.banking.service.ClientService;

@RestController
@RequestMapping("/offices/clients")
public class ClientController {

	@Autowired
	private EntityToDtoBuilder dtoBuilder;

	@Autowired
	private ClientService clientService;

	/**
	 * This method returns a Client by Id given
	 * 
	 * @return ClientDto
	 */
	@RequestMapping(value = "{clientId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientDto> getOfficeById(@PathVariable("clientId") Long clientId) {
		Client client = this.clientService.getClientById(clientId);
		if (client == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		ClientDto dto = dtoBuilder.buildClientDto(client);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
/*
	@RequestMapping(value = "name/{clientName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientDto> getOfficeByName(@PathVariable("clientName") String name) {
		Client client = this.clientService.getClientByName(name);
		if (client == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		ClientDto dto = dtoBuilder.buildClientDto(client);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@RequestMapping(value = "/{clientName}/{clientSurname}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientDto> getOfficeByNameSurname(@PathVariable("clientName") String name, @PathVariable("clientSurname") String surname) {
		Client client = this.clientService.getClientByNameSurname(name, surname);
		if (client == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		ClientDto dto = dtoBuilder.buildClientDto(client);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	*/

}

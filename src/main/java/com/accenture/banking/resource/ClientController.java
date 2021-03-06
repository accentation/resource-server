package com.accenture.banking.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.banking.model.Account;
import com.accenture.banking.model.Client;
import com.accenture.banking.model.Office;
import com.accenture.banking.resource.builder.EntityToDtoBuilder;
import com.accenture.banking.resource.dto.AccountDto;
import com.accenture.banking.resource.dto.ClientDto;
import com.accenture.banking.resource.dto.OfficeDto;
import com.accenture.banking.service.AccountService;
import com.accenture.banking.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private EntityToDtoBuilder dtoBuilder;

	@Autowired
	private ClientService clientService;

	@Autowired
	private AccountService accountService;

	/**
	 * This method returns all paged Clients
	 * 
	 * @return Page<Client>
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	Page<ClientDto> list(Pageable pageable) {
		Page<Client> clients = clientService.listAllByPage(pageable);
		Page<ClientDto> dtoPage = clients.map(new Converter<Client, ClientDto>() {
			@Override
			public ClientDto convert(Client client) {

				ClientDto dto = dtoBuilder.buildClientDto(client);
				return dto;
			}

		});
		return dtoPage;
	}

	/**
	 * This method returns a Client by Id given
	 * 
	 * @return ClientDto
	 */
	@RequestMapping(value = "{clientId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ClientDto> getClientById(@PathVariable("clientId") Long clientId) {
		Client client = this.clientService.getClientById(clientId);
		if (client == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		ClientDto dto = dtoBuilder.buildClientDto(client);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@RequestMapping(value = "{clientId}/accounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	Page<AccountDto> listAccounts(@PathVariable("clientId") Long clientId, Pageable pageable) {
		Page<Account> accounts = accountService.listAllByClientId(clientId, pageable);
		Page<AccountDto> dtoPage = accounts.map(new Converter<Account, AccountDto>() {
			@Override
			public AccountDto convert(Account account) {

				AccountDto dto = dtoBuilder.buildAccountDto(account);
				return dto;
			}

		});
		return dtoPage;
	}

	/*
	 * @RequestMapping(value = "name/{clientName}", method = RequestMethod.GET,
	 * produces = MediaType.APPLICATION_JSON_VALUE) public
	 * ResponseEntity<ClientDto> getOfficeByName(@PathVariable("clientName")
	 * String name) { Client client = this.clientService.getClientByName(name);
	 * if (client == null) { return new ResponseEntity(HttpStatus.NOT_FOUND); }
	 * ClientDto dto = dtoBuilder.buildClientDto(client); return new
	 * ResponseEntity<>(dto, HttpStatus.OK); }
	 * 
	 * @RequestMapping(value = "/{clientName}/{clientSurname}", method =
	 * RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) public
	 * ResponseEntity<ClientDto>
	 * getOfficeByNameSurname(@PathVariable("clientName") String
	 * name, @PathVariable("clientSurname") String surname) { Client client =
	 * this.clientService.getClientByNameSurname(name, surname); if (client ==
	 * null) { return new ResponseEntity(HttpStatus.NOT_FOUND); } ClientDto dto
	 * = dtoBuilder.buildClientDto(client); return new ResponseEntity<>(dto,
	 * HttpStatus.OK); }
	 */

}

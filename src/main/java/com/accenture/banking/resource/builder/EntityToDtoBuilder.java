package com.accenture.banking.resource.builder;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.accenture.banking.model.Account;
import com.accenture.banking.model.Office;
import com.accenture.banking.model.Transaction;
import com.accenture.banking.resource.dto.AccountDto;

import com.accenture.banking.model.Client;

import com.accenture.banking.resource.dto.ClientDto;

import com.accenture.banking.resource.dto.OfficeDto;
import com.accenture.banking.resource.dto.TransactionDto;

@Component("entityToDtoBuilder")
public class EntityToDtoBuilder {

	public EntityToDtoBuilder() {
	}

	public OfficeDto buildOfficeDto(Office office) {
		OfficeDto dto = null;
		if (office != null) {
			dto = new OfficeDto();
			dto.setId(office.getId());
			dto.setAddress(office.getAddress());
			dto.setPhone(office.getPhone());
		}
		return dto;
	}

	public ClientDto buildClientDto(Client client) {
		ClientDto dto = null;
		if (client != null) {
			dto = new ClientDto();
			dto.setId(client.getId());
			dto.setName(client.getName());
			dto.setSurname(client.getSurname());
			dto.setCreated_datetime(client.getCreatedDatetime());
		}
		return dto;
	}

	public AccountDto buildAccountDto(Account account) {
		AccountDto dto = null;
		if (account != null) {
			dto = new AccountDto();
			dto.setId(account.getId());
			dto.setOffice(account.getOffice());
			dto.setIban(account.getIban());
			dto.setCreatedDatetime(account.getCreatedDatetime());
			dto.setDeletedDatetime(account.getDeletedDatetime());
			dto.setBalance(account.getBalance());
		}
		return dto;
	}
	
	public TransactionDto buildOfficeDto(Transaction transaction) {
		TransactionDto dto = null;
		if (transaction != null) {
			dto = new TransactionDto();	
			dto.setId(transaction.getId());
			dto.setAccountId(transaction.getAccount().getId());
			dto.setDescription(transaction.getDescription());
			dto.setDatetime(transaction.getDatetime());
			dto.setType(transaction.getType());
			dto.setAmount(transaction.getAmount());			
		}
		return dto;
	}
}

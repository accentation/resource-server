package com.accenture.banking.resource.builder;

import org.springframework.stereotype.Component;

import com.accenture.banking.model.Account;
import com.accenture.banking.model.Office;
import com.accenture.banking.resource.dto.AccountDto;
import com.accenture.banking.resource.dto.OfficeDto;

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

}

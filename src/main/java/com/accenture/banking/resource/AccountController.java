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
import com.accenture.banking.resource.builder.EntityToDtoBuilder;
import com.accenture.banking.resource.dto.AccountDto;
import com.accenture.banking.service.AccountService;

/**
 * Restful class controller for Accounts resources.
 * 
 * @author r.lazcano.pello
 * 
 */

@RestController
@RequestMapping("offices/{officeId}/accounts")
public class AccountController {
	@Autowired
	private EntityToDtoBuilder dtoBuilder;

	@Autowired
	private AccountService accountService;

	/**
	 * This method returns an Account by Id given
	 * 
	 * @return AccountDto
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long id,
			@PathVariable("officeId") Long officeId) {

		Account account = this.accountService.getAccountById(officeId, id);
		if (account == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		AccountDto dto = dtoBuilder.buildAccountDto(account);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	Page<AccountDto> list(Pageable pageable,@PathVariable("officeId") Long officeId) {
		Page<Account> accounts = accountService.listAllByOfficeId(officeId,pageable);
		Page<AccountDto> dtoPage = accounts.map(new Converter<Account, AccountDto>() {
			public AccountDto convert(Account account) {

				AccountDto dto = dtoBuilder.buildAccountDto(account);
				return dto;
			}
		});
		return dtoPage;
	}

}

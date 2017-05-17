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
import com.accenture.banking.model.Office;
import com.accenture.banking.model.Transaction;
import com.accenture.banking.resource.builder.EntityToDtoBuilder;
import com.accenture.banking.resource.dto.AccountDto;
import com.accenture.banking.resource.dto.OfficeDto;
import com.accenture.banking.resource.dto.TransactionDto;
import com.accenture.banking.service.OfficeService;
import com.accenture.banking.service.TransactionService;

@RestController
@RequestMapping("offices/{officeId}/accounts/{accountId}/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;	
	
	@Autowired
	private EntityToDtoBuilder dtoBuilder;	
	
	@RequestMapping(value="/",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity listAll(@PathVariable("officeId") Long officeId, @PathVariable("accountId") Long accountId, Pageable pageable){
		Page<Transaction> transaction = transactionService.findAll(officeId, accountId, pageable);		
		Page<TransactionDto> dtoPage = transaction.map(new Converter<Transaction, TransactionDto>() {
		    public TransactionDto convert(Transaction transaction) {
		    	TransactionDto 	dto = dtoBuilder.buildOfficeDto(transaction);
		        return dto;
		    }		
		});			
		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	} 
	
	@RequestMapping(value="/avg",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity transactionAvg(@PathVariable("officeId") Long officeId, @PathVariable("accountId") Long accountId, Pageable pageable){
		Double transaction = transactionService.findAvg(officeId, accountId);		
//		Page<TransactionDto> dtoPage = transaction.map(new Converter<Transaction, TransactionDto>() {
//		    public TransactionDto convert(Transaction transaction) {
//		    	TransactionDto 	dto = dtoBuilder.buildOfficeDto(transaction);
//		        return dto;
//		    }		
//		});			
		return new ResponseEntity<>(transaction, HttpStatus.OK);
	} 
	
	
}

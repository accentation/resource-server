package com.accenture.banking.resource.dto;

import java.io.Serializable;
import java.util.Date;

import com.accenture.banking.model.Office;

/**
 * DTO class to build Account JSON REST response
 * 
 * @author r.lazcano.pello
 *
 */
public class AccountDto {
	private Long id;
	private Office office;
	private String iban;
	private Date createdDatetime;
	private Date deletedDatetime;
	private long balance;

	public long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {

		this.office = new Office();
		this.office.setAddress(office.getAddress());
		this.office.setId(office.getId());
		this.office.setPhone(office.getPhone());
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public Date getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public Date getDeletedDatetime() {
		return deletedDatetime;
	}

	public void setDeletedDatetime(Date deletedDatetime) {
		this.deletedDatetime = deletedDatetime;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

}

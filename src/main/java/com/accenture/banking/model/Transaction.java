package com.accenture.banking.model;
// Generated 11-may-2017 15:04:59 by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Transaction generated by hbm2java
 */
@Entity
@Table(name = "transaction", catalog = "banking")
public class Transaction implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Account account;
	private Date datetime;
	private String description;
	private int type;
	private long amount;

	public Transaction() {
	}

	public Transaction(Long id, Account account, Date datetime, String description, int type, long amount) {
		this.id = id;
		this.account = account;
		this.datetime = datetime;
		this.description = description;
		this.type = type;
		this.amount = amount;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id", nullable = false, insertable = false, updatable = false)
	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "datetime", nullable = false, length = 19)
	public Date getDatetime() {
		return this.datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "type", nullable = false)
	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "amount", nullable = false)
	public long getAmount() {
		return this.amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

}

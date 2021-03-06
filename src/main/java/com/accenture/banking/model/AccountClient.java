package com.accenture.banking.model;
// Generated 11-may-2017 15:04:59 by Hibernate Tools 4.3.5.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * AccountClient generated by hbm2java
 */
@Entity
@Table(name = "account_client", catalog = "banking", uniqueConstraints = @UniqueConstraint(columnNames = { "account_id",
		"client_id", "type" }))
public class AccountClient implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private AccountClientId id;
	private Account account;
	private Client client;
	private int type;

	public AccountClient() {
	}

	public AccountClient(AccountClientId id, Account account, Client client, int type) {
		this.id = id;
		this.account = account;
		this.client = client;
		this.type = type;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "accountId", column = @Column(name = "account_id", nullable = false)),
			@AttributeOverride(name = "clientId", column = @Column(name = "client_id", nullable = false)) })
	public AccountClientId getId() {
		return this.id;
	}

	public void setId(AccountClientId id) {
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_id", nullable = false, insertable = false, updatable = false)
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Column(name = "type", nullable = false)
	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

}

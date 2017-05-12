package com.accenture.banking.model;
// Generated 11-may-2017 15:04:59 by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Client generated by hbm2java
 */
@Entity
@Table(name = "client", catalog = "banking")
public class Client implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;

	private long id;
	private String name;
	private String surname;
	private Date createdDatetime;
	private Date deletedDatetime;
	private Set<AccountClient> accountClients = new HashSet<AccountClient>(0);

	public Client() {
	}

	public Client(String name, String surname, Date createdDatetime) {
		this.name = name;
		this.surname = surname;
		this.createdDatetime = createdDatetime;
	}

	public Client(String name, String surname, Date createdDatetime, Date deletedDatetime,
			Set<AccountClient> accountClients) {
		this.name = name;
		this.surname = surname;
		this.createdDatetime = createdDatetime;
		this.deletedDatetime = deletedDatetime;
		this.accountClients = accountClients;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "surname", nullable = false, length = 45)
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_datetime", nullable = false, length = 19)
	public Date getCreatedDatetime() {
		return this.createdDatetime;
	}

	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "deleted_datetime", length = 19)
	public Date getDeletedDatetime() {
		return this.deletedDatetime;
	}

	public void setDeletedDatetime(Date deletedDatetime) {
		this.deletedDatetime = deletedDatetime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<AccountClient> getAccountClients() {
		return this.accountClients;
	}

	public void setAccountClients(Set<AccountClient> accountClients) {
		this.accountClients = accountClients;
	}

}

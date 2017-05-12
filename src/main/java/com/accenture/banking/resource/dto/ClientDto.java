package com.accenture.banking.resource.dto;

import java.util.Date;

public class ClientDto {

	private long id;
	private String name;
	private String surname;
	private Date created_datetime;
	private Date deleted_datetime;


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the created_datetime
	 */
	public Date getCreated_datetime() {
		return created_datetime;
	}

	/**
	 * @param created_datetime
	 *            the created_datetime to set
	 */
	public void setCreated_datetime(Date created_datetime) {
		this.created_datetime = created_datetime;
	}

	/**
	 * @return the deleted_datetime
	 */
	public Date getDeleted_datetime() {
		return deleted_datetime;
	}

	/**
	 * @param deleted_datetime
	 *            the deleted_datetime to set
	 */
	public void setDeleted_datetime(Date deleted_datetime) {
		this.deleted_datetime = deleted_datetime;
	}

}

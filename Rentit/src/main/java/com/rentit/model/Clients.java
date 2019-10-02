package com.rentit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clients {
	private Long clientid;
	private String first_name;
	private String last_name;
	private String licence_number;
	private String licence_validity;
	private String phone;
	private Long clerkid;
	
	
	protected Clients() {

	}
	
	public Clients(Long id, String first_name, String last_name, String licence_number, 
			String licence_validity, String phone, Long clerkid) {
		this.clientid = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.licence_number = licence_number;
		this.licence_validity = licence_validity;
		this.phone = phone;
		this.clerkid = clerkid;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getClientID() {
		return clientid;
	}


	public void setClientID(Long clientID) {
		this.clientid = clientID;
	}


	public String getFirstName() {
		return first_name;
	}


	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}


	public String getLastName() {
		return last_name;
	}


	public void setLastName(String lastName) {
		this.last_name = lastName;
	}


	public String getLicenceNumber() {
		return licence_number;
	}


	public void setLicenceNumber(String licenceNumber) {
		this.licence_number = licenceNumber;
	}


	public String getLicenceValidity() {
		return licence_validity;
	}


	public void setLicenceValidity(String licenceValidity) {
		this.licence_validity = licenceValidity;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getClerkID() {
		return clerkid;
	}

	public void setClerkID(Long clerkid) {
		this.clerkid = clerkid;
	}

}

package com.rentit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Clients {
	private Long client_id;
	private String first_name;
	private String last_name;
	private String licence_number;
	private String licence_validity;
	private String phone;
	
	
	protected Clients() {

	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getClientID() {
		return client_id;
	}


	public void setClientID(Long clientID) {
		this.client_id = clientID;
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

}

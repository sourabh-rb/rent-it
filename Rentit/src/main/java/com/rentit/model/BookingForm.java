package com.rentit.model;

public class BookingForm {
	private Long client_id;
	private String first_name;
	private String last_name;
	private String driver_license;
	private String expiration_date;
	private String phone_number;
	private String start_date;
	private String due_date;
	
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
		return driver_license;
	}


	public void setLicenceNumber(String licenceNumber) {
		this.driver_license = licenceNumber;
	}


	public String getLicenceValidity() {
		return expiration_date;
	}


	public void setLicenceValidity(String licenceValidity) {
		this.expiration_date = licenceValidity;
	}


	public String getPhone() {
		return phone_number;
	}


	public void setPhone(String phone) {
		this.phone_number = phone;
	}
	public String getstart_date() {
		return start_date;
	}


	public void setstart_date(String startdate) {
		this.start_date = startdate;
	}
	
	public String getdue_date() {
		return due_date;
	}


	public void setdue_date(String duedate) {
		this.due_date = duedate;
	}

}

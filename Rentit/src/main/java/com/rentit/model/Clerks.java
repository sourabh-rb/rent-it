package com.rentit.model;

/**
 * CLerks model class
 * @author Sourabh Rajeev Badagandi
 *
 */
public class Clerks {
	
	private Long id;
	private String first_name;
	private String last_name;
	private String username;
	private String password;
	private String email;
	
	public Clerks() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	

}

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
    private String usergroup;
	
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
	
	public void setFirstName(String firstname) {
		this.first_name = firstname;
	}
	public void setusergroup(String usergroup) {
		if(usergroup != null)
		this.usergroup = "admin";
		else {
			this.usergroup = "clerk";	
		}
	}
	public String getusergroup() {
		return this.usergroup;
	}
	public String getLastName() {
		return last_name;
	}
	
	public void setLastName(String lastname) {
		this.last_name = lastname;
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

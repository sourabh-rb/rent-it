package com.rentit.model;

public class registerform {

	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String emailid;
	private String clerkid;
	
	public String getFirstname(){
		return firstname;
	}
	public String getLastname(){
		return lastname;
	}
	public String getUSername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	public String getEmailid(){
		return emailid;
	}
	public String getClerkId(){
		return clerkid;
	}
	
	public void setFirstname() {
		this.firstname  = firstname;
	}
	public void setLastname() {
		this.lastname = lastname;
	}
	public void setUsername() {
		this.username = username;
	}
	public void setPassword() {
		this.password = password;
	}
	public void setEmailId() {
		this.emailid = emailid;
	}
	public void setClerkId() {
		this.clerkid = clerkid;
	}
}

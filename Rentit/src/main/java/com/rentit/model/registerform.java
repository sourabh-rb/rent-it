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
	
	public void setFirstname( String firstname) {
		this.firstname  = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmailId(String emailid) {
		this.emailid = emailid;
	}
	public void setClerkId(String clerkid) {
		this.clerkid = clerkid;
	}
}

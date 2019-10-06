package com.rentit.model;

/**
 * This class acts as model for registration and consits of setter and getter methods.
 * @author charan
 *
 */
public class Register {

	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String cpassword;
	
	/**
	 * This method is to get first name
	 * @return firstname
	 */
	public String getFirstname(){
		return firstname;
	}
	/**
	 * This method is to get last name
	 * @return lastname
	 */
	public String getLastname(){
		return lastname;
	}
	/**
	 * This method is to get username
	 * @return username
	 */
	public String getUSername(){
		return username;
	}
	/**
	 * This method is to get password
	 * @return password
	 */
	public String getPassword(){
		return password;
	}
	/**
	 * This method is to get confirm passowrd
	 * @return
	 */
	public String getcPassword(){
		return cpassword;
	}
	
	/**
	 * This method is to set firstname
	 * @param firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname  = firstname;
	}
	/**
	 * This method is to set last name
	 * @param lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * This method is to set username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * This method is to set password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public void setcPassword(String cpassword) {
		this.cpassword = cpassword;
	}
	
}

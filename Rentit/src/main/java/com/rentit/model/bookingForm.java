package com.rentit.model;

public class bookingForm {
	private String firstname;
	private String lastname;
	private String licensenumber;
	private String expiredate;
	private String emailid;
	private String phoneno;
	private String startdate;
	private String returndate;
	
	public String getFirstname(){
		return firstname;
	}
	public String getLastname(){
		return lastname;
	}
	public String getlicensenumber(){
		return licensenumber;
	}
	public String getexpiredate(){
		return expiredate;
	}
	public String getemailid(){
		return emailid;
	}
	public String getphoneno(){
		return phoneno;
	}
	public String getstartdate(){
		return startdate;
	}
	public String getreturndate(){
		return returndate;
	}
	
	
	public void setFirstname() {
		this.firstname  = firstname;
	}
	public void setLastname() {
		this.lastname = lastname;
	}
	public void setlicensenumber() {
		this.licensenumber = licensenumber;
	}
	public void setexpiredate() {
		this.expiredate = expiredate;
	}
	public void setemailid() {
		this.emailid = emailid;
	}
	public void setphoneno() {
		this.phoneno = phoneno;
	}
	public void setstartdate() {
		this.startdate = startdate;
	}
	public void setreturndate() {
		this.returndate = returndate;
	}
	
}

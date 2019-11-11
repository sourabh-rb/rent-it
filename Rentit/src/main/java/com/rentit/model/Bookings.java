package com.rentit.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * Bookings model class.
 * @author Anusha Keralapura Thandavamurthy
 *
 */
public class Bookings {
	private Long bookingid;
	private String bookingTS;
	private String returnDate;
	
	@NotNull
	private String startDate;
	
	@NotNull
	private String dueDate;
	private String cancelDate;
	private Long clientid;
	private Long vehicleid;
	
	public Bookings() {}
	
	public Bookings(Long id, String bookingTS, String returnDate,  @NotNull String startDate, 
			 @NotNull String dueDate, String cancelDate, Long clientid) {
		this.bookingid = id;
		this.bookingTS = bookingTS;
		this.returnDate = returnDate;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.cancelDate = cancelDate;
		this.clientid = clientid;
	}
	public Long getBookingid() {
		return bookingid;
	}
	public void setBookingid(Long bookingid) {
		this.bookingid = bookingid;
	}
	public String getBookingTS() {
		return bookingTS;
	}
	public void setBookingTS(String bookingTS) {
		this.bookingTS = bookingTS;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate( @NotNull String startDate) {
		this.startDate = startDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate( @NotNull String dueDate) {
		this.dueDate = dueDate;
	}
	public String getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}
	public Long getClientID() {
		return clientid;
	}
	public void setClientID(Long clientid) {
		this.clientid = clientid;
	}

  public Long getVehicleID() {
    return vehicleid;
  }

  public void setVehicleID(Long vehicleid) {
    this.vehicleid = vehicleid;
  }
	
	

}

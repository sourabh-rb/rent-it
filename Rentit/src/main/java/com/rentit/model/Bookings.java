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
	/**
	 * 
	 * @param id
	 * @param bookingTS
	 * @param returnDate
	 * @param startDate
	 * @param dueDate
	 * @param cancelDate
	 * @param clientid
	 */
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
	/**
	 * getter get booking id.
	 * @return
	 */
	public Long getBookingid() {
		return bookingid;
	}
	/**
	 * setter set booking id.
	 * @param bookingid
	 */
	public void setBookingid(Long bookingid) {
		this.bookingid = bookingid;
	}
	/**
	 * getter get booking time stamp.
	 * @return
	 */
	public String getBookingTS() {
		return bookingTS;
	}
	/**
	 * setter set booking time stamp.
	 * @param bookingTS
	 */
	public void setBookingTS(String bookingTS) {
		this.bookingTS = bookingTS;
	}
	/**
	 * getter get return date.
	 * @return
	 */
	public String getReturnDate() {
		return returnDate;
	}
	/**
	 * setter set return date.
	 * @param returnDate
	 */
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	/**
	 * getter get start date.
	 * @return
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * setter set start date.
	 * @param startDate
	 */
	public void setStartDate( @NotNull String startDate) {
		this.startDate = startDate;
	}
	/**
	 * getter get due date.
	 * @return
	 */
	public String getDueDate() {
		return dueDate;
	}
	/**
	 * setter set due date.
	 * @param dueDate
	 */
	public void setDueDate( @NotNull String dueDate) {
		this.dueDate = dueDate;
	}
	/**
	 * getter get cancel date.
	 * @return
	 */
	public String getCancelDate() {
		return cancelDate;
	}
	/**
	 * setter set cancel date.
	 * @param cancelDate
	 */
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}
	/**
	 * getter get client date.
	 * @return
	 */
	public Long getClientID() {
		return clientid;
	}
	/**
	 * setter set client id.
	 * @param clientid
	 */
	public void setClientID(Long clientid) {
		this.clientid = clientid;
	}
	/**
	 * getter get vehicle id.
	 * @return
	 */
  public Long getVehicleID() {
    return vehicleid;
  }
  /**
   * setter set vehicle id.
   * @param vehicleid
   */
  public void setVehicleID(Long vehicleid) {
    this.vehicleid = vehicleid;
  }
	
	

}

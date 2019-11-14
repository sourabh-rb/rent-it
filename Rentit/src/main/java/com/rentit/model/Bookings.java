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
	 * This method is to booking id.
	 * @return
	 */
	public Long getBookingid() {
		return bookingid;
	}
	/**
	 * tHis method set the booking id
	 * @param bookingid
	 */
	public void setBookingid(Long bookingid) {
		this.bookingid = bookingid;
	}
	/**
	 * This method is to get the timestamp
	 * @return
	 */
	public String getBookingTS() {
		return bookingTS;
	}
	/**
	 * This method sets the Time stamp
	 * @param bookingTS
	 */
	public void setBookingTS(String bookingTS) {
		this.bookingTS = bookingTS;
	}
	/**
	 * This method is to get the returndate
	 * @return
	 */
	public String getReturnDate() {
		return returnDate;
	}
	/**
	 * This method sets the return date.
	 * @param returnDate
	 */
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	/**
	 * This method is to get the startdate
	 * @return
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * This method is to set the start date
	 * @param startDate
	 */
	public void setStartDate( @NotNull String startDate) {
		this.startDate = startDate;
	}
	/**
	 * This method is to get the duedate.
	 * @return
	 */
	public String getDueDate() {
		return dueDate;
	}
	/**
	 * This method is to set the due date.
	 * @param dueDate
	 */
	public void setDueDate( @NotNull String dueDate) {
		this.dueDate = dueDate;
	}
	/**
	 * This method is to get the cancel date.
	 * @return
	 */
	public String getCancelDate() {
		return cancelDate;
	}
	/**
	 * This method is to set the cancel date.
	 * @param cancelDate
	 */
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}
	/**
	 * This method is to get the client id.
	 * @return
	 */
	public Long getClientID() {
		return clientid;
	}
	/**
	 * This method is to set the client id.
	 * @param clientid
	 */
	public void setClientID(Long clientid) {
		this.clientid = clientid;
	}
	/**
	 * This method is to get the vehicle id.
	 * @return
	 */
  public Long getVehicleID() {
    return vehicleid;
  }
    /**
     * This method is to set the vehicle id.
     * @param vehicleid
     */
  public void setVehicleID(Long vehicleid) {
    this.vehicleid = vehicleid;
  }
	
	

}

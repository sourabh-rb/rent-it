package com.rentit.model;

import java.util.Date;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * CLients model class
 * 
 * @author Sourabh Rajeev Badagandi
 * @version 1.0.0
 *
 */
//@Entity
public class Clients {
  private Long clientid;

  @NotNull
  @Size(min = 2, max = 30)
  private String first_name;

  @NotNull
  @Size(min = 2, max = 30)
  private String last_name;

  @NotNull
  private String licence_number;

  @NotNull
  private String licence_validity;

  @NotNull
  private String phone;

  private Long clerkid;
  
  private Long bookingId;
  
  private Long vehicleId;


  public Clients() {

  }

  public Clients(Long id, String first_name, String last_name, String licence_number,
      @NotNull String licence_validity, String phone, Long clerkid) {
    this.clientid = id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.licence_number = licence_number;
    this.licence_validity = licence_validity;
    this.phone = phone;
    this.clerkid = clerkid;
  }

 /**
  * Geeter client id.
  * @return
  */
 // @Id
 // @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Long getClientID() {
    return clientid;
  }

/**
 * Setter client id
 * @param clientID
 */
  public void setClientID(Long clientID) {
    this.clientid = clientID;
  }


  /**
   * getter client firstname
   * @return
   */
  public String getFirstName() {
    return first_name;
  }


  /**
   * Setter client first name
   * @param firstName
   */
  public void setFirstName(String firstName) {
    this.first_name = firstName;
  }


  /**
   * getter client last name
   * @return
   */
  public String getLastName() {
    return last_name;
  }

 /**
  * Setter client last name.
  * @param lastName
  */
  public void setLastName(String lastName) {
    this.last_name = lastName;
  }

 /**
  * getter get licence number.
  * @return
  */
  public String getLicenceNumber() {
    return licence_number;
  }


  /**
   * setter client licence number
   * @param licenceNumber
   */
  public void setLicenceNumber(String licenceNumber) {
    this.licence_number = licenceNumber;
  }


  /**
   * getter client licnece validity info.
   * @return
   */
  public String getLicenceValidity() {
    return licence_validity;
  }


  /**
   * setter client licnece validity info. 
   * @param date
   */
  public void setLicenceValidity(@NotNull String date) {
    this.licence_validity = date;
  }

/**
 * getter get phone
 * @return
 */
  public String getPhone() {
    return phone;
  }


  /**
   * setter set phone
   * @param phone
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * getter get clerk id.
   * @return
   */
  public Long getClerkID() {
    return clerkid;
  }

  /**
   * setter set clerk id.
   * @param clerkid
   */
  public void setClerkID(Long clerkid) {
    this.clerkid = clerkid;
  }

  public Long getBookingId() {
    return bookingId;
  }

  public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;
  }

  public Long getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(Long vehicleId) {
    this.vehicleId = vehicleId;
  }

}

package com.rentit.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Models wrapper class which interfaces models clients, bookings, vehicles and clerks.
 * 
 * @author Sourabh Rajeev Badagandi
 * @version 1.0.0
 *
 */
public class ModelWrapper {
  private Clients client;
  private Bookings booking;
  private Vehicles vehicle;
  private Clerks clerk;
  private ArrayList<Vehicles> catalogList;


  public ModelWrapper() {
    client = new Clients();
    booking = new Bookings();
    vehicle = new Vehicles();
    clerk = new Clerks();
    catalogList = new ArrayList<Vehicles>();
  }

  /**
   * Getter for vehicle catalog list.
   * 
   * @return
   */
  public ArrayList<Vehicles> getCatalogList() {
    return catalogList;
  }

  /**
   * Setter for vehicle catalog list.
   * 
   * @param result
   */
  public void setCatalogList(List<Vehicles> result) {
    this.catalogList = (ArrayList<Vehicles>) result;
  }

  /**
   * Getter for client record.
   * 
   * @return
   */
  public Clients getClient() {
    return client;
  }

  /**
   * Setter for client record.
   * 
   * @param client
   */
  public void setClient(Clients client) {
    this.client = client;
  }

  /**
   * Getter for booking record.
   * 
   * @return
   */
  public Bookings getBooking() {
    return booking;
  }

  /**
   * Setter for booking record.
   * 
   * @param booking
   */
  public void setBooking(Bookings booking) {
    this.booking = booking;
  }

  /**
   * Getter for vehicle record.
   * 
   * @return
   */
  public Vehicles getVehicle() {
    return vehicle;
  }

  /**
   * Setter for vehicle record.
   * 
   * @param vehicle
   */
  public void setVehicle(Vehicles vehicle) {
    this.vehicle = vehicle;
  }

  /**
   * Getter for clerk record.
   * 
   * @return
   */
  public Clerks getClerk() {
    return clerk;
  }

  /**
   * Setter for clerk record.
   * 
   * @param clerk
   */
  public void setClerk(Clerks clerk) {
    this.clerk = clerk;
  }



}

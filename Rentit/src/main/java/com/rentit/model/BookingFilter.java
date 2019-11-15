package com.rentit.model;

public class BookingFilter {
  private String clientFirstName;
  private String clientLastName;
  private String vehicleMake;
  private String vehicleModel;
  private String dueDate;
  private String startDate;
  
  /**
   * @return the clientFirstName
   */
  public String getClientFirstName() {
    return clientFirstName;
  }
  /**
   * @param clientFirstName the clientFirstName to set
   */
  public void setClientFirstName(String clientFirstName) {
    this.clientFirstName = clientFirstName;
  }
  /**
   * @return the vehicleMake
   */
  public String getVehicleMake() {
    return vehicleMake;
  }
  /**
   * @param vehicleMake the vehicleMake to set
   */
  public void setVehicleMake(String vehicleMake) {
    this.vehicleMake = vehicleMake;
  }
  /**
   * @return the dueDate
   */
  public String getDueDate() {
    return dueDate;
  }
  /**
   * @param dueDate the dueDate to set
   */
  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }
  /**
   * @return the startDate
   */
  public String getStartDate() {
    return startDate;
  }
  /**
   * @param startDate the startDate to set
   */
  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }
  /**
   * getter get client last name
   * @return
   */
  public String getClientLastName() {
    return clientLastName;
  }
  /**
   * setter set last name
   * @param clientLastName
   */
  public void setClientLastName(String clientLastName) {
    this.clientLastName = clientLastName;
  }
  /**
   * getter get vehicle model
   * @return
   */
  public String getVehicleModel() {
    return vehicleModel;
  }
  /**
   * setter set vehicle model
   * @param vehicleModel
   */
  public void setVehicleModel(String vehicleModel) {
    this.vehicleModel = vehicleModel;
  }

}


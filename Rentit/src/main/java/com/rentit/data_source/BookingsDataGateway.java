package com.rentit.data_source;

import com.rentit.model.Bookings;
import com.rentit.model.Clients;
import com.rentit.model.ModelWrapper;

/**
 * BookingsDataGateway is the gateway for bookings model and Booking Table in DB.
 * @author Anusha Keralapura Thandavamurthy
 * @version 1.0.0
 *
 */
public class BookingsDataGateway {
  
  private DatabaseConfig database;
  
  
  /**
   * This method is used to add entry into the Bookings table.
   * @param newBooking
   */
  public void addBooking(ModelWrapper newBooking) {
    database = DatabaseConfig.getDBInstance();
    String sqlCmd = "INSERT INTO bookings (returnDate, startDate, dueDate, cancelDate, clientid)";
    sqlCmd += " VALUES ( '" + newBooking.getBooking().getReturnDate() + "', '"
        +  newBooking.getBooking().getStartDate() + "', '" 
        + newBooking.getBooking().getDueDate() + "', '" 
        + newBooking.getBooking().getCancelDate() + "', '" 
        + newBooking.getClient().getClientID() + ")";
   
    database.updateCommand(sqlCmd);


  }
  

}

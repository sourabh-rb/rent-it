package com.rentit.data_source;

import com.rentit.model.Bookings;
import com.rentit.model.Clients;

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
   * @param book
   */
  public void addBooking(Bookings book) {
    database = DatabaseConfig.getDBInstance();
    String sqlCmd = "INSERT INTO clients (returnDate, startDate, dueDate, cancelDate, clientid)";
    sqlCmd += " VALUES ( '" + book.getReturnDate() + "', '"
        +  book.getStartDate() + "', '" 
        + book.getDueDate() + "', '" 
        + book.getCancelDate() + "', '" 
        + book.getClientID() + ")";
   
    database.updateCommand(sqlCmd);


  }
  

}

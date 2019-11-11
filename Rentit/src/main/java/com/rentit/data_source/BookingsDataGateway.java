package com.rentit.data_source;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
  
  private DatabaseConfig db;
  
  
  /**
   * This method is used to list all contents of client table.
   * @return clientData.
   */
  public ArrayList<ArrayList<String>> listAll() {
    db = DatabaseConfig.getDBInstance();  
    ResultSet rs= db.executeCommand("select * from bookings"); 

    ArrayList<ArrayList<String>> bookingData = new ArrayList<ArrayList<String>>();
    try {
      while(rs.next()) {
        ArrayList<String> entry = new ArrayList<String>();
        for(int i = 1; i <= 8; i++) {
          entry.add(rs.getString(i));
        }

        bookingData.add(entry);
      }

    } catch (SQLException e) {e.printStackTrace();}

    return bookingData;
  }
  
  /**
   * This method is used to add entry into the Bookings table.
   * @param newBooking
   */
  public void addEntry(Bookings booking) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd = "INSERT INTO bookings (bookingTS, returnDate, startDate, dueDate, cancelDate, clientId, vehicleId)";
    sqlCmd += " VALUES ( '" + booking.getBookingTS() + "', '"
        +  booking.getReturnDate() + "', '" 
        + booking.getStartDate() + "', '" 
        + booking.getDueDate() + "', '"
        + booking.getCancelDate() + "', '"
        + booking.getClientID() + ", "
        + booking.getVehicleID() + ")";
    
    db.updateCommand(sqlCmd);
  }
  
  /**
   * This method is used to remove entry from bookings table.
   * @param bookingID
   */
  public void removeEntry(Long bookingID) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd ="DELETE FROM bookings WHERE id = " + bookingID + ";" ;
    db.updateCommand(sqlCmd);


  }

  /**
   * This method is used to update entry from bookings table.
   * @param column
   * @param newValue
   * @param bookingID
   */
  public void updateEntry(String column, String newValue, Long bookingID) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd ="UPDATE bookings SET " + column + " = '" + newValue + "' WHERE id = " + bookingID + ";" ;

    db.updateCommand(sqlCmd);
  }
  
  public void removeClientandBookingEntry(Long id) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd = "DELETE bookings , clients  FROM bookings INNER JOIN clients ON bookings.clientId =  clients.id  WHERE bookings.clientId = " + id + ";";
    
    db.updateCommand(sqlCmd);
  }
  
  /**
   * This method returns a row from Bookings Table.
   * @param bookingID
   * @return
   */
  public ArrayList<String> getEntry(Long bookingID) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd ="SELECT * bookings WHERE id = " + bookingID + ";" ;
    ArrayList<String> rec = new ArrayList<String>();
    ResultSet rs = db.executeCommand(sqlCmd);
    int count = 1;
    try {
      while(rs.next()) {
          rec.add(rs.getString(count));
        
        count++;
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return rec; 
  }

  public String getValue(Long id, String column) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd ="SELECT " + column + " FROM bookings WHERE id = " + id + ";" ;
    String val = null;
    ResultSet rs = db.executeCommand(sqlCmd);
     try {
       while(rs.next()) {
         val = rs.getString(1);
       }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return val;
  }
  

}

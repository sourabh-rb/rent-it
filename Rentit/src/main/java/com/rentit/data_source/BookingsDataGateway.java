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
  public static String bkngid ;
  
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
   * This method is used to add entry into the Bookings table, update clients and vehicles table with bookingID.
   * @param booking
   */
  public void addEntry(Bookings booking) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd = "INSERT INTO bookings (bookingTS, returnDate, startDate, dueDate, cancelDate, clientId, vehicleId)";
    sqlCmd += " VALUES ( '" + booking.getBookingTS() + "', "
       // +  booking.getReturnDate() + "', '" 
        + null + ", '"
        + booking.getStartDate() + "', '" 
        + booking.getDueDate() + "', "
        + null + ", "
       // + booking.getCancelDate() + "', "
        + booking.getClientID() + ","
        + booking.getVehicleID() + ")";
    db.updateCommand(sqlCmd);
    ResultSet rs= db.executeCommand("select LAST_INSERT_ID()"); 
    try {
      while(rs.next()) {
        bkngid = rs.getString(1);
      }
   } catch (SQLException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
     
   }
    Long bid = Long.parseLong(bkngid);
  
    String column = "bookingId" ;
    String sqlCmd1= "UPDATE vehicles SET " + column + " = '" + bid + "' WHERE id = " + booking.getVehicleID() + ";";
    db.updateCommand(sqlCmd1);
    String sqlCmd2 = "UPDATE clients SET " + column + " = '" + bid + "' WHERE id = " + booking.getClientID() + ";";
    
    db.updateCommand(sqlCmd2);
    
    
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
  
  /**
   * This method is used to delete the bookings.
   * @param id
   */
  public void removeClientandBookingEntry(Long id) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd = "DELETE bookings , clients  FROM bookings INNER JOIN clients ON bookings.id =  clients.bookingId  WHERE bookings.id = " + id + ";";
    
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
  
  public ArrayList<ArrayList<String>> getClientBookingVehicleDetails(String firstName, String lastName, 
      String model, String make, String startDate, String dueDate) {
    
   if(null == firstName) {
     firstName = "";
   }
   if(null == lastName) {
     lastName = "";
   }
   if(null == model) {
     model = "";
   }
   if(null == make) {
     make = "";
   }
   if(null == startDate) {
     startDate = "";
   }
   if(null == dueDate) {
     dueDate = "";
   }
    db = DatabaseConfig.getDBInstance();
    String sqlCmd ="SELECT c.firstName, c.lastName, c.licenceNumber, b.bookingTS, b.startDate, "
                   + " b.dueDate, b.returnDate, b.cancelDate, v.Make, v.Model, v.LicPlate "
                   + " FROM clients AS c JOIN bookings AS b"
                   + " ON  c.id = b.clientId"
                   + " JOIN vehicles AS v"
                   + " ON b.vehicleId = v.id"
                   + " WHERE firstName LIKE '%"+ firstName + "%' AND"
                   + " lastName like '%" + lastName + "%' AND"
                   + " Make like '%"+ make + "%' AND"
                   + " Model like '%"+ model + "%'AND"
                   + " startDate like '%" + startDate.replace('-', '/') + "%' AND"
                   + " dueDate like '%" + dueDate.replace('-', '/') + "%';";
    
    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    ResultSet rs = db.executeCommand(sqlCmd);
    try {
      while(rs.next()) {
        ArrayList<String> r = new ArrayList<String>();
        for(int i = 1; i <= 11; i++) {
          r.add(rs.getString(i));
        }
        result.add(r);
        
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
    return result;
    
  }
  

}

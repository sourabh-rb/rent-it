package com.rentit.data_source;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.rentit.model.Clients;

/**
 * ClientDataGateway is the gateway for Clients model and Clients Table in DB.
 * @author Sourabh Rajeev Badagandi
 * @version 1.0.0
 *
 */
public class ClientsDataGateway {

  private DatabaseConfig db;

  /**
   * This method is used to list all contents of client table.
   * @return clientData.
   */
  public ArrayList<ArrayList<String>> listAll() {
    db = DatabaseConfig.getDBInstance();  
    ResultSet rs= db.executeCommand("select * from clients"); 
    ArrayList<ArrayList<String>> clientData = new ArrayList<ArrayList<String>>();
    try {
      while(rs.next()) {
        ArrayList<String> entry = new ArrayList<String>();
        for(int i = 1; i <= 9; i++) {
          entry.add(rs.getString(i));
        }

        clientData.add(entry);
      }

    } catch (SQLException e) {e.printStackTrace();}

    return clientData;
  }


  /**
   * This method is used to add entry into the clients table.
   * @param cli
   */
  public void addEntry(Clients cli) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd = "INSERT INTO clients (firstName, lastName, licenceNumber, licenceValidity, phone, clerkId, bookingId, vehicleId)";
    sqlCmd += " VALUES ( '" + cli.getFirstName() + "', '"
        +  cli.getLastName() + "', '" 
        + cli.getLicenceNumber() + "', '" 
        + cli.getLicenceValidity() + "', '" 
        + cli.getPhone() + "', " 
        + cli.getClerkid() + ","
        + cli.getBookingId() + "," 
        + cli.getVehicleId() + ")";
   
    db.updateCommand(sqlCmd);


  }


  /**
   * This method is used to remove entry from client table.
   * @param clientID
   */
  public void removeEntry(Long clientID) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd ="DELETE FROM clients WHERE id = " + clientID + ";" ;
    db.updateCommand(sqlCmd);


  }

  /**
   * This method is used to update entry from client table.
   * @param column
   * @param newValue
   * @param clientID
   */
  public void updateEntry(String column, String newValue, Long clientID) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd ="UPDATE clients SET " + column + " = '" + newValue + "' WHERE id = " + clientID + ";" ;

    db.updateCommand(sqlCmd);
  }
  
  /**
   * This method returns a row from CLients Table.
   * @param clientID
   * @return
   */
  public ArrayList<String> getEntry(Long clientID) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd ="SELECT * FROM clients WHERE id = " + clientID + ";";
    ArrayList<String> rec = new ArrayList<String>();
    ResultSet rs = db.executeCommand(sqlCmd);

    try {
      while(rs.next()) {
        for(int i = 1; i <= 9; i++) {
          rec.add(rs.getString(i));
        } 
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return rec; 
  }
  
  
  public void updateCLientsRow(Clients client) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd = "UPDATE clients SET id = " + client.getClientID()
                    + " firstName = '" + client.getFirstName() 
                    + "' lastName = '" + client.getLastName()
                    + "' licenceNumber = '" + client.getLicenceNumber()
                    + "' licenceValidity = '" + client.getLicenceValidity()
                    + "' phone = '" + client.getPhone()
                    + "' clerkId = " + client.getClerkid()
                    + " bookingId = " + client.getBookingId()
                    + " vehicleId = " + client.getVehicleId() +
                    " WHERE id = " + client.getClientID() + ";" ;
    System.out.println(sqlCmd);
    
    db.updateCommand(sqlCmd);
  }
  
  
  
  
  

}

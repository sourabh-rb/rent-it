package com.rentit.data_source;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.rentit.model.Clients;

/**
 * ClientDataGateway is the gateway for Clients model and Clients Table in DB.
 * @author soura
 *
 */
public class ClientsDataGateway {

  private DatabaseConfig db;

  /**
   * This method is used to list all contnts of client table.
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
   * This methos is used to add entry into the clients table.
   * @param cli
   */
  public void addEntry(Clients cli) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd = "INSERT INTO clients (firstName, lastName, licenceNumber, licence_validity, phone, clerkId, bookingId, vehicleId)";
    sqlCmd += " VALUES ( '" + cli.getFirstName() + "', '"
        +  cli.getLastName() + "', '" 
        + cli.getLicenceNumber() + "', '" 
        + cli.getLicenceValidity() + "', '" 
        + cli.getPhone() + "', " 
        + cli.getClerkID() + ","
        + cli.getBookingId() + "," 
        + cli.getVehicleId() + ")";
    System.out.println(sqlCmd);
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

}

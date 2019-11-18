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
  public static String val = null;

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
        for(int i = 1; i <= 10; i++) {
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
  public int addEntry(Clients cli) {
    int ret = 0;
    db = DatabaseConfig.getDBInstance();
    String sqlCmd = "INSERT INTO clients (firstName, lastName, licenceNumber, licenceValidity, phone, clerkId, bookingId, vehicleId, version)";
    sqlCmd += " VALUES ( '" + cli.getFirstName() + "', '"
        +  cli.getLastName() + "', '" 
        + cli.getLicenceNumber() + "', '" 
        + cli.getLicenceValidity() + "', '" 
        + cli.getPhone() + "', " 
        + cli.getClerkid() + ","
        + cli.getBookingId() + "," 
        + cli.getVehicleId() + ","
        + (cli.getVersion() + 1L) + ")";
   
    ret = db.updateCommand(sqlCmd);
    if(ret > 0) {
      ResultSet rs= db.executeCommand("select LAST_INSERT_ID()"); 
      try {
        while(rs.next()) {
          val = rs.getString(1);
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return ret;
  }


  /**
   * This method is used to remove entry from client table.
   * @param clientID
   */
  public int removeEntry(Long clientID, Long version) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd ="DELETE FROM clients WHERE id = " + clientID + " AND clients.version = " + version + ";" ;
    return db.updateCommand(sqlCmd);


  }

  /**
   * This method is used to update entry from client table.
   * @param column
   * @param newValue
   * @param clientID
   */
  public int updateEntry(String column, String newValue, Long clientID, Long version) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd ="UPDATE clients SET " + column + " = '" + newValue + "' WHERE id = " + clientID + " AND clients.version = " + version +";" ;

    return db.updateCommand(sqlCmd);
  }
  
  public int updateVersion(Long id, Long version) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd ="UPDATE clients SET version = " + (version + 1L) + " WHERE id = " + id + " AND clients.version = " + version + ";" ;

    return db.updateCommand(sqlCmd);
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
        for(int i = 1; i <= 10; i++) {
          rec.add(rs.getString(i));
        } 
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return rec; 
  }
  
  /**
   * This method is used to update the clients.
   * @param client
   */
  public int updateCLientsRow(Clients client) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd = "UPDATE clients SET " 
                    + " firstName = '" + client.getFirstName() 
                    + "' , lastName = '" + client.getLastName()
                    + "' , licenceNumber = '" + client.getLicenceNumber()
                    + "' , licenceValidity = '" + client.getLicenceValidity()
                    + "' , phone = '" + client.getPhone()
                    + "' , clerkId = " + client.getClerkid()
                    + " , bookingId = " + client.getBookingId()
                    + " , vehicleId = " + client.getVehicleId() 
                    + " , version = " + (client.getVersion() + 1L)
                    + " WHERE id = " + client.getClientID() + " AND clients.version = " + client.getVersion() + ";" ;
    System.out.println(sqlCmd);
    
    return db.updateCommand(sqlCmd);
  }

  /**
   * This methos sets client Id to 0.
   * @param column
   * @param clientId
   */
  public int setNull(String column, Long clientId, Long version) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd ="UPDATE clients SET " + column + " = 0 WHERE id = " + clientId + " AND clients.version = " + version +";" ;
    return db.updateCommand(sqlCmd);
    
  }
  
  public String getVersion(Long clientId) {
    String v = null;
    ResultSet rs= db.executeCommand("select clients.version FROM clients WHERE id = " + clientId + ";"); 
    try {
      while(rs.next()) {
        v = rs.getString(1);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return v;
  }
  
  
  
  
  

}

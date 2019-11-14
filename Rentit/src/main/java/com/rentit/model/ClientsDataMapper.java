package com.rentit.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import com.rentit.data_source.ClientsDataGateway;

/**
 * ClientDataMapper is used to map Client model attributes to the Clients table via the ClientDataGateway.
 * @author Sourabh Rajeev Badagandi
 * @version 1.0.0
 *
 */
public class ClientsDataMapper {

  private ClientsDataGateway clientGateway;
  
  public ClientsDataMapper() {
    clientGateway = new ClientsDataGateway();
    
  }
  
  /**
   * This method fetches client data.
   * @return
   */
  public  ArrayList<Clients> getClientData() {
   
    ArrayList<Clients> clientData = new ArrayList<Clients>();
    ArrayList<ArrayList<String>> data =  clientGateway.listAll();
    
    for(ArrayList<String> r : data) {
      clientData.add(mapRecord(r));
    }
    
    return clientData;
  }
  
  /**
   * This method adds client record.
   * @param client
   */
  public void addClientRecord(Clients client) {
    
    clientGateway.addEntry(client);
  }
  
  /**
   * This method removes client record.
   * @param clientID
   */
  public void removeRecord(Long clientID) {
    clientGateway.removeEntry(clientID);
  }
  
  /**
   * This method updates client record.
   * @param column
   * @param val
   * @param id
   */
  public void updateRecord(String column, String val, Long id) {
    clientGateway.updateEntry(column, val, id);
  }
  
  /**
   * This method returns client record.
   * @param clientID
   * @return
   */
  public Clients getRecord(Long clientID) {
    ArrayList<String> record = clientGateway.getEntry(clientID);
    return mapRecord(record);
  }
  
  public void modifyRecord(Clients client) {
    
    clientGateway.updateCLientsRow(client);
  }
  
  /**
   * This method is used to map the client table attributes to client object attributes.
   * @param recordData
   * @return Client
   */
  private Clients mapRecord(ArrayList<String> recordData) {
    Clients cli = new Clients();
    cli.setClientID(Long.parseLong(recordData.get(0)));
    cli.setFirstName(recordData.get(1));
    cli.setLastName(recordData.get(2));
    cli.setLicenceNumber(recordData.get(3));
    cli.setLicenceValidity(recordData.get(4));
    cli.setPhone(recordData.get(5));
    cli.setClerkid(Long.parseLong(recordData.get(6)));
    cli.setBookingId(Long.parseLong(recordData.get(7)));
    cli.setVehicleId(Long.parseLong(recordData.get(8)));
    
    return cli;
    
  }
    
  public void removeBookingandVehicle(Long clientId) {
    clientGateway.setNull("vehicleId", clientId);
    clientGateway.setNull("bookingId", clientId);
    
  }
}

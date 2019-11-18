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
  public void removeRecord(Long clientID, Long version) {
    clientGateway.removeEntry(clientID, version);
  }
  
  /**
   * This method updates client record.
   * @param column
   * @param val
   * @param id
   */
  public void updateRecord(String column, String val, Long id, Long version) {
    clientGateway.updateEntry(column, val, id, version);
  }
  
  public int updateVersion(Long id, Long version) {
    return clientGateway.updateVersion(id, version);
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
  
  public int modifyRecord(Clients client) {
    
   int upd= clientGateway.updateCLientsRow(client);
   return upd;
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
    cli.setVersion(Long.parseLong(recordData.get(9)));
    
    return cli;
    
  }

  /**
   * This method is used to clear booking and vehicle id.
   * @param clientId
   * @param version
   */
  public int removeBookingandVehicle(Long clientId, Long version) {
    
    int res = clientGateway.setNull("vehicleId", clientId, version);
    if(res > 0) {
     res = clientGateway.setNull("bookingId", clientId, version);
    }
    return res;
    
  }
  
  public Long getClientVersion(Long clientId) {
    return Long.parseLong(clientGateway.getVersion(clientId));
  }
}

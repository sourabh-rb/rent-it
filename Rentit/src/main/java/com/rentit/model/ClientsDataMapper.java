package com.rentit.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import com.rentit.data_source.ClientsDataGateway;

/**
 * ClientDataMapper is used to map Clinet model attributes to the Clients table via the ClientDataGateway.
 * @author soura
 *
 */
public class ClientsDataMapper {

  private ClientsDataGateway clientGateway;
  
  public ClientsDataMapper() {
    clientGateway = new ClientsDataGateway();
    
  }
  
  /**
   * This mehod fetches client data.
   * @return
   */
  public ArrayList<ArrayList<String>> getClientData() {
   
     return clientGateway.listAll();
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
}

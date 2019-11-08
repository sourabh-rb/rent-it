package com.rentit.model;

import java.util.ArrayList;
import com.rentit.data_source.ClerksDataGateway;



/**
 * ClerksDataMapper class is to map Clerk model to Clerks table via the clerksdatagateway.
 * 
 * @author Sai Charan Duduka
 * @version 1.0.0
 *
 */

public class ClerksDataMapper {

  private ClerksDataGateway clerksdatagateway;

  public ClerksDataMapper() {
    clerksdatagateway = new ClerksDataGateway();
  }



  /**
   * This methos add clerk record to database
   * 
   * @param clerk
   */
  public void addClerkRecord(Clerks clerk) {

    clerksdatagateway.addEntry(clerk);
  }

  /**
   * This method is to get clerk record based on username
   * 
   * @param username
   * @return
   */
  public ArrayList<String> getClerkRecord(String username) {
    ArrayList<String> ar = new ArrayList<String>();
    ar = clerksdatagateway.getEntry(username);
    return ar;

  }


  /**
   * This method is to get clerk data
   * 
   * @return
   */
  public ArrayList<Clerks> getClerkData() {

    ArrayList<Clerks> clerkData = new ArrayList<Clerks>();
    ArrayList<ArrayList<String>> data = clerksdatagateway.listData();

    for (ArrayList<String> r : data) {
      clerkData.add(mapRecord(r));
    }

    return clerkData;
  }

  /**
   * This method used to map the clerk table attributes to clerk object attributes.
   * 
   * @param recordData
   * @return
   */
  private Clerks mapRecord(ArrayList<String> recordData) {
    Clerks clerk = new Clerks();
    clerk.setId(Long.parseLong(recordData.get(0)));
    clerk.setFirstName(recordData.get(1));
    clerk.setLastName(recordData.get(2));
    clerk.setUsername(recordData.get(3));
    clerk.setPassword(recordData.get(4));
    clerk.setEmail(recordData.get(5));
    clerk.setusergroup(recordData.get(6));


    return clerk;

  }
}

package com.rentit.model;

import java.util.ArrayList;
import com.rentit.data_source.ClerksDataGateway;

public class ClerksDataMapper {
  
  private ClerksDataGateway clerksdatagateway;
  
     public ClerksDataMapper() {
       clerksdatagateway = new ClerksDataGateway();
     }
     
     public void addClerkRecord(Clerks clerk) {
       
       clerksdatagateway.addEntry(clerk);
     }
     public ArrayList<String> getClerkRecord(String username){
       ArrayList<String> ar = new ArrayList<String>();
       ar = clerksdatagateway.getEntry(username);
      return null;
       
     }
     
     public  ArrayList<Clerks> getClerkData() {
       
       ArrayList<Clerks> clerkData = new ArrayList<Clerks>();
       ArrayList<ArrayList<String>> data =  clerksdatagateway.listData();
       
       for(ArrayList<String> r : data) {
         clerkData.add(mapRecord(r));
       }
       
       return clerkData;
     }
     private Clerks mapRecord(ArrayList<String> recordData) {
       Clerks clerk = new Clerks();
       clerk.setId(Long.parseLong(recordData.get(0)));
       clerk.setFirstName(recordData.get(1));
       clerk.setLastName(recordData.remove(2));
       clerk.setUsername(recordData.get(3));
       clerk.setPassword(recordData.get(4));
       clerk.setEmail(recordData.get(5));
       clerk.setusergroup(recordData.get(6));
       
       
       return clerk;
       
     }
}

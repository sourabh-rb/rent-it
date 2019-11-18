package com.rentit.model;

import java.text.ParseException;
import java.util.ArrayList;
import com.rentit.data_source.AdminDataGateway;
import com.rentit.data_source.VehiclesDataGateway;


public class AdminDataMapper {
  private AdminDataGateway adminDataGateway;
  
  /**
   * Constructor to make object of class and use this instance later.
   */
  public AdminDataMapper() {
    adminDataGateway = new AdminDataGateway();
  }

  /**
   * 
   * @return Returning the record which consist of data with vehicle record
   */
 public  ArrayList<Vehicles> getVehiclesData() {
    
    ArrayList<Vehicles> vehiclesData = new ArrayList<Vehicles>();
    ArrayList<ArrayList<String>> data =  adminDataGateway.listAll();
    
    for(ArrayList<String> r : data) {
      vehiclesData.add(mapRecord(r));
    }
    
    return vehiclesData;
  }
 
 /**
  * 
  * @param recordData Record dataset Conataing  Data based on column format
  * @return  returning the records in form of arraylist
  */
 private Vehicles mapRecord(ArrayList<String> recordData) {
   Vehicles veh = new Vehicles();
  veh.setId(Integer.parseInt(recordData.get(0)));
  veh.setMake(recordData.get(1));
  veh.setModel(recordData.get(2));
  veh.setiYear(recordData.get(3));
  veh.setType(recordData.get(4));
  veh.setLicPlate(recordData.get(5));
  veh.setColor(recordData.get(6));
  veh.setbookingId(Integer.parseInt(recordData.get(7)));

  return veh;
   
 }
 /**
  * 
  * @param Make  Make Record to be searched
  * @param Type  Type Record to be searched
  * @param Model Model Record to be searched
  * @param iYear iYear Record to be searched
  * @param sLess sLess Record to be searched
  * @param sGreater sGreater Record to be searched
  * @return Return data in form of array List
  */
 public  ArrayList<Vehicles> getVehiclesDataViaSearch(String Make, String Type, String Model, String iYear,
     String sLess, String sGreater) {
    
    ArrayList<Vehicles> vehiclesData = new ArrayList<Vehicles>();
    ArrayList<ArrayList<String>> data =  adminDataGateway.fncSearchVehicles(Make, Type, Model, iYear, sLess, sGreater);
    
    for(ArrayList<String> r : data) {
      vehiclesData.add(mapRecord(r));
    }
    
    return vehiclesData;
  }
 
 /**
  * 
  * @param vehicles  Vehicles object to be used 
  * @throws ParseException
  */
 public void addVehiclesRecord(Vehicles vehicles) throws ParseException {
   
   adminDataGateway.addVehicles(vehicles);
  }
 
 /**
  * 
  * @param VehicleID  VehicleId to be used to remove the ID via delete command
  */
 public void removeVehiclesRecord(int VehicleID) {
   adminDataGateway.removeVehiclesEntry(VehicleID);
 }
 /**
  * This method retrieves vehicle record with vehicleID
  * @param vehicleID ID of the required vehicle
  * @return vehicle record
  */
 public Vehicles getRecord(Long vehicleID) {
   ArrayList<String> record = adminDataGateway.getEntry(vehicleID);
   return mapRecord(record);
 }
 /**
  * 
  * @param vehicles  Vechile object 
  * @throws ParseException Long to int parse exception
  */
 public int updateVehiclesRecord(Vehicles vehicles, Long version) throws ParseException{
  return adminDataGateway.updateVehiclesEntry(vehicles, version);
 }
 
 public int getVehicleVersion(Long vehicleId) {
   return Integer.parseInt(adminDataGateway.getVersion(vehicleId));
 }
 
 public int updateVersion(Long id, Long version) {
   VehiclesDataGateway vdm = new VehiclesDataGateway();
   return vdm.updateVersion(id, version);
  }
}

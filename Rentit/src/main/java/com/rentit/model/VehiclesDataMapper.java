package com.rentit.model;

import java.text.ParseException;
import java.util.ArrayList;
import com.rentit.data_source.VehiclesDataGateway;

public class VehiclesDataMapper {
/**
 * vehiclesDataGateway Type instance
 */
  private VehiclesDataGateway vehiclesDataGateway;
  
  /**
   *  Contructor object
   */
  public VehiclesDataMapper() {
    vehiclesDataGateway = new VehiclesDataGateway();
  }
  
  /**
   * 
   * @param vehicles  Vehicles object to get list
   * @throws ParseException
   */
 public void addVehiclesRecord(Vehicles vehicles) throws ParseException {
    
   vehiclesDataGateway.addVehicles(vehicles);
  }
 
 /**
  * 
  * @param vehicles vehicles  Vehicles object to get list
  * @throws ParseException  Long to int parsing exception handling
  */
 
 public void updateVehiclesRecord(Vehicles vehicles, Long version) throws ParseException{
   vehiclesDataGateway.updateVehiclesEntry(vehicles, version);
 }
 
 /**
  * 
  * @return vehicle record return in array List
  */
  
  public  ArrayList<Vehicles> getVehiclesData() {
    
    ArrayList<Vehicles> vehiclesData = new ArrayList<Vehicles>();
    ArrayList<ArrayList<String>> data =  vehiclesDataGateway.listAll();
    
    for(ArrayList<String> r : data) {
      vehiclesData.add(mapRecord(r));
    }
    
    return vehiclesData;
  }
  
  /**
   * 
   * @param VehicleID Record to be removed via Delete command
   */
  public void removeVehiclesRecord(int VehicleID, Long version) {
    vehiclesDataGateway.removeVehiclesEntry(VehicleID, version);
  }
  
  /**
   * This method fetches the details for selected vehicle in Vehicle catalog
   * @param recordData record for current vehicle
   * @return vehicle record
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
   * @return  return you a arrayList containg reocrds
   */
 public  ArrayList<Vehicles> getVehiclesDataViaSearch(String Make, String Type, String Model, String iYear,
     String sLess, String sGreater) {
    
    ArrayList<Vehicles> vehiclesData = new ArrayList<Vehicles>();
    ArrayList<ArrayList<String>> data =  vehiclesDataGateway.fncSearchVehicles(Make, Type, Model, iYear, sLess, sGreater);
    
    for(ArrayList<String> r : data) {
      vehiclesData.add(mapRecord(r));
    }
    
    return vehiclesData;
  }
 /**
  * This method retrieves vehicle record with vehicleID
  * @param vehicleID ID of the required vehicle
  * @return vehicle record
  */
 public Vehicles getRecord(Long vehicleID) {
   ArrayList<String> record = vehiclesDataGateway.getEntry(vehicleID);
   return mapRecord(record);
 }
 
 
 /**
  * Method to return next vehicle in detailed view page
  * 
  * @return next vehicle in catalog
  */

 public Vehicles getNextVehicle(Long id) {

   ArrayList<Integer> idList=new ArrayList<>();
   int currentID=0;
   
   for (Vehicles vehicle : getVehiclesData()) {
     
     idList.add(vehicle.getId());
   }

   for (int i = 0; i < idList.size(); i++) {
    int temp=idList.get(i);
    
    
    if(temp==id) {
      if(i!=idList.size()-1) {
        currentID=idList.get(i+1);
      }
      else {
        currentID=idList.get(0);
      }
    }
  }
     long newId=currentID;
     Vehicles VechilesDetails = getRecord(newId);
     return VechilesDetails;
 }
 
 /**
  * 
  * @param vehicleId  removing vehicle record
  */
 public void removeBooking(Long vehicleId, Long version) {
   vehiclesDataGateway.setNull("bookingId", vehicleId, version);
 }
 
 public int updateVersion(Long id, Long version) {
   return vehiclesDataGateway.updateVersion(id, version);
  }
 
 public int getVehicleVersion(Long vehicleId) {
   return Integer.parseInt(vehiclesDataGateway.getVersion(vehicleId));
 }
 
 public int updateVehicleBooked(Long vehicleId, Long vehicleVersion) {
   return vehiclesDataGateway.updateVehicleVersion(vehicleId, vehicleVersion);
 }
  
}

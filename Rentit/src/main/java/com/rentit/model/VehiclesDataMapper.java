package com.rentit.model;

import java.text.ParseException;
import java.util.ArrayList;
import com.rentit.data_source.VehiclesDataGateway;
/**
 * Vehicle data mapper class.
 * @author Basant Gera.
 *
 */
public class VehiclesDataMapper {

  private VehiclesDataGateway vehiclesDataGateway;
  
  public VehiclesDataMapper() {
    vehiclesDataGateway = new VehiclesDataGateway();
  }
  /**
   * This method is to add vehicles record.
   * @param vehicles
   * @throws ParseException
   */
 public void addVehiclesRecord(Vehicles vehicles) throws ParseException {
    
   vehiclesDataGateway.addVehicles(vehicles);
  }
  
  public  ArrayList<Vehicles> getVehiclesData() {
    
    ArrayList<Vehicles> vehiclesData = new ArrayList<Vehicles>();
    ArrayList<ArrayList<String>> data =  vehiclesDataGateway.listAll();
    
    for(ArrayList<String> r : data) {
      vehiclesData.add(mapRecord(r));
    }
    
    return vehiclesData;
  }
  
  /**
   * This method is to remove the vehicle record.
   * @param VehicleID
   */
  public void removeVehiclesRecord(int VehicleID) {
    vehiclesDataGateway.removeVehiclesEntry(VehicleID);
  }

  private Vehicles mapRecord(ArrayList<String> recordData) {
    Vehicles veh = new Vehicles();
   veh.setId(Integer.parseInt(recordData.get(0)));
   //veh.setLicPlate(recordData.get(1));
   veh.setType(recordData.get(4));
   veh.setMake(recordData.get(1));
   veh.setModel(recordData.get(2));
   veh.setiYear(recordData.get(3));
   //veh.setColor(recordData.get(6));
    return veh;
    
  }
  /**
   * This method is to get the vehicles details based on the search.
   * @param Make
   * @param Type
   * @param Model
   * @param iYear
   * @param sLess
   * @param sGreater
   * @return
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
  * This method is set the vehicle id to null.
  * @param vehicleId
  */
 public void removeBooking(Long vehicleId) {
   vehiclesDataGateway.setNull("bookingId", vehicleId);
 }
  
}

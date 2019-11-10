package com.rentit.model;

import java.util.ArrayList;
import com.rentit.data_source.VehiclesDataGateway;

public class VehiclesDataMapper {

  private VehiclesDataGateway vehiclesDataGateway;
  
  public VehiclesDataMapper() {
    vehiclesDataGateway = new VehiclesDataGateway();
  }
  
  public  ArrayList<Vehicles> getVehiclesData() {
    
    ArrayList<Vehicles> vehiclesData = new ArrayList<Vehicles>();
    ArrayList<ArrayList<String>> data =  vehiclesDataGateway.listAll();
    
    for(ArrayList<String> r : data) {
      vehiclesData.add(mapRecord(r));
    }
    
    return vehiclesData;
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
  
 public  ArrayList<Vehicles> getVehiclesDataViaSearch(String Make, String Type, String Model, String iYear,
     String sLess, String sGreater) {
    
    ArrayList<Vehicles> vehiclesData = new ArrayList<Vehicles>();
    ArrayList<ArrayList<String>> data =  vehiclesDataGateway.fncSearchVehicles(Make, Type, Model, iYear, sLess, sGreater);
    
    for(ArrayList<String> r : data) {
      vehiclesData.add(mapRecord(r));
    }
    
    return vehiclesData;
  }
  
}

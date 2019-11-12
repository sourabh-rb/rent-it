package com.rentit.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import com.rentit.test_class.TestClass;

/**
 * Vehicle service layer.
 * 
 * @author Basant Gera
 *
 */
@Service
//@Transactional
public class VehicleService {

  private TestClass testData = new TestClass();
  private ArrayList<Integer> storeId = new ArrayList<>();
  private Vehicles bookVehicle;

  /**
   * 
   * @return the list off all vehicle catalog list
   */
  public ModelWrapper listAll() {

    return testData.getVehicleCatalog();
  }

  /**
   * 
   * @param Make Search for Make Parameter
   * @param Type Search for Type Parameter
   * @param Model Search for Model Parameter
   * @param iYear Search for iYear Parameter
   * @param sLess Search for sLess Parameter
   * @param sGreater Search for sGreater Parameter
   * @return
   */
  public ModelWrapper ListAllSearches(String Make, String Type, String Model, String iYear,
      String sLess, String sGreater) {

    return testData.getVehiclesTestDatAfterSearch(Make, Type, Model, iYear, sLess, sGreater);
  }

  /**
   * This method is used to return a vehicle based on its ID
   * 
   * @param id of vehicle
   * @return vehicle
   */

  /**
   * 
   * @param id
   * @return
   */
  public Vehicles getVechileInfo(long id) {
    for (Vehicles vehicle : testData.getVehiclesTestData()) {
      if (id == vehicle.getId()) {
        return vehicle;
      }
    }

    return null;

  }

  /**
   * Method to return next vehicle in detailed view page
   * 
   * @return next vehicle in catalog
   */

  public Vehicles getNextVehicle(Long id) {

    LinkedList<Vehicles> vList = new LinkedList<Vehicles>();
    Boolean vehicleFound = true;
    Vehicles vehicleObj = new Vehicles();
    for (Vehicles vehicle : testData.getVehicleCatalog().getCatalogList()) {
      vList.add(vehicle);
    }

    /**
     * Vehicle List Iterator for get Vehicles records.
     */
    ListIterator<Vehicles> vListIterator = vList.listIterator((id.intValue()));
    while (vehicleFound) {
      if (vListIterator.hasNext()) {
        vehicleObj = (Vehicles) vListIterator.next();
        vehicleFound = false;
      } else {
        vListIterator = vList.listIterator(0);
        vehicleObj = (Vehicles) vListIterator.next();
        vehicleFound = false;
      }
      return vehicleObj;
    }

    return null;
  }

  /**
   * This method is used to update details of an existing vehicle
   * 
   * @param vechileDetails The vehicle object
   */

  public void UpdateVehicleInfo(Vehicles vechileDetails) {

    for (Vehicles vechile : testData.getVehiclesTestData()) {
      if (vechileDetails.getId() == vechile.getId()) {
        vechile.setiYear(vechileDetails.getiYear());
        vechile.setMake(vechileDetails.getMake());
        vechile.setModel(vechileDetails.getModel());
        vechile.setType(vechileDetails.getType());
        vechile.setColor(vechileDetails.getColor());
        vechile.setLicPlate(vechileDetails.getLicPlate());

      }
    }

  }

  /**
   * This method is used to add a new vehicle to the vehicle list
   * 
   * @param vechileDetails The vehicle object
   */

  public void AddVehicleInfo(Vehicles vechileDetails) {

    for (Vehicles vechile : testData.getVehiclesTestData()) {
      storeId.add(vechile.getId());
    }
    Collections.sort(storeId);
    Collections.reverse(storeId);
    int idForNewVehicle = storeId.get(0);

    Vehicles vehicle = new Vehicles();

    vehicle.setiYear(vechileDetails.getiYear());
    vehicle.setMake(vechileDetails.getMake());
    vehicle.setModel(vechileDetails.getModel());
    vehicle.setType(vechileDetails.getType());
    vehicle.setColor(vechileDetails.getColor());
    vehicle.setLicPlate(vechileDetails.getLicPlate());

    testData.addNewVehicles(vehicle, idForNewVehicle + 1);
  }

  /**
   * Used to add vehicle on click of save button
   * 
   * @param VehiclesAttributes vehicle details.
   * @param iSize id for vehicle
   * @return null if vehicle not added.
   */

  public ModelWrapper fncadditem(Vehicles VehiclesAttributes, int iSize) {

    int idIncrement = iSize + 1;
    System.out.println("Size + 1 : " + idIncrement);

    for (Vehicles vechile : testData.getVehiclesTestData()) {
      if (idIncrement == vechile.getId()) {

      } else {
        testData.addNewVehicles(VehiclesAttributes, idIncrement);
        break;
      }
    }
    return null;

  }

  /**
   * 
   * @param id  Delete Vehicle for a particular record
   */
  public void deleteVehicle(int id) {
    testData.removeVehicleRecord(id);
  }

  /**
   * 
   * @return GetBookvehicle object
   */
  public Vehicles getBookVehicle() {
    return bookVehicle;
  }

  /**
   * 
   * @param bookVehicle  SetbookVehicle for Book vehicle
   */
  public void setBookVehicle(Vehicles bookVehicle) {
    this.bookVehicle = bookVehicle;
  }

}

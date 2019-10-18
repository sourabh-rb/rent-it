package com.rentit.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentit.test_class.TestClass;

/**
 * Vehicle service layer.
 * @author Basant Gera
 *
 */
@Service
@Transactional
public class VehicleService {

	private TestClass testData = new TestClass();
	private ArrayList<Integer> storeId=new ArrayList<>();

	public ModelWrapper listAll() {

	
	//	return testData.getVehiclesTestData();
		return testData.getVehicleCatalog();
	}

    public ModelWrapper ListAllSearches(String Make,String Type,String Model,String iYear,String sLess,String sGreater){

		return testData.getVehiclesTestDatAfterSearch(Make,Type,Model,iYear,sLess,sGreater);
	}


	
	public Vehicles getVechileInfo(long id) {
		for(Vehicles vehicle : testData.getVehiclesTestData()) {
			if(id == vehicle.getId()) {
				return vehicle;
			}
		}
		
		return null;
	
	}
	
	/**
	 * @return Vehicle
	 * Method to return next vehicle in detailed view page
	 * 
	 */
	
	public Vehicles getNextVehicle(Long id) {
			
		LinkedList<Vehicles> vList=new LinkedList<Vehicles>();
		Boolean vehicleFound=true;
		Vehicles vehicleObj=new Vehicles();
		for(Vehicles vehicle : testData.getVehiclesTestData()) {
			vList.add(vehicle);
			}
				
		ListIterator<Vehicles> vListIterator = vList.listIterator((id.intValue()));
		while(vehicleFound) {
			if(vListIterator.hasNext()) {
				vehicleObj=(Vehicles) vListIterator.next();
				vehicleFound=false;	
			}
			else {
				vListIterator = vList.listIterator(0);
				vehicleObj=(Vehicles) vListIterator.next();
				vehicleFound=false;
			}
			return vehicleObj;
		}
		
		return null;
	}
	
	

	public void UpdateVehicleInfo(Vehicles vechileDetails) {
		// TODO Auto-generated method stub
		
		for(Vehicles vechile : testData.getVehiclesTestData()) {
			if(vechileDetails.getId() == vechile.getId()) {
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
	 * @param vechileDetails The vehicle object
	 */
	
	public void AddVehicleInfo(Vehicles vechileDetails) {
		// TODO Auto-generated method stub
		for(Vehicles vechile : testData.getVehiclesTestData()) {
			storeId.add(vechile.getId());
		}
		Collections.sort(storeId);
		Collections.reverse(storeId);
		int idForNewVehicle=storeId.get(0);
		
		Vehicles vehicle=new Vehicles();
			
			
		vehicle.setiYear(vechileDetails.getiYear());
		vehicle.setMake(vechileDetails.getMake());
		vehicle.setModel(vechileDetails.getModel());
		vehicle.setType(vechileDetails.getType());
		vehicle.setColor(vechileDetails.getColor());
		vehicle.setLicPlate(vechileDetails.getLicPlate());
				
		testData.addNewVehicles(vehicle, idForNewVehicle+1);
		}

	public ModelWrapper fncadditem(Vehicles VehiclesAttributes ,int iSize) {
		
		
		int idIncrement=iSize+1;
		System.out.println("Size + 1 : "+idIncrement);
		
		for(Vehicles vechile : testData.getVehiclesTestData()) {
			if(idIncrement == vechile.getId()) {
				
			}
			else
			{
				testData.addNewVehicles(VehiclesAttributes,idIncrement);
				break;	
			}
		}
		return null;
		
	}
	
	public void deleteVehicle(int id) {
		testData.removeVehicleRecord(id);
	}

    
    
}
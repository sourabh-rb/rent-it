package com.rentit.model;

import java.util.ArrayList;
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
				System.out.println("Inside next service:"+vehicleObj.getId());
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
	
	/**
	 * @return Vehicle
	 * Method to return previous vehicle in detailed view page
	 * 
	 */
	
	public Vehicles getPreviousVehicle(Long id) {
		
		LinkedList<Vehicles> vList=new LinkedList<Vehicles>();
		Boolean vehicleFound=true;
		Vehicles vehicleObj=new Vehicles();
		for(Vehicles vehicle : testData.getVehiclesTestData()) {
			vList.add(vehicle);
			}
		System.out.println(vList.size());
		ListIterator<Vehicles> vListIterator = vList.listIterator((id.intValue()));
		while(vehicleFound) {
			if(vListIterator.hasPrevious()) {
				System.out.println(vListIterator.hasPrevious());
				vehicleObj=  (Vehicles) vListIterator.previous();
				System.out.println("inside previous"+vehicleObj.getId());
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

    
    
}
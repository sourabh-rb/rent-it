package com.rentit.model;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentit.test_class.TestClass;

@Service
@Transactional
public class vehicleService {

	private TestClass testData = new TestClass();

	public List<Vehicles> listAll() {

		return testData.getVehiclesTestData();
	}

    public List<Vehicles> ListAllSearches(String Make,String Type,String Model,String iYear){

		return testData.getVehiclesTestDatAfterSearch(Make,Type,Model,iYear);
	}


	
	public Vehicles getVechileInfo(long id) {
		for(Vehicles vehicle : testData.getVehiclesTestData()) {
			if(id == vehicle.getId()) {
				return vehicle;
			}
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

    
    
}
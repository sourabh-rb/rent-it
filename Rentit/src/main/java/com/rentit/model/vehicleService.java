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
}
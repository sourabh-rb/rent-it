package com.rentit.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentit.test_class.TestClass;

@Service
@Transactional
public class ClientsService {
	
	
	private TestClass testData = new TestClass();
	
	public List<ModelWrapper> listAll() {
	
		return testData.getTestEntries();
		
	}
	
	public void save(Clients client) {
	
	}
	
	public Clients get(Long id) {
		return null;	
	}
	
	public void delete(Long id) {
		
	}
	

	public void setReturnDate(Long id, String date) {
		
		testData.setReturnDate(id, date);
	}
	
	public void setCancelDate(Long id, String date) {
		
		testData.setCancelDate(id, date);
	}

	public Clients getClientInfo(int id) {
		for(Clients client : testData.getClientTestData()) {
			if(id == client.getClientID()) {
				return client;
			}
		}
		
		return null;
	
	}

	public void saveClientInfo(Clients clientDetails) {
		
		for(Clients client : testData.getClientTestData()) {
			if(clientDetails.getClientID() == client.getClientID()) {
				client.setFirstName(clientDetails.getFirstName());
				client.setLastName(clientDetails.getLastName());
				client.setLicenceNumber(clientDetails.getLicenceNumber());
				client.setLicenceValidity(clientDetails.getLicenceValidity());
				client.setPhone(clientDetails.getPhone());
			}
		}
	}
	
	

	public void saveNewBooking(ModelWrapper newBooking) {
		
		testData.addNewRecord(newBooking);
		
	}
	
}

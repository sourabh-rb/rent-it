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
	
	public List<ArrayList<String>> listAll() {
	
		return getClientandBookingInfo();
		
	}
	
	public void save(Clients client) {
	
	}
	
	public Clients get(Long id) {
		return null;	
	}
	
	public void delete(Long id) {
		
	}
	
	private List<ArrayList<String>> getClientandBookingInfo() {
		List<Clients> clientList = testData.getClientTestData();
		List<Bookings> bookingList = testData.getBookingTestData();
		List<ArrayList<String>> clientBookingList = new ArrayList<ArrayList<String>>();
		
		for(Clients client : clientList) {
			ArrayList<String> details = new ArrayList<String>();
			for(Bookings booking : bookingList) {
				if(client.getClientID() == booking.getClientID()) {
					details.add(client.getClientID().toString());
					details.add(client.getFirstName());
					details.add(client.getLastName());
					details.add(client.getLicenceNumber());
					details.add(client.getLicenceValidity());
					details.add(client.getPhone());
					details.add(booking.getBookingid().toString());
					details.add(booking.getStartDate());
					details.add(booking.getDueDate());
					details.add(booking.getBookingTS());
					if(booking.getReturnDate() != null) {
						details.add("Returned on: " + booking.getReturnDate());
					}
					else if (booking.getCancelDate() != null) {
						details.add("Cancelled on: " + booking.getCancelDate());
					}
					else {
						details.add("Booking Confirmed");
					}
					clientBookingList.add(details);
					
				}
			}
		}
		
		return clientBookingList;
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

	
}

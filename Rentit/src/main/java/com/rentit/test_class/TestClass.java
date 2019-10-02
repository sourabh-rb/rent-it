package com.rentit.test_class;

import java.util.ArrayList;
import java.util.List;

//import com.rentit.model.Bookings;
import com.rentit.model.Clients;

public  class TestClass {
	
	private static ArrayList<Clients> clientList;
	//private static ArrayList<Bookings> bookingList;
	private static TestClass testData;
	
	public TestClass() {
		populateClientList();
		//populateBookinList();
	}
	
//	public TestClass getInstance() {
//		if(testData == null) {	
//			testData = new TestClass();
//			populateClientList();
//		}
//		return testData;
//	}
	
//	private static void populateBookinList() {
//		bookingList = new ArrayList<Bookings>();
//		
//		Bookings booking1 = new Bookings(999L, "2019-09-20 8:38:12", null, "2019-09-25", "2019-09-27", null, 1L);
//		Bookings booking2 = new Bookings(929L, "2019-09-15 12:38:12", "2019-09-23", "2019-09-20", "2019-09-23", null, 2L);
//		Bookings booking3 = new Bookings(939L, "2019-09-10 6:38:12", null, "2019-09-28", "2019-09-29", "2019-09-27", 3L);
//		Bookings booking4 = new Bookings(949L, "2019-09-05 14:38:12", null, "2019-09-06", "2019-09-10", null, 4L);
//		Bookings booking5 = new Bookings(959L, "2019-09-06 22:38:12", null, "2019-09-10", "2019-09-27", null, 5L);
//		
//	}

	private static void populateClientList() {
		clientList = new ArrayList<Clients>();
		
		Clients client1 = new Clients(1L, "Andrew", "Neo", "A-1234-123456-12", "2020-09-20", "1234567890", 100L);
		Clients client2 = new Clients(2L, "Fatima", "Shaik", "C-4321-123456-33", "2021-08-01", "1234098734", 100L);
		Clients client3 = new Clients(3L, "Vijay", "Shankar", "F-1212-098765-11", "2020-01-29", "1234566666", 100L);
		Clients client4 = new Clients(4L, "Rajesh", "Rajkumar", "Y-0909-098762-33", "2022-02-10", "7867564534", 100L);
		Clients client5 = new Clients(5L, "Nancy", "Drew", "Q-6677-999234-45", "2023-09-20", "1234567890", 100L);
		
		clientList.add(client1);
		clientList.add(client2);
		clientList.add(client3);
		clientList.add(client4);
		clientList.add(client5);
		
	}
	
	public List<Clients> getClientTestData() {
		return clientList;
	}
	
//	public List<Bookings> getBookingTestData() {
//		return bookingList;
//	}

}

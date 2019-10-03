package com.rentit.test_class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.rentit.model.Bookings;
import com.rentit.model.Clients;
import com.rentit.model.Vehicles;

public class TestClass {

	private static ArrayList<Clients> clientList;
	private static ArrayList<Vehicles> vechileList;
	private static ArrayList<Vehicles> vechileListDummy;
	// private static ArrayList<Bookings> bookingList;
	private static TestClass testData;


	private static ArrayList<Bookings> bookingList;
	
	//private static  TestClass testData = null;
	
	public TestClass() {
		populateClientList();
		populateVechileList();
		populateBookinList();
		
	}
	
//	public TestClass getInstance() {
//		if(testData == null) {
//			testData = new TestClass();
//			
//		}
//		
//		return testData;
//	}



	private static void populateBookinList() {
		
		bookingList = new ArrayList<Bookings>();
		
		Bookings booking1 = new Bookings(999L, "2019-09-20 8:38:12", null, "2019-09-25", "2019-09-27", null, 1L);
		Bookings booking2 = new Bookings(929L, "2019-09-15 12:38:12", "2019-09-23", "2019-09-20", "2019-09-23", null, 2L);
		Bookings booking3 = new Bookings(939L, "2019-09-10 6:38:12", null, "2019-09-28", "2019-09-29", "2019-09-27", 3L);
		Bookings booking4 = new Bookings(949L, "2019-09-05 14:38:12", null, "2019-09-06", "2019-09-10", null, 4L);
		Bookings booking5 = new Bookings(959L, "2019-09-06 22:38:12", null, "2019-09-10", "2019-09-27", null, 5L);
		
		bookingList.add(booking1);
		bookingList.add(booking2);
		bookingList.add(booking3);
		bookingList.add(booking4);
		bookingList.add(booking5);
		
	}

	private void populateVechileList() {
		
		//public Vehicles(String id,String Make, String Model,String iYear,String Type) {
		vechileList = new ArrayList<Vehicles>();
		vechileListDummy = new ArrayList<Vehicles>();
        Vehicles vehicles1= new Vehicles("1","alto","wrangler","2019","suv");
        Vehicles vehicles2=new Vehicles("2","balto","xs","2020","muv");
        Vehicles vehicles3=new Vehicles("3","calto","ml","2120","RUV");
        Vehicles vehicles4=new Vehicles("4","dalto","fbg","2023","kuv");
        Vehicles vehicles5=new Vehicles("5","ealto","gal","1900","creta4");
        Vehicles vehicles6=new Vehicles("6","felto","mal","2013","fuv");
        Vehicles vehicles7=new Vehicles("7","celtoi","ik","2012","kol");
        Vehicles vehicles8=new Vehicles ("8","belto","jk","2011","lki");
        Vehicles vehicles9=new Vehicles ("9","alto","ujk","2018","noi");
        Vehicles vehicles10=new Vehicles ("10","alto","liu","2020","moi");
        Vehicles vehicles11=new Vehicles ("11","alto","bo","2003","eri");
        
        
        						 
        vechileList.add(vehicles1);
        vechileList.add(vehicles2);
        vechileList.add(vehicles3);
        vechileList.add(vehicles4);
        vechileList.add(vehicles5);
        vechileList.add(vehicles6);
        vechileList.add(vehicles7);
        vechileList.add(vehicles8);
        vechileList.add(vehicles9);
        vechileList.add(vehicles10);
        vechileList.add(vehicles11);
        
        vechileListDummy.add(vehicles1);
        vechileListDummy.add(vehicles2);
        vechileListDummy.add(vehicles3);
        vechileListDummy.add(vehicles4);
        vechileListDummy.add(vehicles5);
        vechileListDummy.add(vehicles6);
        vechileListDummy.add(vehicles7);
        vechileListDummy.add(vehicles8);
        vechileListDummy.add(vehicles9);
        vechileListDummy.add(vehicles10);
        vechileListDummy.add(vehicles11);
        
;
	}

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

	
	public List<Bookings> getBookingTestData() {
		return bookingList;
	}
	
	public List<Vehicles> getVehiclesTestData() {
		return vechileList;
	}

	public List<Vehicles> getVehiclesTestDatAfterSearch(String make,String type, String model, String iYear) {
		// TODO Auto-generated method stub
	
		if((make==""||make.equals(null)) && (model==""||model.equals(null)) && (iYear==""||iYear.equals(null)) && (type==""||type.equals(null))) {
			vechileList=vechileListDummy;
			return vechileList;
		}
		else if(!model.isEmpty()) {
			List<Vehicles> result = vechileList.stream()
				    .filter(b -> Objects.equals(b.getModel(), model))
				    .collect(Collectors.toList());
			
		vechileList=(ArrayList<Vehicles>) result;
		return vechileList;
		
		}
		else if(!make.isEmpty()) {
			List<Vehicles> result = vechileList.stream()
				    .filter(a -> Objects.equals(a.getMake(), make))
				    .collect(Collectors.toList());
			
		vechileList=(ArrayList<Vehicles>) result;
		return vechileList;
		
		}
		else if(!type.isEmpty()) {
			List<Vehicles> result = vechileList.stream()
				    .filter(c -> Objects.equals(c.getType(), type))
				    .collect(Collectors.toList());
			
		vechileList=(ArrayList<Vehicles>) result;
		return vechileList;
		
		}
		else if(!iYear.isEmpty()) {
			List<Vehicles> result = vechileList.stream()
				    .filter(d -> Objects.equals(d.getiYear(), iYear))
				    .collect(Collectors.toList());
			
		vechileList=(ArrayList<Vehicles>) result;
		return vechileList;
		
		}
		
		else {
			vechileList=vechileListDummy;
			return vechileList;
		}

	}


	
	public void setReturnDate(Long id, String date) {
		for(Bookings booking : bookingList) {
			if(id == booking.getClientID()) {
				if(booking.getReturnDate() == null) {
				booking.setReturnDate(date);
				}
			}
		}
	}
	
	public void setCancelDate(Long id, String date) {
		for(Bookings booking : bookingList) {
			if(id == booking.getClientID()) {
				if(booking.getCancelDate() == null) {
				booking.setCancelDate(date);
				}
			}
		}
	}

	/*
	 * public List<Vehicles> getVehiclesTestDatAfterSort(String sColHeaderPressed,
	 * String sOrder) { // TODO Auto-generated method stub return null; }
	 */
	

}

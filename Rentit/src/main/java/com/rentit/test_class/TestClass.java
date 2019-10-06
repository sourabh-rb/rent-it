package com.rentit.test_class;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.rentit.model.Bookings;
import com.rentit.model.Clerks;
import com.rentit.model.Clients;
import com.rentit.model.ModelWrapper;
import com.rentit.model.Vehicles;

public class TestClass {

	private static ArrayList<Clients> clientList;
	private static ArrayList<Vehicles> vechileList;
	private static ArrayList<Vehicles> vechileListDummy;
	private static ArrayList<Bookings> bookingList;
	private static ArrayList<Clerks> clerkList;
	//private static TestClass testData;
	static Long count = 5L;
	static Long bcnt = 801L;
	
	private static ArrayList<ModelWrapper> testEntries;

	
	public TestClass() {
		
		populateClerkList();
		populateVechileList();
		populateClientList();
		populateBookinList();
		populateTestEntries();
		
	}
	
	private static void populateTestEntries() {
		testEntries = new ArrayList<ModelWrapper>();
		
		for(int i = 0; i < 5; i++) {
			ModelWrapper entry = new ModelWrapper();
			entry.setClerk(clerkList.get(0));
			entry.setVehicle(vechileList.get(i));
			entry.setClient(clientList.get(i));
			entry.setBooking(bookingList.get(i));
			
			testEntries.add(entry);
			
		}
		
		
	}


	private static void populateClerkList() {
		
		clerkList = new ArrayList<Clerks>();
		
		Clerks clerk1 = new Clerks();
		
		clerk1.setId(1L);
		clerk1.setFirstName("Alex");
		clerk1.setLastName("Lyon");
		clerk1.setUsername("Alx2525");
		clerk1.setPassword("Password1!");
		clerk1.setEmail("alex25@gmail.com");
		
		clerkList.add(clerk1);
		
	}

	private static void populateBookinList() {
		
		bookingList = new ArrayList<Bookings>();
		
		Bookings booking1 = new Bookings();
		booking1.setBookingid(999L);
		booking1.setBookingTS("2019-09-20 8:38:12");
		booking1.setReturnDate(null);
		booking1.setStartDate("2019-09-25");
		booking1.setDueDate("2019-09-27");
		booking1.setCancelDate(null);
		booking1.setClientID(1L);
		
		bookingList.add(booking1);
		
		Bookings booking2 = new Bookings();
		booking2.setBookingid(929L);
		booking2.setBookingTS("2019-09-15 12:38:12");
		booking2.setReturnDate("2019-09-23");
		booking2.setStartDate("2019-09-20");
		booking2.setDueDate("2019-09-23");
		booking2.setCancelDate(null);
		booking2.setClientID(2L);
		
		bookingList.add(booking2);
		
		
		Bookings booking3 = new Bookings();
		booking3.setBookingid(939L);
		booking3.setBookingTS("2019-09-10 6:38:12");
		booking3.setReturnDate(null);
		booking3.setStartDate("2019-09-28");
		booking3.setDueDate("2019-09-29");
		booking3.setCancelDate("2019-09-27");
		booking3.setClientID(3L);
		
		bookingList.add(booking3);
		
		 
		Bookings booking4 = new Bookings();
		booking4.setBookingid(949L);
		booking4.setBookingTS("2019-09-05 14:38:12");
		booking4.setReturnDate(null);
		booking4.setStartDate("2019-09-06");
		booking4.setDueDate("2019-09-10");
		booking4.setCancelDate(null);
		booking4.setClientID(4L);

		bookingList.add(booking4);
		
		
		Bookings booking5 = new Bookings();
		booking5.setBookingid(959L);
		booking5.setBookingTS("2019-09-06 22:38:12");
		booking5.setReturnDate(null);
		booking5.setStartDate("2019-09-27");
		booking5.setDueDate("2019-09-10");
		booking5.setCancelDate(null);
		booking5.setClientID(5L);

		bookingList.add(booking5);
		
		
	}

	private void populateVechileList() {
		
		//public Vehicles(String id,String Make, String Model,String iYear,String Type) {
		vechileList = new ArrayList<Vehicles>();
		vechileListDummy = new ArrayList<Vehicles>();
        Vehicles vehicles1= new Vehicles(1,"alto","wrangler","2019","suv","black","XCB 468");
        Vehicles vehicles2=new Vehicles(2,"balto","xs","2020","muv","yellow","H3G 2H8");
        Vehicles vehicles3=new Vehicles(3,"calto","ml","2120","RUV","red","XH8 LKJ");
        Vehicles vehicles4=new Vehicles(4,"dalto","fbg","2023","kuv","blue","HF6 7HF");
        Vehicles vehicles5=new Vehicles(5,"ealto","gal","1900","creta4","green","JHV TD7");
        Vehicles vehicles6=new Vehicles(6,"felto","mal","2013","fuv","purple","GTD 8T8");
        Vehicles vehicles7=new Vehicles(7,"celtoi","ik","2012","kol","white","BD6 TS3");
        Vehicles vehicles8=new Vehicles (8,"belto","jk","2011","lki","black","TD7 VB8");
        Vehicles vehicles9=new Vehicles (9,"alto","ujk","2018","noi","magenta","TCX 9IK");
        Vehicles vehicles10=new Vehicles (10,"alto","liu","2020","moi","pink","75G BGJ");
        Vehicles vehicles11=new Vehicles (11,"alto","bo","2003","eri","blue","H3H 14T");
        Vehicles vehicles12=new Vehicles (12,"alto","jk","2020","moi","black","78G H5D");
        Vehicles vehicles13=new Vehicles (13,"zlto","jk","2003","eri","silver","8HF JH4");
        
        
        						 
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
        vechileList.add(vehicles12);
        vechileList.add(vehicles13);
        
        
        //By default sort condition for Make column ascending order
        Collections.sort(vechileList,(o1, o2) -> o1.getMake().compareTo(o2.getMake()));
        
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
        vechileListDummy.add(vehicles12);
        vechileListDummy.add(vehicles13);

	}

	private static void populateClientList() {
		
		clientList = new ArrayList<Clients>();

		Clients client1 = new Clients();
		client1.setClientID(1L);
		client1.setFirstName("Andrew");
		client1.setLastName("Neo");
		client1.setLicenceNumber("A-1234-123456-12");
		client1.setLicenceValidity("2020-09-20");
		client1.setPhone("1234567890");
		client1.setClerkID(clerkList.get(0).getId());
		
		clientList.add(client1);
		
		Clients client2 = new Clients();
		client2.setClientID(2L);
		client2.setFirstName("Fatima");
		client2.setLastName("Shaik");
		client2.setLicenceNumber("C-4321-123456-33");
		client2.setLicenceValidity("2021-08-01");
		client2.setPhone("0987654321");
		client2.setClerkID(clerkList.get(0).getId());
		
		clientList.add(client2);
		
		
		Clients client3 = new Clients();
		
		client3.setClientID(3L);
		client3.setFirstName("Vijay");
		client3.setLastName("Shankar");
		client3.setLicenceNumber("F-1212-098765-11");
		client3.setLicenceValidity("2020-01-29");
		client3.setPhone("1234566666");
		client3.setClerkID(clerkList.get(0).getId());
		
		clientList.add(client3);
		
		
		Clients client4 = new Clients();
		
		client4.setClientID(4L);
		client4.setFirstName("Rajesh");
		client4.setLastName("Rajkumar");
		client4.setLicenceNumber("Y-0909-098762-33");
		client4.setLicenceValidity("2022-02-10");
		client4.setPhone("7867564534");
		client4.setClerkID(clerkList.get(0).getId());
		
		clientList.add(client4);
		
		
		Clients client5 = new Clients();
		
		client5.setClientID(5L);
		client5.setFirstName("Nancy");
		client5.setLastName("Drew");
		client5.setLicenceNumber("Q-6677-999234-45");
		client5.setLicenceValidity("2023-09-20");
		client5.setPhone("1234567890");
		client5.setClerkID(clerkList.get(0).getId());
		
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

	@SuppressWarnings("unchecked")
	//public List<Vehicles> getVehiclesTestDatAfterSearch(String make,String type, String model, int iYear) {
	public List<Vehicles> getVehiclesTestDatAfterSearch(String make, String type, String model, String iYear) {
		// TODO Auto-generated method stub
	
		if((make==""||make.equals(null)) && (model==""||model.equals(null)) && (iYear==""||iYear.equals(null)) && (type==""||type.equals(null))) {
			vechileList=vechileListDummy;
			//Collections.sort(vechileList,(o1, o2) -> o1.getMake().compareTo(o2.getMake()));
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
			Collections.sort(vechileList,(o1, o2) -> o1.getMake().compareTo(o2.getMake()));
			return vechileList;
		}

	}


	public List<ModelWrapper> getTestEntries() {
		
		return testEntries;
	}
	
	
	public void setReturnDate(Long id, String date) {
		for(ModelWrapper booking : testEntries) {
			if(id == booking.getBooking().getClientID()) {
				if(booking.getBooking().getReturnDate() == null) {
				booking.getBooking().setReturnDate(date);
				}
			}
		}
	}
	
	public void setCancelDate(Long id, String date) {
		for(ModelWrapper booking : testEntries) {
			if(id == booking.getBooking().getClientID()) {
				if(booking.getBooking().getCancelDate() == null) {
				booking.getBooking().setCancelDate(date);
				}
			}
		}
	}

	public void addNewRecord(ModelWrapper entry) {
		


		ModelWrapper nw = new ModelWrapper();
		nw.setClient(entry.getClient());
		nw.setBooking(entry.getBooking());
		nw.setVehicle(testEntries.get(0).getVehicle());
		nw.setClerk(testEntries.get(0).getClerk());
		count += 1;
		bcnt += 1;
		nw.getClient().setClientID(count);
		nw.getBooking().setBookingid(bcnt);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		nw.getBooking().setBookingTS(now.toString());
		nw.getClient().setClerkID(testEntries.get(0).getClerk().getId());
		testEntries.add(nw);
		
	}



	

}

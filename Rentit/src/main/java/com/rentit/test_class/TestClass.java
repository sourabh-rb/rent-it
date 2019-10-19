package com.rentit.test_class;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
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
    private static LinkedList<Vehicles> vehicleListForDetailedView;
    private static ArrayList<Vehicles> vechileListDummy;
    private static ArrayList<Bookings> bookingList;
    private static ArrayList<Clerks> clerkList = new ArrayList<Clerks>();
    //private static TestClass testData;
    static Long count = 5L;
    static Long bcnt = 801L;
    static Long clerkcount = 1L;
    
    private static ArrayList<ModelWrapper> testEntries;
    private static ModelWrapper vehicleCatalog;
    

    
    public TestClass() {
        
        populateClerkList();
        populateVechileList();
        populateClientList();
        populateBookinList();
        populateTestEntries();
        vehicleCatalog = new ModelWrapper();
        vehicleCatalog.setCatalogList(vechileList);
        
    }
    
    private static void addClerks(Clerks clerks) {
        clerkList.add(clerks);
    }
    
    private static void addVechiles(Vehicles vehicles) {
    	vechileList.add(vehicles);
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
        
        //clerkList = new ArrayList<Clerks>();
        
        Clerks clerk1 = new Clerks();
        
        clerk1.setId(1L);
        clerk1.setFirstName("Alex");
        clerk1.setLastName("Lyon");
        clerk1.setUsername("Alx2525");
        clerk1.setPassword("Password1!");
        clerk1.setEmail("alex25@gmail.com");
        clerk1.setusergroup("clerk");
        
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
        
        vechileList = new ArrayList<Vehicles>();
        
        Vehicles vechile1 = new Vehicles();
        vechile1.setId(1);
        vechile1.setMake("Jeep1");
        vechile1.setModel("Wrangler1");
        vechile1.setiYear("2013");
        vechile1.setType("SUV1");
        vechile1.setColor("Green1");
        vechile1.setLicPlate("ABC 1231");
        vechile1.setVehicleAvailable(true);
        
        
        
        vechileList.add(vechile1);
    //  vechileListDummy.add(vechile1);

        Vehicles vechile2 = new Vehicles();
        vechile2.setId(2);
        vechile2.setMake("Jeep2");
        vechile2.setModel("Wrangler2");
        vechile2.setiYear("2011");
        vechile2.setType("SUV2");
        vechile2.setColor("Green2");
        vechile2.setLicPlate("ABC 1232");
        vechile2.setVehicleAvailable(true);
        
        vechileList.add(vechile2);
        //vechileListDummy.add(vechile2);
        
        
        Vehicles vechile3 = new Vehicles();
        vechile3.setId(3);
        vechile3.setMake("Jeep3");
        vechile3.setModel("Wrangler3");
        vechile3.setiYear("2012");
        vechile3.setType("SUV3");
        vechile3.setColor("Green3");
        vechile3.setLicPlate("ABC 1233");
        vechile3.setVehicleAvailable(true);
        
        
        vechileList.add(vechile3);
        //vechileListDummy.add(vechile3);
        
        
        Vehicles vechile4 = new Vehicles();
        vechile4.setId(4);
        vechile4.setMake("Jeep4");
        vechile4.setModel("Wrangler4");
        vechile4.setiYear("2012");
        vechile4.setType("SUV4");
        vechile4.setColor("Green4");
        vechile4.setLicPlate("ABC 1234");
        vechile4.setVehicleAvailable(false);
        
        
        vechileList.add(vechile4);
        //vechileListDummy.add(vechile4);
        
        
        Vehicles vechile5 = new Vehicles();
        vechile5.setId(5);
        vechile5.setMake("Jeep5");
        vechile5.setModel("Wrangler5");
        vechile5.setiYear("2015");
        vechile5.setType("SUV5");
        vechile5.setColor("Green5");
        vechile5.setLicPlate("ABC 1235");
        vechile5.setVehicleAvailable(true);
        
        vechileList.add(vechile5);
    //  vechileListDummy.add(vechile5);

        //By default sort condition for Make column ascending order
        Collections.sort(vechileList,(o1, o2) -> o1.getMake().compareTo(o2.getMake()));
        
     

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
    
    public void removeVehicleRecord(int id) {
    	for(Vehicles v : vechileList) {
    		if(id == v.getId()) {
    			vechileList.remove(v);
    			break;
    		}
    	}
    	
    }
    


    @SuppressWarnings("unchecked")
    //public  getVehiclesTestDatAfterSearch(String make,String type, String model, int iYear) {
    public ModelWrapper getVehiclesTestDatAfterSearch(String make, String type, String model, String iYear,String sLess,String sGreater) {
        // TODO Auto-generated method stub
    
        if((make==""||make.equals(null)) && (model==""||model.equals(null)) && (iYear==""||iYear.equals(null)) && (type==""||type.equals(null))) {
            vehicleCatalog.setCatalogList(vechileList);
            
            
        }
        else {
            
              if(sLess.equals("True")) {                  
                  List<Vehicles> result = vehicleCatalog.getCatalogList().stream()
                            .filter(b -> Objects.equals(b.getModel(), model)
                                        || Objects.equals(b.getMake(), make)
                                        || Objects.equals(b.getType(), type)
                                        ||  Integer.parseInt(b.getiYear())<= Integer.parseInt(iYear) 
                                        //|| (b.isAvailable() == true)
                                    )   
                            .collect(Collectors.toList());

                    
                  vehicleCatalog.setCatalogList(result);
              
              } else if(sGreater.equals("True")) {
                  
                  List<Vehicles> result = vehicleCatalog.getCatalogList().stream()
                            .filter(b -> Objects.equals(b.getModel(), model)
                                        || Objects.equals(b.getMake(), make)
                                        || Objects.equals(b.getType(), type)
                                        ||  Integer.parseInt(b.getiYear())>= Integer.parseInt(iYear)
                                            //  || (b.isAvailable() == true)
                                    )
                            .collect(Collectors.toList());

                    
                  vehicleCatalog.setCatalogList(result);
              
              } else if((sLess!="True") && (sGreater!="True")){
              
                  List<Vehicles> result = vehicleCatalog.getCatalogList().stream()
                            .filter(b -> Objects.equals(b.getModel(), model)
                                        || Objects.equals(b.getMake(), make)
                                        || Objects.equals(b.getType(), type)
                                        || Objects.equals(b.getiYear(), iYear)
                                        //|| (b.isAvailable() == true)
                                    )
                            .collect(Collectors.toList());

                    
                  vehicleCatalog.setCatalogList(result);
              }
             
            
        }
        
    return vehicleCatalog;

    }




    public List<ModelWrapper> getTestEntries() {
        return testEntries;
    }
    
    public List<Vehicles> getCatalogList() {
        return testEntries.get(0).getCatalogList();
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
        nw.setVehicle(entry.getVehicle());
        nw.setClerk(testEntries.get(0).getClerk());
        count += 1;
        bcnt += 1;
        nw.getClient().setClientID(count);
        nw.getBooking().setClientID(count);
        nw.getBooking().setBookingid(bcnt);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        nw.getBooking().setBookingTS(now.toString());
        nw.getClient().setClerkID(testEntries.get(0).getClerk().getId());
        
        
        
    }
   /**
    * This method is add new clerk
    * @param clerks
    */
    public void addNewClerk(Clerks clerks) {
Clerks clerk = new Clerks();
clerkcount++;
       //  clerkList = new ArrayList<Clerks>();
        clerk.setId(clerkcount);
        clerk.setFirstName(clerks.getFirstName());
        clerk.setLastName(clerks.getLastName());
        clerk.setUsername(clerks.getUsername());
        clerk.setPassword(clerks.getPassword());
        clerk.setEmail(clerks.getEmail());
        clerk.setusergroup(clerks.getusergroup());
        
       // clerkList.add(clerk);
        addClerks(clerk);
        
    }
    
    public void addNewVehicles(Vehicles VehiclesAttributes,int id) {
    	System.out.print("New ID created  :   "+VehiclesAttributes.getId()+1);
    	
    	VehiclesAttributes.setId(id);
    	VehiclesAttributes.setiYear(VehiclesAttributes.getiYear());
    	VehiclesAttributes.setMake(VehiclesAttributes.getMake());
    	VehiclesAttributes.setModel(VehiclesAttributes.getModel());
    	VehiclesAttributes.setType(VehiclesAttributes.getType());
    	VehiclesAttributes.setColor(VehiclesAttributes.getColor());
    	VehiclesAttributes.setLicPlate(VehiclesAttributes.getLicPlate());
    	
    	addVechiles(VehiclesAttributes);
    	
    }
    
    
    public List<Clerks> getClerksTestData() {
      return clerkList;
  }
 

    public ModelWrapper getVehicleCatalog() {
        
        return vehicleCatalog;
    }



    

}
package com.rentit.model;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rentit.test_class.TestClass;

/**
 * This is Bookings Service Layer
 * @author Sourabh Rajeev Badagandi
 *
 */
@Service
@Transactional
public class BookingService {

	private TestClass testData = new TestClass();
	
	/**
	 * This method is used to get all booking entries and their associated information.
	 * @return bookings
	 */
	public List<ModelWrapper> listAll() {
	
		return testData.getTestEntries();
		
	}
	 public List<ModelWrapper> ListAlltransactions(String cname,String vehicle,String duedate,String startdate){

       return testData.gettransactionTestDataAfterSearch(cname ,vehicle , duedate ,startdate);
   }
 
}

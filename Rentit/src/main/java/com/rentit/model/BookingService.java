package com.rentit.model;

import java.util.List;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import com.rentit.test_class.TestClass;

/**
 * This is Bookings Service Layer
 * 
 * @author Sourabh Rajeev Badagandi, Anusha
 * @version 1.0.0
 *
 */
@Service
//@Transactional
public class BookingService {

  private TestClass testData = new TestClass();

  /**
   * This method is used to get all booking entries and their associated information.
   * 
   * @return bookings
   */
  public List<ModelWrapper> listAll() {

    return testData.getTestEntries();

  }
  
  public ModelWrapper listAlltransaction() {

    return testData.getTestEntriesTransac();
  }

  /**
   * This methos is used to list all transactions based on given criteria.
   * @param cname
   * @param vehicle
   * @param duedate
   * @param startdate
   * @return
   */
  public List<ModelWrapper> ListAlltransactions(String cname, String vehicle, String duedate,
      String startdate) {

    return testData.gettransactionTestDataAfterSearch(cname,vehicle, duedate, startdate);
  }

}

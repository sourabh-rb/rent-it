package com.rentit.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
import com.rentit.test_class.TestClass;

/**
 * Clients service layer class.
 * 
 * @author Sourabh Rajeev Badagandi
 * @version 1.0.0
 *
 */
@Service
//@Transactional
public class ClientsService {


  private TestClass testData = new TestClass();

  /**
   * Method is used to get all client entries.
   * 
   * @return list of client records
   */
  public List<ModelWrapper> listAll() {

    return testData.getTestEntries();

  }

  /**
   * 
   * @param client
   */
  public void save(Clients client) {

  }

  /**
   * 
   * @param id
   * @return
   */
  public Clients get(Long id) {
    return null;
  }

  /**
   * 
   * @param id
   */
  public void delete(Long id) {

  }


  /**
   * This method is used to set return date of client.
   * 
   * @param id
   * @param date
   */
  public void setReturnDate(Long id, String date) {

    testData.setReturnDate(id, date);
  }

  /**
   * This method is used to set cncel date of client.
   * 
   * @param id
   * @param date
   */
  public void setCancelDate(Long id, String date) {

    testData.setCancelDate(id, date);
  }

  /**
   * This methos is used to get specified client record.
   * 
   * @param id
   * @return client record
   */
  public Clients getClientInfo(int id) {
    return testData.getClient(id);

  }

  /**
   * This methos is used to save client info.
   * 
   * @param clientDetails
   */
  public void saveClientInfo(Clients clientDetails) {

    testData.saveClientDetails(clientDetails);
  }



  /**
   * This method is used to add new booking record.
   * 
   * @param newBooking
   */
  public void saveNewBooking(ModelWrapper newBooking) {

    testData.addNewRecord(newBooking);

  }

}

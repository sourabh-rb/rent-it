package com.rentit.model;

import com.rentit.test_class.TestClass;

/**
 * This is Clerks Service layer
 * 
 * @author charan
 *
 */
public class ClerksService {
  private TestClass clerksdata = new TestClass();

  /**
   * This method is to add clerks data
   * 
   * @param clerks
   */
  public void addClerks(Clerks clerks) {
    clerksdata.addNewClerk(clerks);

  }
}

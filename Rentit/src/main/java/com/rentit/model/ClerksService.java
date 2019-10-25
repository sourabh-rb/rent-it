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
   * @throws Exception 
   */
  public void addClerks(Clerks clerks) throws Exception {
    clerksdata.addNewClerk(clerks);

  }
}

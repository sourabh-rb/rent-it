package com.rentit.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import com.rentit.data_source.BookingsDataGateway;
import com.rentit.data_source.ClientsDataGateway;

/**
 * BookingsDataMapper is used to map Bookings model attributes to the Booking table via the BookingsDataGateway.
 * @author Anusha Keralapura Thandavamurthy
 * @version 1.0.0
 *
 */

public class BookingsDataMapper {
  
 private BookingsDataGateway bookingGateway;
  
  public BookingsDataMapper() {
    bookingGateway = new BookingsDataGateway();
    
  }
  
  /**
   * This method is to add booking record.
   * @param book
   */
  public void addClientRecord(Bookings book) {
    
    bookingGateway.addBooking(book);
  }
  
  /**
   * This method used to map the booking table attributes to book object attributes.
   * 
   * @param recordData
   * @return book
   */
  private Bookings mapRecord(ArrayList<String> recordData) {
    Bookings book = new Bookings();
    book.setBookingid(Long.parseLong(recordData.get(0)));
    book.setReturnDate(recordData.get(1));
    book.setStartDate(recordData.get(2));
    book.setDueDate(recordData.get(3));
    book.setCancelDate(recordData.get(4));
    book.setClientID(Long.parseLong(recordData.get(5)));
   


    return book;

  }
  

}

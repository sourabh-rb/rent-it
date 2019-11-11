package com.rentit.model;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
  
  
  public ArrayList<Bookings> getBookingData() {
    
    ArrayList<Bookings> bookingData = new ArrayList<Bookings>();
    ArrayList<ArrayList<String>> data =  bookingGateway.listAll();
    
    for(ArrayList<String> r : data) {
      bookingData.add(mapRecord(r));
    }
    
    return bookingData;
    
  }
  
  /**
   * This method is to add booking record.
   * @param booking
   */
  public void addBookingRecord(Bookings booking) {
    
    bookingGateway.addEntry(booking);
  }
  
  /**
   * This method removes booking record.
   * @param bookingID
   */
  public void removeRecord(Long bookingID) {
    bookingGateway.removeEntry(bookingID);
  }
  
  /**
   * This method updates client record.
   * @param column
   * @param val
   * @param id
   */
  public void updateRecord(String column, String val, Long id) {
    bookingGateway.updateEntry(column, val, id);
  }
  
  /**
   * This method returns client record.
   * @param bookingID
   * @return
   */
  public Bookings getRecord(Long bookingID) {
    ArrayList<String> record = bookingGateway.getEntry(bookingID);
    
    return mapRecord(record);
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
    book.setBookingTS(recordData.get(1));
    book.setReturnDate(recordData.get(2));
    book.setStartDate(recordData.get(3));
    book.setDueDate(recordData.get(4));
    book.setCancelDate(recordData.get(5));
    book.setClientID(Long.parseLong(recordData.get(6)));
    book.setVehicleID(Long.parseLong(recordData.get(7)));
   
    return book;

  }

  public void processReturn(Long id) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    
    updateRecord("returnDate", dtf.format(now), id);
  }
  
  public void processCancel(Long id) {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    
    updateRecord("cancelDate", dtf.format(now), id);
  }
  
  public void processDelete(Long id) {
    bookingGateway.removeClientandBookingEntry(id);
  }
  
  
 
  

}

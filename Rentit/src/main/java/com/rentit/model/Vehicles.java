package com.rentit.model;

/**
 * Vehicles model class.
 * 
 * @author Basant Gera
 *
 */
public class Vehicles {
  private Integer id;
  private String LicPlate;
  private String Type;
  private String Make;
  private String Model;
  private String iYear;
  private String Color;
  private String bookingStartDate;
  private String bookingEndDate;
  private Integer bookingId;


  public int index;

  public Vehicles(int id, String Make, String Model, String iYear, String Type, String Color,
      String LicPlate, int bookingId) {
    super();
    this.id = id;
    this.Make = Make;
    this.Model = Model;
    this.Type = Type;
    this.iYear = iYear;
    this.Color = Color;
    this.LicPlate = LicPlate;
    this.bookingId = bookingId;
  }

  public Vehicles() {
    this.id = index++;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLicPlate() {
    return LicPlate;
  }

  public void setLicPlate(String licPlate) {
    LicPlate = licPlate;
  }

  public String getType() {
    return Type;
  }

  public void setType(String type) {
    Type = type;
  }

  public String getMake() {
    return Make;
  }

  public void setMake(String make) {
    Make = make;
  }

  public String getModel() {
    return Model;
  }

  public void setModel(String model) {
    Model = model;
  }

  public String getiYear() {
    return iYear;
  }

  public void setiYear(String iYear) {
    this.iYear = iYear;
  }

  public String getColor() {
    return Color;
  }

  public void setColor(String color) {
    Color = color;
  }

  @Override
  public String toString() {
    return "Vehicles [id=" + id + ", LicPlate=" + LicPlate + ", Type=" + Type + ", Make=" + Make
        + ", Model=" + Model + ", iYear=" + iYear + ", Color=" + Color + ", index=" + index + "]";
  }

  public String getBookingStartDate() {
    return bookingStartDate;
  }

  public void setBookingStartDate(String bookingStartDate) {
    this.bookingStartDate = bookingStartDate;
  }

  public String getBookingEndDate() {
    return bookingEndDate;
  }

  public void setBookingEndDate(String bookingEndDate) {
    this.bookingEndDate = bookingEndDate;
  }
   public Integer getBookingId() {
     return bookingId;
   }
   
   public void setbookingId(Integer bookingId) {
     this.bookingId=bookingId;
   }

}

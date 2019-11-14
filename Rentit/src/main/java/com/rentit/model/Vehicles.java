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


  private boolean isAvailable = true;

  public boolean isVehicleAvailable() {
    return isAvailable;
  }
/**
 * setter set is available
 * @param isAvailable
 */
  public void setVehicleAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

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
  /**
   * getter get id.
   * @return
   */
  public Integer getId() {
    return id;
  }
  /**
   * setter set id.
   * @param id
   */
  public void setId(Integer id) {
    this.id = id;
  }
  /**
   * getter get licplate
   * @return
   */
  public String getLicPlate() {
    return LicPlate;
  }
  /**
   * setter set Licplate
   * @param licPlate
   */
  public void setLicPlate(String licPlate) {
    LicPlate = licPlate;
  }
  /**
   * getter get type.
   * @return
   */
  public String getType() {
    return Type;
  }
  /**
   * setter set type.
   * @param type
   */
  public void setType(String type) {
    Type = type;
  }
  /**
   * getter get make.
   * @return
   */
  public String getMake() {
    return Make;
  }
  /**
   * setter set make.
   * @param make
   */
  public void setMake(String make) {
    Make = make;
  }
  /**
   * getter get model.
   * @return
   */
  public String getModel() {
    return Model;
  }
  /**
   * setter set model.
   * @param model
   */
  public void setModel(String model) {
    Model = model;
  }
  /**
   * getter get iyear.
   * @return
   */
  public String getiYear() {
    return iYear;
  }
  /**
   * setter set iyear.
   * @param iYear
   */
  public void setiYear(String iYear) {
    this.iYear = iYear;
  }
  /**
   * getter get color.
   * @return
   */
  public String getColor() {
    return Color;
  }
  /**
   * setter set color.
   * @param color
   */
  public void setColor(String color) {
    Color = color;
  }

  @Override
  public String toString() {
    return "Vehicles [id=" + id + ", LicPlate=" + LicPlate + ", Type=" + Type + ", Make=" + Make
        + ", Model=" + Model + ", iYear=" + iYear + ", Color=" + Color + ", index=" + index + "]";
  }
  /**
   * getter get booking start date.
   * @return
   */
  public String getBookingStartDate() {
    return bookingStartDate;
  }
  /**
   * setter set booking start date.
   * @param bookingStartDate
   */
  public void setBookingStartDate(String bookingStartDate) {
    this.bookingStartDate = bookingStartDate;
  }
  /**
   * getter get booking date.
   * @return
   */
  public String getBookingEndDate() {
    return bookingEndDate;
  }
  /**
   * setter set booking end date.
   * @param bookingEndDate
   */
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

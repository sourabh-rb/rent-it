package com.rentit.data_source;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import com.rentit.model.Vehicles;

/**
 * Admin DataGateway layer Added for Sql queries and Java Connectivity.
 * 
 * @author Basant Gera
 *
 */
public class AdminDataGateway {
  
/**
 * Database connection variable
 */
  private DatabaseConfig db;
  
  /**
   * 
   * @return a array List containing number of Columns with there respective details
   */
  public ArrayList<ArrayList<String>> listAll() {
    db = DatabaseConfig.getDBInstance();  
    ResultSet rs= db.executeCommand("select * from vehicles order by iYear ASC"); 

    ArrayList<ArrayList<String>> vehiclesData = new ArrayList<ArrayList<String>>();
    try {
      while(rs.next()) {
        ArrayList<String> entry = new ArrayList<String>();
        for(int i = 1; i <= 9; i++) {
          entry.add(rs.getString(i));
        }

        vehiclesData.add(entry);
      }

    } catch (SQLException e) {e.printStackTrace();}

    return vehiclesData;
  }
  
    
    /**
     * Ths method removes the vehicles based on id.
     * @param vehiclesID Id for from Vehicle Table
     */
    public void removeVehiclesEntry(int vehiclesID) {
      db = DatabaseConfig.getDBInstance();
      String sqlCmd ="DELETE FROM vehicles WHERE id = " + vehiclesID + ";" ;
      db.updateCommand(sqlCmd);
    }
  

    /**
     * 
     * @param Make Parameters Used to search for make
     * @param Type Parameters Used to search for make
     * @param Model Parameters  Used to search for Model
     * @param iYear Parameters  Used to search for Year
     * @param sLess Parameters  Used to search  for Less than Year
     * @param sGreater Parameters  Used to search Greater than Year
     * @return 
     */
    public ArrayList<ArrayList<String>> fncSearchVehicles(String Make, String Type, String Model, String iYear,
        String sLess, String sGreater) {
      db = DatabaseConfig.getDBInstance();  
      ResultSet rs;
      if (sLess.equals("True"))
      {
        if(iYear.equalsIgnoreCase("")) {
          rs= db.executeCommand("SELECT * FROM vehicles WHERE"
              + " Type LIKE '%" + Type + "%'" + "AND" 
              + " Make LIKE '%" + Make + "%'" + "AND" 
              + " Model LIKE '%" + Model + "%'" + "AND" 
              + " iYear LIKE '%" + iYear + "%'" +"order by iYear ASC"
              );
        }
        else
        {
          rs= db.executeCommand("SELECT * FROM vehicles WHERE"
              + " Type LIKE '%" + Type + "%'" + " AND " 
              + " Make LIKE '%" + Make + "%'" + " AND " 
              + " Model LIKE '%" + Model + "%'" + " AND "
              + " iYear <= "  + iYear 
              +" order by iYear ASC"
              );
        }
       
      }
      
      else if (sGreater.equals("True")) {
        if(iYear.equalsIgnoreCase("")) {
          rs= db.executeCommand("SELECT * FROM vehicles WHERE"
              + " Type LIKE '%" + Type + "%'" + "AND" 
              + " Make LIKE '%" + Make + "%'" + "AND" 
              + " Model LIKE '%" + Model + "%'" + "AND" 
              + " iYear LIKE '%" + iYear + "%'" +"order by iYear ASC"
              );
        }
        else {
          rs= db.executeCommand("SELECT * FROM vehicles WHERE"
              + " Type LIKE '%" + Type + "%'" + " AND " 
              + " Make LIKE '%" + Make + "%'" + " AND " 
              + " Model LIKE '%" + Model + "%'" + " AND " 
              + " iYear >= "  + iYear  
              +" order by iYear ASC"
              );
        }
       
        
      }
      else {

         rs= db.executeCommand("SELECT * FROM vehicles WHERE"
            + " Type LIKE '%" + Type + "%'" + "AND" 
            + " Make LIKE '%" + Make + "%'" + "AND" 
            + " Model LIKE '%" + Model + "%'" + "AND" 
            + " iYear LIKE '%" + iYear + "%'" +"order by iYear ASC"
            );
      }
    
   
      
  /**
   * ArrayList returning data for vehicle
   */
      ArrayList<ArrayList<String>> vehiclesData = new ArrayList<ArrayList<String>>();
      try {
        while(rs.next()) {
          ArrayList<String> entry = new ArrayList<String>();
          for(int i = 1; i <= 8; i++) {
            entry.add(rs.getString(i));
          }

          vehiclesData.add(entry);
        }

      } catch (SQLException e) {e.printStackTrace();}

      return vehiclesData;
    }
    
    /**
     * 
     * @param vehicleID  Current vechile ID for DML (Select command)
     * @return Return the array List with code conataing select command
     */
    public ArrayList<String> getEntry(Long vehicleID) {
      ArrayList<String> vehc = new ArrayList<String>();
      db = DatabaseConfig.getDBInstance();
      String sqlCmd ="SELECT * FROM vehicles WHERE id = " + vehicleID + ";";
      ResultSet rs = db.executeCommand(sqlCmd);

      try {
        while(rs.next()) {
          for(int i = 1; i <= 9; i++) {
            vehc.add(rs.getString(i));
          } 
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
       
      return vehc; 
    }
    
    /**
     * This method is used to add vehicles.
     * @param vec  Vehicle Object  
     * @throws ParseException  Parse exception 
     */
     
    public int addVehicles(Vehicles vec) throws ParseException {
      int m=0;
      db = DatabaseConfig.getDBInstance();
      String sqlCmd="INSERT INTO vehicles VALUES "
       + "("+"id" +","
       + "'"+vec.getMake()+"','"
       +  vec.getModel().trim() + "','" 
       + vec.getiYear().trim() + "','" 
       + vec.getType().trim() + "','" 
       + vec.getLicPlate().trim() + "','" 
       + vec.getColor().trim() + "',"
           + m +  ", " + (vec.getVersion() + 1L) + ");" ;   
      return db.updateCommand(sqlCmd);
    }
     /**
      * This method is used to update the vehicles details.
      * @param vec Vechile object to update the coulmn name with updated name in Database
      */
     
    public int updateVehiclesEntry(Vehicles vec, Long version) {
      db = DatabaseConfig.getDBInstance();
      String colum1="Make";
      String colum2="Model";
      String colum3="iYear";
      String colum4="Type";
      String colum5="LicPlate";
      String colum6="Color";
     
      String sqlCmd ="UPDATE vehicles SET " + colum1 + " = '" + vec.getMake() + "' "+","
          + colum2 + " = '" + vec.getModel() + "' "+","
          + colum3 + " = '" + vec.getiYear() + "' "+","
          + colum4 + " = '" + vec.getType() + "' "+","
          + colum5 + " = '" + vec.getLicPlate() + "' "+","
          + colum6 + " = '" + vec.getColor() + "' "
          + "version = " + (vec.getVersion() + 1L) 
          + "WHERE id = " + vec.getId() + " AND version = " + version + ";" ;
      
      return db.updateCommand(sqlCmd);

    }
    
    public String getVersion(Long vehicleID) {
      String v = null;
      ResultSet rs= db.executeCommand("select version FROM vehicles WHERE id = " + vehicleID + ";"); 
      try {
        while(rs.next()) {
          v = rs.getString(1);
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      return v;
    }
    
    public int updateVersion(Long id, Long version) {
      db = DatabaseConfig.getDBInstance();
      String sqlCmd ="UPDATE vehicles SET version = " + (version + 1L) + " WHERE id = " + id + " AND vehicles.version = " + version + ";" ;

      return db.updateCommand(sqlCmd);
    }
    
    
}

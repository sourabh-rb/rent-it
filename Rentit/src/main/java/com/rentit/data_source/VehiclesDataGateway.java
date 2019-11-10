package com.rentit.data_source;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.rentit.model.Clients;
import com.rentit.model.Vehicles;

public class VehiclesDataGateway {

  private DatabaseConfig db;
  
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
  
  //String sDate1="11/09/2019";  
  //String eDate2 = "11/12/2019";
 
  
  public void addVehicles(Vehicles vec) throws ParseException {
    String sDate1="2019-11-29";  
    String eDate2 = "2019-12-12";
    //sDate1 = new SimpleDateFormat("yyyy-MM-dd").parse(sDate1).toString();
    //eDate2 = new SimpleDateFormat("yyyy-MM-dd").parse(eDate2).toString();
    db = DatabaseConfig.getDBInstance();
    String sqlCmd="INSERT INTO vehicles VALUES "
     + "("+"id" +","
     + "'"+vec.getMake()+"','"
     +  vec.getModel().trim() + "','" 
     + vec.getiYear().trim() + "','" 
     + vec.getType().trim() + "','" 
     + vec.getLicPlate().trim() + "','" 
     + vec.getColor().trim() + "','"
     +sDate1+"','"
     +eDate2+"')";
    //String cmdlove=sqlCmd;
    // System.out.println(cmdlove);   
    db.updateCommand(sqlCmd);


  }
  
  public void removeVehiclesEntry(int vehiclesID) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd ="DELETE FROM vehicles WHERE id = " + vehiclesID + ";" ;
    db.updateCommand(sqlCmd);
  }
  
  public void updateVehiclesEntry(String column, String newValue, Long vehiclesID) {
   // to be done by Arvind
   // for admin page
  }
  
  public ArrayList<String> getEntry(Long clientID) {
    ArrayList<String> vehc = new ArrayList<String>();
    // to be done by Arvind
    // for vehicle page detailed view
    return vehc; 
  }
  
 
  
  
}

package com.rentit.data_source;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.rentit.model.Clerks;

/**
 * This class is gateway for Clerks model and Clerks Table in DB.
 * 
 * @author Sai Charan Duduka
 *
 */
public class ClerksDataGateway {

  private DatabaseConfig db;

  /**
   * This method gets the complete clerks data
   * 
   * @return clerks data in ArrayList
   */
  public ArrayList<ArrayList<String>> listData() {
    db = DatabaseConfig.getDBInstance();
    ResultSet rs = db.executeCommand("select * from clerks");

    ArrayList<ArrayList<String>> clerkData = new ArrayList<ArrayList<String>>();
    try {
      while (rs.next()) {
        ArrayList<String> entry = new ArrayList<String>();
        for (int i = 1; i <= 7; i++) {
          entry.add(rs.getString(i));
        }

        clerkData.add(entry);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }

    return clerkData;
  }

  /**
   * This method is to add clerk data to DB
   * 
   * @param clerk
   */
  public void addEntry(Clerks clerk) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd =
        "INSERT INTO clerks (id, firstName, lastName, username, password, email, usergroup)";
    sqlCmd += " VALUES ( " + clerk.getId() + ",'" + clerk.getFirstName() + "', '"
        + clerk.getLastName() + "', '" + clerk.getUsername() + "', '" + clerk.getPassword() + "', '"
        + clerk.getEmail() + "', '" + clerk.getusergroup() + "')";


    db.updateCommand(sqlCmd);


  }

  /**
   * This method is to get specific entry of clerk based on username
   * 
   * @param username
   * @return
   */
  public ArrayList<String> getEntry(String username) {
    db = DatabaseConfig.getDBInstance();
    String sqlCmd = "SELECT * from clerks WHERE username = '" + username + "';";
    ArrayList<String> rec = new ArrayList<String>();
    ResultSet rs = db.executeCommand(sqlCmd);
    int count = 1;
    try {
      while (rs.next()) {
        rec.add(rs.getString(count));

        count++;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return rec;
  }

}

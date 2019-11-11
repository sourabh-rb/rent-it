package com.rentit.data_source;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * DatabaseConfig is used to configure and connect to MySQL Database according to the set application properties.
 * @author Sourabh Rajeev Badagandi
 * @version 1.0.0
 *
 */
public class DatabaseConfig {

  private static final String APPLICATION_PROPERTIES = "src//main//resources//application.properties";
  private String dbUrl;
  private String dbUsername;
  private String dbPassword;
  private Connection dbConnection;
  private static DatabaseConfig dbConfig = null;
  
  /**
   * The method read the properties file and initiates DB connection.
   */
  private DatabaseConfig() {
    try {
      InputStream in = new FileInputStream(APPLICATION_PROPERTIES);
      Properties p = new Properties();
      p.load(in);
      this.dbUrl = p.getProperty("datasource.url");
      this.dbUsername = p.getProperty("datasource.username");
      this.dbPassword = p.getProperty("datasource.password");
      this.init();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
  }
  
  /**
   * This method is used to get the active DB connection instance.
   * @return dbConfig
   */
  public static DatabaseConfig getDBInstance() {
    if(dbConfig == null) {
      dbConfig = new DatabaseConfig();
      return dbConfig;
    }
    else {
      return dbConfig;
    }
  }
  
  /**
   * This methos initializes the conncetion to MySQL DB using JDBC driver.
   */
  private void init() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");  
      dbConnection = DriverManager.getConnection(this.dbUrl, this.dbUsername, this.dbPassword);   
    }catch(Exception e) {System.out.println(e);}
  }
  
  /**
   * This method is used to close DB connection.
   */
  public void closeDBConnection() {
    try {
      dbConnection.close();
    } catch (SQLException e) { e.printStackTrace();} 
  }
  
  /**
   * This methos returns the result of execute Query.
   * @param SQL cmd
   * @return Result
   */
  public ResultSet executeCommand(String cmd) {
    ResultSet res = null;
    try {
    Statement stmt = dbConnection.createStatement();  
    res=stmt.executeQuery(cmd);
    } catch (SQLException e){ e.printStackTrace();} 
    
    return res;
    
  }
  
  /**
   * This methos returns the result of update Query.
   * @param SQL cmd
   */
  public void updateCommand(String cmd) {
    Statement stmt;
    try {
      stmt = dbConnection.createStatement();
      stmt.executeUpdate(cmd);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
}

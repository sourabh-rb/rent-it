/**
 * 
 */
package com.rentit.model;

import java.util.HashMap;

/**
 * @author kotic
 *
 */
public class Login {
  private String username;
  private String password;
  
  private static HashMap<String, String> credHashMap = new HashMap<String, String>();
  
 public String getUsername() {
   return username;
 }
 public void setUsername(String Username) {
   this.username=Username;
 }
 public String getPassword() {
   return password;
 }
 public void setPassword(String Password) {
   this.password=Password;
 }
 
 public void addCredentials(String username, String password) {
	 
	 credHashMap.put(username, password);
	}
	
public boolean checkPassword(String username, String password) {
		if(credHashMap.containsKey(username)) {
			if(password.equals(credHashMap.get(username))) 
				return true;
			return false;
		}
		return false;
		
	}

}

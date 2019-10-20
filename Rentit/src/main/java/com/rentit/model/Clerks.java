package com.rentit.model;

/**
 * CLerks model class
 * 
 * @author Sourabh Rajeev Badagandi
 * @version 1.0.0
 *
 */
public class Clerks {

  private Long id;
  private String first_name;
  private String last_name;
  private String username;
  private String password;
  private String email;
  private String usergroup;

  /**
   * Clerks Constructor.
   */
  public Clerks() {
    super();
  }

  /**
   * Getter: clerk id.
   * @return id
   */
  public Long getId() {
    return id;
  }

  /**
   * Setter: clerk id.
   * @param id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Getter: clerk first name.
   * @return first_name
   */
  public String getFirstName() {
    return first_name;
  }

  /**
   * Setter: clerk first_name.
   * @param firstname
   */
  public void setFirstName(String firstname) {
    this.first_name = firstname;
  }

  /**
   * Setter: user groups.
   * @param usergroup
   */
  public void setusergroup(String usergroup) {
    if (usergroup != null)
      this.usergroup = "admin";
    else {
      this.usergroup = "clerk";
    }
  }

  /**
   * Getter user group
   * @return user group
   */
  public String getusergroup() {
    return this.usergroup;
  }

  /**
   * Getter : clerk last name
   * @return
   */
  public String getLastName() {
    return last_name;
  }

  /**
   * Setter: clerk last name
   * @param lastname
   */
  public void setLastName(String lastname) {
    this.last_name = lastname;
  }

  /**
   * Getter username
   * @return
   */
  public String getUsername() {
    return username;
  }

  /**
   * Setter username
   * @param username
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Getter password
   * @return
   */
  public String getPassword() {
    return password;
  }

  /**
   * Setter password
   * @param password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Getter email
   * @return
   */
  public String getEmail() {
    return email;
  }

  /**
   * Setter email.
   * @param email
   */
  public void setEmail(String email) {
    this.email = email;
  }


}

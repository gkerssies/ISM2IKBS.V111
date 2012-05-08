/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;
import java.io.Serializable;

/**
 * The authentication class used for sharing authentication info.
 * @author Janssen-laptop
 * @version 0.1 - 29 april 2012
 */
public class Auth implements Serializable{
  
  private String username;
  private String password;
  private UserType usertype;
  
  /**
   * Constructor for Auth Class.
   * @param username the username
   * @param password the password
   * @param usertype the usertype
   */
  public Auth(String username,String password,UserType usertype)
  {
    this.username = username;
    this.password = password;
    this.usertype = usertype;
  }

  /**
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @return the usertype
   */
  public UserType getUsertype() {
    return usertype;
  }
}

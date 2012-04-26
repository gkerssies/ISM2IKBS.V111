/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;
import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author Janssen-laptop
 */
public class User implements Serializable{
 
  private ArrayList<String> username;
  private ArrayList<String> password;
  private ArrayList<String> userType;
  
  /** Constructor for User class
  * 
  */
  public User()
  {
    username = new ArrayList<String>();
    password = new ArrayList<String>();
    userType = new ArrayList<String>();
  }
  public void addUser(String username,String password,UserType type)
  {
    
  }
}

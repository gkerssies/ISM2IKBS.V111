/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author Jormen Janssen
 * @version 0.1 - 26 april 2012
 */
public class User implements Serializable {

  private ArrayList<String> username;
  private ArrayList<String> password;
  private ArrayList<UserType> userType;

  /**
   * Constructor for User class
   *
   */
  public User() {
    username = new ArrayList<String>();
    password = new ArrayList<String>();
    userType = new ArrayList<UserType>();
  }

  /**
   * Method for adding a user.
   *
   * @param username the username
   * @param password the password
   * @param usertype the usertype for the password
   *
   * @return returns true if the user is added or false if the user already
   *         exsist
   *
   */
  public boolean addUser( String username, String password, UserType usertype ) {
    if ( this.username.contains( username ) ) {
      return true;
    } else {
      this.username.add( username );
      this.password.add( password );
      this.userType.add( usertype );
      return false;
    }
  }

  /**
   * Method for modifying a user.
   *
   * @param username the username from user that is edited
   * @param password the new password
   * @param userType the new usertype
   *
   * @return returns true if the user is succesfully modified
   *
   */
  public boolean setUser( String username, String password, UserType usertype ) {
    int position = 0;
    if ( this.username.contains( username ) ) {
      for ( String u : this.username ) {
        if ( u.equals( username ) ) {
          break;
        } else {
          position++;
        }
      }
      this.password.set( position, password );
      this.userType.set( position, usertype );
      return true;
    } else {
      return false;
    }
  }

  /**
   * Method for removing a user.
   *
   * @param username the username from user that should be removed
   *
   * @return returns true if the user is succesfully removed
   *
   */
  public boolean removeUser( String username ) {
    int position = 0;
    if ( this.username.contains( username ) ) {
      for ( String u : this.username ) {
        if ( u.equals( username ) ) {
          break;
        } else {
          position++;
        }
      }
      this.password.remove( position );
      this.userType.remove( position );
      return true;
    } else {
      return false;
    }
  }

  /**
   * Method for verifying a user credential.
   *
   * @param username the username for the credential
   * @param password the username for the credential
   *
   * @return returns true if the credential is succesfully verified
   */
  public boolean verifyCredential( String username, String password ) {
    int position = 0;
    if ( this.username.contains( username ) ) {
      for ( String u : this.username ) {
        if ( u.equals( username ) ) {
          break;
        } else {
          position++;
        }
      }
      String dbPassword = this.password.get( position );
      if ( dbPassword.equals( password ) ) {
        return true;
      } else {
        return false;
      }

    } else {
      return false;
    }
  }

  /**
   * Method for getting the user type.
   *
   * @param username the username
   *
   * @return returns the type of the current user
   */
  public UserType getUserType( String username ) {
    int position = 0;
    if ( this.username.contains( username ) ) {
      for ( String u : this.username ) {
        if ( u.equals( username ) ) {
          break;
        } else {
          position++;
        }
      }

    } else {
      return null;
    }
    return this.userType.get( position );
  }

  /**
   * Method for returning the complete user database(Testing purpose)
   * @return returns the complete userdatabase as a string
   */
  @Override
  public String toString() {
    String t = "";
    int y = 0;
    for ( String x : username ) {
      t += x + " " + password.get( y ) + " " + userType.get( y ) + "\r\n";
      y++;
    }
    return t;
  }
}

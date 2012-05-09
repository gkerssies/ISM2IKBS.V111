/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;
import java.io.Serializable;

/**
 *
 * @author Jormen Janssen
 * @version 0.1 - 26 april 2012
 */
public class Database implements Serializable{

  private String name;
  private String host;
  private int port;
  private String username;
  private String password;

  /**
   * Discription of the constructor from the database class
   *
   * @param name     the name of the database
   * @param host     the database host of the database
   * @param port     the port of the databaseserver
   * @param username the username of the database
   * @param password the password of the database
   */
  public Database( String name, String host, int port, String username, String password ) {
    this.name = name;
    this.host = host;
    this.port = port;
    this.username = username;
    this.password = password;
  }

  /**
   * @return the name of the database
   */
  public String getName() {
    return name;
  }

  /**
   * @return the name of the databaseserver
   */
  public String getHost() {
    return host;
  }

  /**
   * @return the port of the databaseserver
   */
  public int getPort() {
    return port;
  }

  /**
   * @return the username of the databaseserver
   */
  public String getUsername() {
    return username;
  }

  /**
   * @return the password of the databaseserver
   */
  public String getPassword() {
    return password;
  }
  
  /**
   * method for database settings (Development purpose!!!)
   * @return the complete database setting 
   */
  @Override
  public String toString(){
    return name + " " + host + " " + port + " " + username + " " + password;
  }
}

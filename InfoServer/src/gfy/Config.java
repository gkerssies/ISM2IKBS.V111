/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

/**
 * Config class for the server configuration holds : Global settings, Navison Settings and the user database.
 * @author Jormen Janssen
 * @version 0.1 - 26 april 2012
 */
public class Config {

  private int serverport;
  private Database database;
  private User userdatabase;

  /**
   * Constructor for the config class
   *
   * @param serverport   the tcp port number for the TCP/IP server
   * @param Database     the database settings for the config
   * @param userdatabase the memory based userdatabase
   */
  public Config( int serverport, Database database, User userdatabase ) {
    this.serverport = serverport;
    this.database = database;
    this.userdatabase = userdatabase;
  }

  /**
   * @return the serverport
   */
  public int getServerport() {
    return serverport;
  }

  /**
   * @param serverport the serverport to set
   */
  public void setServerport( int serverport ) {
    this.serverport = serverport;
  }

  /**
   * @return the database
   */
  public Database getDatabase() {
    return database;
  }

  /**
   * @return the userdatabase
   */
  public User getUserdatabase() {
    return userdatabase;
  }

  /**
   * @param database the database settings to set
   */
  public void setDatabase( Database database ) {
    this.database = database;
  }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

/**
 *
 * @author Jormen Janssen
 * @version 0.1 - 26 april 2012
 */
public class Config {
  
  private int serverport;
  private Database database;
  private User userdatabase;

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
  
}

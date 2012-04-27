/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jormen Janssen
 * @version 0.1 - 26 april 2012
 */
public class Server extends Thread{

  Config config;
  ArrayList<Client> client;
  ServerSocket serversocket;
  /**
   * Constructor for server
   * @param config for the server
   */
  public Server( Config config ){
    this.config = config;
    client = new ArrayList<Client>();
  }
  
  /**
   * Method for multithreaded code to execute (implements Runable).
   * @param config for the server
   */
  @Override
  public void run()
  {
    try {
      serversocket = new ServerSocket(config.getServerport());
      
    }
    catch ( IOException ex ) {
      Log.addItem("Thread exception", ex.getMessage(),"Er is een fout opgetreden tijdens het starten van de server", LogType.Error);
    }
    System.out.println(new Log().toString());
  }
  
}

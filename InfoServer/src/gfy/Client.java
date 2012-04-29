/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jormen Janssen
 * @version 0.1 - 29 april 2012
 */
public class Client extends Thread{
  
 private Socket socketclient;
 private ServerSocket socketserver;
 private Server server;
 private Protocol protocol;
 
 /**
* Constructor for new client
* @param the underlying server
 */
 public Client(Server server)
 {
   this.server = server;
   this.socketserver = server.getServerSocket();
 }
 
 /**
   * Method for multithreaded code to execute (implements Runable).
 */
 @Override
 public void run()
 {
    try 
    {
      socketclient = socketserver.accept();
      Log.addItem("Client verbonden @ "+socketclient.getInetAddress(),"", "Cl", LogType.Event);
    } 
    
    catch (IOException ex) 
    {
      Log.addItem("IO Exception @ client", ex.getMessage(), "Er is een IO fout opgetreden tijdens het opzetten van de verbinding", LogType.Error);
      Logger.getLogger( Client.class.getName() ).log( Level.SEVERE, null, ex );
    }
   
 }
 
 
  
}

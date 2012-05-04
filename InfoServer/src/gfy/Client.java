/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.net.ServerSocket;
import java.net.Socket;

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
   
 }
 
 
  
}

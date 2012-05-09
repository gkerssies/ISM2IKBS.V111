/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Client connection class 
 * @author Janssen-laptop
 * @version 0.1 - 8 mei 2012
 */
public class ClientConnection extends Thread {

  private Socket clientsocket;
  private ObjectOutputStream objectlineout;
  private ObjectInputStream objectlinein;
  private String host;
  private int port;
  private ClientProtocol protocol;

  /**
   * Constructor for the client connection.
   * @param Host the host ipadress
   * @param Port the server port application
   */
  public ClientConnection( String host, int port ) {
    this.host = host;
    this.port = port;
    
  }
  
 public ClientProtocol getProtocol()
 {
   return this.protocol;
 }

  @Override
  public void run()
  {
    try
    {
    
    
    clientsocket = new Socket( "Localhost", 4444 );
    protocol = new ClientProtocol();
    protocol.bindStreams( clientsocket );
    protocol.sendCommand("WELCOME");
    
      
    
    while(getClientsocket().isConnected())
    {
      if(protocol.isBusy() == false)
      {
        protocol.proccesCommand();
      }
    }
    
    }
    catch(Exception ex)
    {
      System.out.println( "Fout tijdens verbinden" + ex.getMessage() );
    }
  
  }
  public boolean isConnected() 
  {
    return getClientsocket().isConnected();
  }

  /**
   * @return the clientsocket
   */
  public Socket getClientsocket() {
    return clientsocket;
  }
}

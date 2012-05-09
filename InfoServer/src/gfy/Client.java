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
public class Client extends Thread {

  private Socket socketclient;
  private ServerSocket socketserver;
  private Server server;
  private Protocol protocol;
  private boolean ispending;
  private ClientProperty clientproperty;
  private boolean forcestop = false;

  /**
   * Constructor for new client
   *
   * @param the underlying server
   */
  public Client( Server server ) {
    protocol = new ServerProtocol(this);
    this.server = server;
    this.socketserver = server.getServerSocket();
    ispending = true;
    this.clientproperty = new ClientProperty();
  }

  /**
   * Method for checking if the socket is still waiting for a client
   *
   * @return a boolean witch holds the pending status of the active client
   *         socket
   */
  public boolean getPendingStatus() {
    return ispending;
  }

  /**
   * Method for checking if the socket is connected
   *
   * @return a boolean witch holds the connection
   */
  public boolean isConnected() {
    if ( getPendingStatus() ) {
      return false;
    } else {
      return socketclient.isConnected();
    }
  }

  /**
   * Method for multithreaded code to execute (implements Runable).
   */
  @Override
  public void run() {
    try {
      socketclient = socketserver.accept();
      ispending = false;
      Log.addItem( "Client verbonden @ " + socketclient.getInetAddress(), "", "", LogType.Event );

      getProtocol().setServer( server );
      getProtocol().bindStreams( socketclient );
      getProtocol().setClientproperty( clientproperty );

      while ( socketclient.isConnected() && forcestop == false) {
        if ( getProtocol().isBusy() == false ) {
          getProtocol().proccesCommand();
        }
      }
      socketclient.close();

    } catch ( Exception ex ) {
      Log.addItem( "IO Exception @ client", ex.getMessage(), "Er is een IO fout opgetreden tijdens het opzetten van de verbinding", LogType.Error );
    }

  }

  /**
   * @return the protocol
   */
  public Protocol getProtocol() {
    return protocol;
  }
  /**
   * Forces the server to stop
   */
  public void forceStop()
  {
    forcestop = true;
  }
  /**
   * Returns if the server is forceclosed
   */
  public boolean isForcedStopped()
  {
    return forcestop;
  }
}

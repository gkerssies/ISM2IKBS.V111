package gfy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UTFDataFormatException;
import java.net.Socket;

/**
 * Protocol base class
 *
 * @author Jormen Janssen
 * @version 0.2 - 8 mei 2012
 */
public abstract class Protocol {

  private ObjectOutputStream objectlineout;
  private ObjectInputStream objectlinein;
  private Socket clientsocket;
  private boolean busy = false;

  public abstract String getProtocol();

  public abstract void processCommand();

  /**
   * Method for receiving a command
   *
   * @return the command as an string
   */
  public String recieveCommand() {
    String t = "CLOSE";
    try {
      t = objectlinein.readUTF();
      System.out.println( "Testing receiveCommand in Protocol.java." );
      return t;
    } catch ( UTFDataFormatException fault ) {
      System.out.println( "Format error in receiveCommand in Protocol.java." );
      return t;
    } catch ( IOException ex ) {
      System.out.println( "Fout tijdens het lezen # " + ex.getMessage() );
      return t;
    }
  }

  /**
   * Method for receiving an object to a client
   *
   * @return The object which is received through a socket.
   */
  public Object recieveObject() {
    try {
      Object t = objectlinein.readObject();
      return t;
    } catch ( IOException ex ) {
      System.out.println( "Fout tijdens het lezen van een object: " + ex.getMessage() );
      return null;
    } catch ( ClassNotFoundException ex ) {
      System.out.println( "Het gestuurde object wordt niet ontvangen." );
      return null;
    }
  }

  public void sendCommand( String text ) {
    try {
      String strings[] = text.split( ">" );
      String command = strings[0];
      objectlineout.writeUTF( command );
      objectlineout.flush();
    } catch ( IOException ex ) {
      System.out.println( "Fout tijdens verzenden." );
    }
  }

  /**
   * Method for sending an object to a client.
   *
   * @param o The object to send.
   */
  public void sendObject( Object o ) {
    try {
      objectlineout.writeObject( o );
    } catch ( IOException ex ) {
    }
  }

  /**
   *
   * @return True.
   */
  public boolean requireCommand() {
    return true;
  }

  /**
   * Method for disconnecting an stream.
   */
  public void unbindStreams() {
    try {
      System.out.println( "Verbinding verbroken." );
      objectlinein.close();
      objectlineout.close();
    } catch ( Exception ex ) {
      System.out.println( "Fout tijdens het verbreken van de verbinding: " + ex.getMessage() );
    }
  }

  /**
   *
   * @param clientsocket
   *
   * @return status the status of the streams if the stream is successfully
   *         connected
   */
  public boolean bindStreams( Socket clientsocket ) {
    boolean bind = true;
    try {
      this.clientsocket = clientsocket;
      objectlineout = new ObjectOutputStream( this.clientsocket.getOutputStream() );
      objectlinein = new ObjectInputStream( this.clientsocket.getInputStream() );
      System.out.println( "Testing bindStreams in Protocol.java." );
    } catch ( IOException ex ) {
      System.out.println( "Fout tijdens het koppelen van de verbinding. " + ex.getMessage() );
      bind = false;
    } catch ( Exception ex ) {
      System.out.println( "Fout tijdens het koppelen van de verbinding. " + ex.getMessage() );
    }
    return bind;
  }

  /**
   * Gets the
   * <code>busy</code> boolean.
   *
   * @return busy
   */
  public boolean isBusy() {
    return busy;
  }

  /**
   * Sets the
   * <code>busy</code> boolean.
   *
   * @param busy
   */
  public void setBusy( boolean busy ) {
    this.busy = busy;
  }
}

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

  public abstract void proccesCommand();

  /**
   * Method for recieving a command
   *
   * @return the command as an string
   */
  public String recieveCommand() {
    String t = "CLOSE";

    try {
      t = objectlinein.readUTF();
      System.out.println( "test5" );

      return t;
    } catch ( UTFDataFormatException fault ) {
      System.out.println( "formaat fout" );

      return t;
    } catch ( IOException ex ) {
      System.out.println( "Fout tijdens het lezen # " + ex.getMessage() );

      return t;
    }
  }

  /**
   * Method for recieving an object to a client
   *
   * @return the object which is recieved through a socket
   */
  public Object recieveObject() {
    try {
      Object t = objectlinein.readObject();

      return t;
    } catch ( IOException ex ) {
      System.out.println( "Fout tijdens het lezen van een object" + ex.getMessage() );

      return null;
    } catch ( ClassNotFoundException ex ) {
      System.out.println( "Het gestuurde object wordt niet ontvangen" );

      return null;
    }
  }

  public void sendCommand( String text ) {
    try {
      String strings[] = text.split( ">" );
      text = strings[0];
      objectlineout.writeUTF( text );
      objectlineout.flush();
    } catch ( IOException ex ) {
      System.out.println( "fout tijdens verzenden" );
    }
  }

  /**
   * Method for sending an object to a client
   *
   * @param o the object to send
   */
  public void sendObject( Object o ) {
    try {
      objectlineout.writeObject( o );
    } catch ( IOException ex ) {
    }
  }

  public boolean reqruireCommand() {
    return true;
  }

  /**
   * Method for disconnecting an stream.
   *
   */
  public void unbindStreams() {
    try {
      System.out.println( "verbinding verbroken" );
      objectlinein.close();
      objectlineout.close();
    } catch ( Exception ex ) {
      System.out.println( "Fout tijdens het verbreken van de verbinding" + ex.getMessage() );
    }
  }

  /**
   *
   * @param clientsocket
   *
   * @return status the status of the streams if the stream is succesfully
   *         connected
   */
  public boolean bindStreams( Socket clientsocket ) {
    boolean bind = true;
    try {
      this.clientsocket = clientsocket;
      objectlineout = new ObjectOutputStream( this.clientsocket.getOutputStream() );
      objectlinein = new ObjectInputStream( this.clientsocket.getInputStream() );
      System.out.println( "test3" );
    } catch ( IOException ex ) {
      System.out.println( "Fout tijdens het koppelen van de verbinding" + ex.getMessage() );
      bind = false;
    } catch ( Exception ex ) {
      System.out.println( "Fout tijdens het koppelen van de verbinding" + ex.getMessage() );
    } finally {
      return bind;
    }
  }

  /**
   * @return the busy
   */
  public boolean isBusy() {
    return busy;
  }

  /**
   * @param busy the busy to set
   */
  public void setBusy( boolean busy ) {
    this.busy = busy;
  }
}

package gfy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Client connection class
 *
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
  private boolean blocking = true;

  /**
   * Constructor for the client connection.
   *
   * @param host the host ip-adress
   * @param port the server port
   */
  public ClientConnection( String host, int port ) {
    this.host = host;
    this.port = port;
  }

  public String recieveCommand() {
    try {
      String[] strings = objectlinein.readUTF().split( ">" );
      String text = strings[0];
      return text;
    } catch ( IOException ex ) {
      return "FAIL";
    }
  }

  public Object recieveObject() {
    try {
      return objectlinein.readObject();
    } catch ( Exception ex ) {
      System.out.println( ex.getMessage() );
      return new Object();
    }
  }

  public ClientProtocol getProtocol() {
    return this.protocol;
  }

  /**
   * Method for sending commands to the server
   *
   * @param text the command to send to the server
   */
  public void sendCommand( String text ) {
    try {
      objectlineout.writeUTF( text + ">" );
      objectlineout.flush();
    } catch ( IOException ex ) {
      Logger.getLogger( ClientConnection.class.getName() ).log( Level.SEVERE, null, ex );
    }
  }

  /**
   * Method for sending objects to the server
   *
   * @param object the object to send
   */
  public void sendObject( Object object ) {
    try {
      objectlineout.writeObject( object );
      objectlineout.flush();
    } catch ( IOException ex ) {
      Logger.getLogger( ClientConnection.class.getName() ).log( Level.SEVERE, null, ex );
    }
  }

  @Override
  public void run() {
    try {
      clientsocket = new Socket( host, port );
      System.out.println( "fase" );

      System.out.println( clientsocket.isConnected() );
      objectlineout = new ObjectOutputStream( clientsocket.getOutputStream() );
      objectlinein = new ObjectInputStream( clientsocket.getInputStream() );

      while ( clientsocket.isConnected() ) {
        if ( isBlocking() == false ) {
          procces( objectlinein.readUTF() );
        } else {
          Thread.sleep( 10 );
        }
      }
    } catch ( IOException ex ) {
      System.out.println( ex.getMessage() );
    } catch ( Exception ex ) {
      System.out.println( "Fout tijdens verbinden" + ex.getCause() );
    }
  }

  /**
   * method for checking is a socket is connected
   *
   * @return the clientsocket connection status
   */
  public boolean isConnected() {
    try {
      return clientsocket.isConnected();
    } catch ( NullPointerException ne ) {
      return false;
    }
  }

  /**
   * @return the clientsocket
   */
  public Socket getClientsocket() {
    return clientsocket;
  }

  /**
   * handles every messages
   *
   * @param text textstring to print
   */
  public void procces( String text ) {
    System.out.println( text );
  }

  /**
   * Method for getting the user object from the server
   *
   * @return the user object
   */
  public User getUser() {
    sendCommand( "GET-USERS" );
    if ( recieveCommand().equals( "OK" ) ) {
      return ( User ) recieveObject();
    } else {
      return new User();
    }
  }

  public void setUser( User user ) {
    sendCommand( "SET-USERS" );
    sendObject( user );
  }

  /**
   * Method for getting the database settings from the server
   *
   * @return the user object
   */
  public Database getDatabase() {
    sendCommand( "GET-DATABASE" );
    if ( recieveCommand().equals( "OK" ) ) {
      return ( Database ) recieveObject();
    } else {
      return new Database( "", "", 0, "", "" );
    }
  }

  public void setDatabase( Database database ) {
    sendCommand( "SET-DATABASE" );
    sendObject( database );
  }

  /**
   * @return the blocking status
   */
  public boolean isBlocking() {
    return blocking;
  }

  /**
   * @param blocking the blocking to set
   */
  public void setBlocking( boolean blocking ) {
    this.blocking = blocking;
  }
}

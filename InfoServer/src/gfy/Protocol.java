package gfy;

import java.io.*;
import java.net.Socket;

/**
 * Protocol base class
 *
 * @author Jormen Janssen
 * @version 0.2 - 8 mei 2012
 */
public abstract class Protocol {

  private ClientProperty clientproperty;
  private ObjectOutputStream objectlineout;
  private ObjectInputStream objectlinein;
  private Socket socket;
  private Server server;
  private boolean busy = false;
  private InputStream is;
  private OutputStream os;

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
      String[] strings = t.split( ">" );
      t = strings[0];
      return t;
    } catch ( Exception ex ) {
      Log.addItem( "Stream fout tijdens ontvangen", ex.getMessage(), "Fout tijdens het lezen van een commando", LogType.Error );
      try {

        unbindStreams();
        Log.addItem( "Connectie verbreken [" + socket.getInetAddress() + "]", ex.getMessage(), "Fout tijdens het lezen van een commando", LogType.Event );
        socket.close();
      } catch ( Exception exx ) {
        Log.addItem( "Fout tijdens ontkoppelen bij IO Fout", exx.getMessage(), "", LogType.Critical );
      }
    }
    return t;
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
      Log.addItem( "Object stream fout", ex.getMessage(), "Er is een fout opgetreden tijdens het lezen van een object", LogType.Error );
      return null;
    } catch ( ClassNotFoundException ex ) {
      Log.addItem( "Object niet gevonden", ex.getMessage(), "Het ontvangen object wordt niet herkend", LogType.Error );
      return null;
    }
  }

  public void sendCommand( String text ) {
    try {

      objectlineout.writeUTF( text + ">" );
      objectlineout.flush();
    } catch ( IOException ex ) {
      Log.addItem( "Error send utf command", ex.getMessage(), "Er is een fout opgetreden tijdens het sturen van een command", LogType.Error );

    }
  }

  /**
   * Method for sending an object to a client
   *
   * @param o the opbject to send to a client
   */
  public void sendObject( Object o ) {
    try {
      objectlineout.writeObject( o );
    } catch ( IOException ex ) {
      Log.addItem( "Stream fout", ex.getMessage(), "Fout tijdens het zenden van een object", LogType.Error );
    }
  }

  /**
   * Method for disconnecting an stream.
   *
   */
  public void unbindStreams() {
    try {
      objectlinein.close();
      objectlineout.close();
      os.close();
      is.close();
      socket.close();
    } catch ( Exception ex ) {
      try {
        if ( socket.isConnected() ) {
          Log.addItem( "Fout tijdens loskoppelen client verbinding", ex.getMessage(), "Fout tijdens verbreken van een stream", LogType.Error );
        }
      } catch ( NullPointerException npe ) {
      }
    }
  }

  /**
   *
   * @param clientSocket
   *
   * @return status the status of the streams if the stream is succesfully
   *         connected
   */
  public boolean bindStreams( Socket clientSocket ) {
    socket = clientSocket;
    boolean bind = true;
    try {
      is = clientSocket.getInputStream();
      os = clientSocket.getOutputStream();
      objectlineout = new ObjectOutputStream( os );
      objectlinein = new ObjectInputStream( is );

    } catch ( IOException ex ) {
      Log.addItem( "Stream fout", ex.getMessage(), "Fout tijdens het koppelen van de verbinding", LogType.Error );
      clientSocket.close();
      bind = false;
    } catch ( Exception ex ) {
      Log.addItem( "Fatale Stream fout", ex.getMessage(), "Fout tijdens het koppelen van de verbinding", LogType.Error );
    } finally {
      return bind;
    }
  }

  /**
   * @return the server
   */
  public Server getServer() {
    return server;
  }

  /**
   * @param server the server to set
   */
  public void setServer( Server server ) {
    this.server = server;
  }

  /**
   * @return the socket
   */
  public Socket getSocket() {
    return socket;
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

  /**
   * @return the clientproperty
   */
  public ClientProperty getClientproperty() {
    return clientproperty;
  }

  /**
   * @param clientproperty the clientproperty to set
   */
  public void setClientproperty( ClientProperty clientproperty ) {
    this.clientproperty = clientproperty;
  }
}

package gfy;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * Server core
 *
 * @author Jormen Janssen
 * @version 0.1 - 29 april 2012
 */
public class Server extends Thread {

  private Config config;
  ArrayList<Client> client;
  ServerSocket serversocket;
  Client currentclient;

  /**
   * Constructor for server
   *
   * @param config for the server
   */
  public Server( Config config ) {
    this.config = config;
    client = new ArrayList<>();
  }

  /**
   * Method for multithreaded code to execute (implements Runable).
   */
  @Override
  public void run() {
    try {
      serversocket = new ServerSocket( getConfig().getServerport() );
      Log.addItem( "Server start", "", "de server wordt gestart", LogType.Event );
      while ( serversocket.isClosed() == false ) {
        try {
          currentclient = new Client( this );
          client.add( currentclient );
          currentclient.start();

          while ( currentclient.getPendingStatus() && serversocket.isClosed() == false ) {
            Thread.sleep( 100 );
          }
        } catch ( Exception ex ) {
          Log.addItem( "Client socket fout", ex.getMessage(), "Er is een fout opgetreden", LogType.Error );
        }
      }


    } catch ( IOException ex ) {
      Log.addItem( "IO Fout", ex.getMessage(), "Er is een fout opgetreden tijdens het starten van de server", LogType.Error );
    }
  }

  /**
   * Method for getting the serversocket
   *
   * @return the serversocket
   */
  public ServerSocket getServerSocket() {
    return this.serversocket;
  }

  public void stopServer() {
    for ( Client myclient : client ) {
      myclient.getProtocol().unbindStreams();
    }

    try {
      serversocket.close();

      // Add 'server stopped' log
      Log.addItem( "Server gestopt", "", "", LogType.Event );
    } catch ( IOException ex ) {
      Log.addItem( "Server gestopt", ex.getMessage(), null, LogType.Info );
    } finally {
      // Write all logs to a file
      try {
        Log.writeToFile();
      } catch ( IOException ex ) {
        Log.addItem( "Fout tijdens opslaan [logbestand]", "", "De logs konden niet worden weggeschreven naar het logbestand.", LogType.Error );
      }
    }
  }

  /**
   * @return the config
   */
  public Config getConfig() {
    return config;
  }

  /**
   * @return the number of connected clients
   */
  public int getCurrentConnectedClientsCount() {
    int i = 0;

    for ( Client myclient : client ) {
      if ( myclient.isConnected() && myclient.isForcedStopped() != true ) {
        i++;
      }
    }

    return i;
  }
}

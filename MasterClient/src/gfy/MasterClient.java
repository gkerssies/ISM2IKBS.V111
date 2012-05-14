package gfy;

import javax.swing.JFrame;

/**
 * De master client.
 *
 * @author thomasbaart
 * @author Gerjan Kerssies
 * @version 0.1 - 26-04-2012
 */
public class MasterClient {

  /**
   * @param args the command line arguments
   */
  public static void main( String[] args ) {
    ClientConnection clientconnection = new ClientConnection( "localhost", 4444 );
    clientconnection.start();
    try {
      Thread.sleep( 1500 );

      if ( clientconnection.isConnected() ) {
        clientconnection.sendCommand( "AUTH>" );
        Auth testauth = new Auth( "admin", "admin", UserType.gebruiker );
        clientconnection.sendObject( testauth );
        System.out.println( clientconnection.recieveCommand() );
      }

      JFrame frame = new HomeScreen( clientconnection );
    } catch ( Exception ex ) {
    }
  }
}

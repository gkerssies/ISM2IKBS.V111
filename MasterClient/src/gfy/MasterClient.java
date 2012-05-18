package gfy;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
      } else {
        JOptionPane.showMessageDialog( new EmptyFrame(), "Er kan geen verbindingen worden gemaakt met de server.", "Verbindings fout", JOptionPane.ERROR_MESSAGE );
        System.exit(0);
      }

      LoginFrame frame = new LoginFrame( clientconnection );
      frame.setVisible( true );
    } catch ( Exception ex ) {
    }
  }
}

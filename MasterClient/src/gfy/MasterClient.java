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
    ClientConnection clientconnection = new ClientConnection("localhost", 4444);
    clientconnection.start();
    try
    {
      Thread.sleep(1500);
    }
    catch(Exception ex)
    {
      
    }
    
    
    JFrame frame = new HomeScreen(clientconnection);
  }
}

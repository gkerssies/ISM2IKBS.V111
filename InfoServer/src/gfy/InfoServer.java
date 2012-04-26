package gfy;

import UserInterface.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Ido Bosman
 */
public class InfoServer extends JFrame {

  /**
   * Constructor for the InfoServer class
   */
  public InfoServer() {
    // Set standard frame settings
    setTitle( "GFY - Server (v0.1)" );
    setLayout( new BorderLayout() );
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    setResizable( false );

    // Create the server status panel
    JPanel statusPanel = new TitledBorderPanel( "Status", new int[] { 5, 5, 0, 5 } );
    statusPanel.add( new StatusPanel() );
    add( statusPanel, BorderLayout.NORTH );

    // Create the log panel
    JPanel logPanel = new TitledBorderPanel( "Logs", new int[] { 5, 5, 5, 4 } );
    logPanel.add( new LogPanel() );
    add( logPanel, BorderLayout.WEST );

    // Create the port panel
    JPanel portPanel = new TitledBorderPanel( "Poort", new int[] { 5, 5, 5, 5 } );
    portPanel.add( new PortPanel() );
    add( portPanel, BorderLayout.EAST );

    // Create the information panel
    JPanel informationPanel = new TitledBorderPanel( "Informatie", new int[] { 0, 5, 5, 5 } );
    informationPanel.add( new InformationPanel() );
    add( informationPanel, BorderLayout.SOUTH );
  }

  /**
   * Run the info server application
   *
   * @param args the command line arguments
   */
  public static void main( String[] args ) {
    InfoServer server = new InfoServer();
    server.pack();
    server.setLocationRelativeTo( server.getRootPane() ); // Center the frame
    server.setVisible( true );
  }
}

package gfy;

import UserInterface.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is the class from where the info server application is built. All
 * components from classes InformationPanel, LogPanel, PortPanel and StatusPanel
 * are loaded into this class and get a posoition in a BorderLayout.
 *
 * @author Ido Bosman (s1047979)
 */
public class InfoServer extends JFrame {

  /**
   * Constructor for the InfoServer class.
   */
  public InfoServer() {
    // Set standard frame settings
    setTitle( "GFY - Server (v0.1)" );
    setLayout( new BorderLayout() );
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    setResizable( false );

    // Create the server status panel
    JPanel northPanel = new TitledBorderPanel( "Status", new int[] { 5, 5, 0, 5 } );
    StatusPanel statusPanel = new StatusPanel();
    northPanel.add( statusPanel );
    add( northPanel, BorderLayout.NORTH );

    // Create the log panel
    JPanel westPanel = new TitledBorderPanel( "Logs", new int[] { 5, 5, 5, 4 } );
    LogPanel logPanel = new LogPanel();
    westPanel.add( logPanel );
    add( westPanel, BorderLayout.WEST );

    // Create the port panel
    JPanel eastPanel = new TitledBorderPanel( "Poort", new int[] { 5, 5, 5, 5 } );
    PortPanel portPanel = new PortPanel();
    eastPanel.add( portPanel );
    add( eastPanel, BorderLayout.EAST );

    // Create the information panel
    JPanel southPanel = new TitledBorderPanel( "Informatie", new int[] { 0, 5, 5, 5 } );
    InformationPanel informationPanel = new InformationPanel();
    southPanel.add( informationPanel );
    add( southPanel, BorderLayout.SOUTH );

    // Create custom ActionListener to process the user actions
    ServerActionListener sal = new ServerActionListener( statusPanel, portPanel );
  }

  /**
   * Method where the server application begins when it is launched.
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

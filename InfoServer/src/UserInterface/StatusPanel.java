package UserInterface;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author Ido Bosman <ido_bosman@hotmail.com>
 */
public class StatusPanel extends JPanel {

  private JLabel statusIcon, serverStatus;
  private JButton startServer, stopServer;

  /**
   * Constructor for the StatusPanel class
   */
  public StatusPanel() {
    // Create BorderLayout to set the label and the buttons below eachother
    JPanel container = new JPanel( new BorderLayout() );

    // Create panel for the status image and text
    JPanel statusPanel = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
    statusPanel.setPreferredSize( new Dimension( 200, 20 ) );

    // Try to load the server status icon
    try {
      BufferedImage image = ImageIO.read( new File( "./resources/images/status-red.png" ) );
      statusIcon = new JLabel( new ImageIcon( image ) );
      statusPanel.add( statusIcon );
    } catch ( Exception e ) {
    }

    // Create label with the server status information
    serverStatus = new JLabel( "De server staat momenteel uit." );
    serverStatus.setFont( null );
    statusPanel.add( serverStatus );

    // Add the status panel to the top of the container
    container.add( statusPanel, BorderLayout.NORTH );

    // Create panel for buttons to change the server state
    JPanel btnPanel = new JPanel( new FlowLayout( FlowLayout.LEFT ) );

    // Create button to start the server
    startServer = new JButton( "Start" );
    startServer.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
    btnPanel.add( startServer );

    // Create button to stop the server
    stopServer = new JButton( "Stop" );
    stopServer.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
    btnPanel.add( stopServer );

    // Add buttons panel to the bottom of the container
    container.add( btnPanel, BorderLayout.SOUTH );

    // Add container to the StatusPanel
    add( container );
  }
}

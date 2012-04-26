package UserInterface;

import java.awt.*;
import javax.swing.*;

/**
 * The server status information is shown here and the server state can be
 * changed in this panel. The server status will be shown as a red or green
 * image icon and there is a plain text status description. There is a "start"
 * button and a "stop" button to change the state of the server.
 *
 * @author Ido Bosman (s1047979)
 */
public class StatusPanel extends JPanel {

  private JLabel statusImage, serverStatus;
  private JButton startServer, stopServer;
  protected static final ImageIcon ICON_SERVER_STOPPED = new ImageIcon( "./resources/images/status-red.png" );
  protected static final ImageIcon ICON_SERVER_STARTED = new ImageIcon( "./resources/images/status-green.png" );
  protected static final String TEXT_SERVER_STOPPED = "De server staat uit.";
  protected static final String TEXT_SERVER_STARTED = "De server staat aan.";

  /**
   * Constructor for the StatusPanel class.
   */
  public StatusPanel() {
    // Create BorderLayout to set the label and the buttons below eachother
    JPanel container = new JPanel( new BorderLayout() );

    // Create panel for the status image and text
    JPanel statusPanel = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
    statusPanel.setPreferredSize( new Dimension( 200, 20 ) );

    // Try to load the server status icon
    try {
      statusImage = new JLabel( StatusPanel.ICON_SERVER_STOPPED );
      statusPanel.add( statusImage );
    } catch ( Exception e ) {
    }

    // Create label with the server status information
    serverStatus = new JLabel( StatusPanel.TEXT_SERVER_STOPPED );
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

  /**
   *
   * @return the label which contains the status of the server as a string
   */
  public JLabel getServerStatus() {
    return serverStatus;
  }

  /**
   *
   * @return the button which starts the server
   */
  public JButton getStartServer() {
    return startServer;
  }

  /**
   *
   * @return the button which stops the server
   */
  public JButton getStopServer() {
    return stopServer;
  }

  /**
   * 
   * @return the red or green image icon which shows de server status
   */
  public JLabel getStatusImage() {
    return statusImage;
  }
}

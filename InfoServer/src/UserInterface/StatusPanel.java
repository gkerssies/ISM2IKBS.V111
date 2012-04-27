package UserInterface;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The server status information is shown here and the server state can be
 * changed in this panel. The server status will be shown as a red or green
 * image icon and there is a plain text status description. There is a "start"
 * button and a "stop" button to change the state of the server.
 *
 * @author Ido Bosman (s1047979)
 */
public class StatusPanel extends JPanel {

  private JLabel statusIconLabel, statusTextLabel;
  private JButton startButton, stopButton;
  protected static final ImageIcon SERVER_STOPPED_ICON = new ImageIcon( "./resources/images/status-red.png" );
  protected static final ImageIcon SERVER_STARTED_ICON = new ImageIcon( "./resources/images/status-green.png" );
  protected static final String SERVER_STOPPED_TEXT = "De server staat uit.";
  protected static final String SERVER_STARTED_TEXT = "De server staat aan.";

  /**
   * Constructor for the StatusPanel class.
   */
  public StatusPanel() {
    // Create BorderLayout to set the label and the buttons below eachother
    JPanel containerPanel = new JPanel( new BorderLayout() );

    // Create panel for the status image and text
    JPanel statusPanel = new JPanel( new FlowLayout( FlowLayout.LEFT ) );
    statusPanel.setPreferredSize( new Dimension( 200, 20 ) );

    // Load the image icon that shows the server status
    statusIconLabel = new JLabel( StatusPanel.SERVER_STOPPED_ICON );
    statusPanel.add( statusIconLabel );

    // Create label with the server status information
    statusTextLabel = new JLabel( StatusPanel.SERVER_STOPPED_TEXT );
    statusTextLabel.setFont( null );
    statusPanel.add( statusTextLabel );

    // Add the status panel to the top of the container
    containerPanel.add( statusPanel, BorderLayout.NORTH );

    // Create panel for buttons to change the server state
    JPanel buttonPanel = new JPanel( new FlowLayout( FlowLayout.LEFT ) );

    // Create button to start the server
    startButton = new JButton( "Start" );
    startButton.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
    buttonPanel.add( startButton );

    // Create button to stop the server
    stopButton = new JButton( "Stop" );
    stopButton.setEnabled( false );
    stopButton.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
    buttonPanel.add( stopButton );

    // Add buttons panel to the bottom of the container
    containerPanel.add( buttonPanel, BorderLayout.SOUTH );

    // Add container to the StatusPanel
    add( containerPanel );
  }

  /**
   *
   * @return the red or green image icon which shows de server status
   */
  public JLabel getStatusIconLabel() {
    return statusIconLabel;
  }

  /**
   *
   * @return the label which contains the status of the server as a string
   */
  public JLabel getStatusTextLabel() {
    return statusTextLabel;
  }

  /**
   *
   * @return the button which starts the server
   */
  public JButton getStartButton() {
    return startButton;
  }

  /**
   *
   * @return the button which stops the server
   */
  public JButton getStopButton() {
    return stopButton;
  }
}

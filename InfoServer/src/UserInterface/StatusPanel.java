package UserInterface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
    setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );

    // Create a new panel for the server status text
    JPanel statusPanel = new JPanel( new FlowLayout( FlowLayout.LEFT, 0, 0 ) );

    // Load the image icon that shows the server status
    statusIconLabel = new JLabel( StatusPanel.SERVER_STOPPED_ICON );
    statusIconLabel.setBorder( new EmptyBorder( 0, 0, 0, 5 ) );
    statusPanel.add( statusIconLabel );

    // Create label with the server status information
    statusTextLabel = new JLabel( StatusPanel.SERVER_STOPPED_TEXT );
    statusTextLabel.setPreferredSize( new Dimension( 110, 25 ) );
    statusTextLabel.setFont( null );
    statusPanel.add( statusTextLabel );

    // Add the statusPanel to StatusPanel
    add( statusPanel );

    // Create a new panel for the start and stop buttons
    JPanel buttonPanel = new JPanel( new FlowLayout( FlowLayout.LEFT, 0, 1 ) );

    // Create button to start the server
    startButton = new CustomButton( "Start" );
    buttonPanel.add( startButton );

    // Create space between the start and the stop button
    buttonPanel.add( Box.createHorizontalStrut( 7 ) );

    // Create button to stop the server
    stopButton = new CustomButton( "Stop", false );
    buttonPanel.add( stopButton );

    // Add the buttonPanel to StatusPanel
    add( buttonPanel );
  }

  /**
   * Get the label which contains the server status icon.
   *
   * @return the red or green image icon which shows de server status
   */
  public JLabel getStatusIconLabel() {
    return statusIconLabel;
  }

  /**
   * Get the label which contains the server status text.
   *
   * @return the label which contains the status of the server as a string
   */
  public JLabel getStatusTextLabel() {
    return statusTextLabel;
  }

  /**
   * Get the button which starts the server when clicked.
   *
   * @return the button which starts the server
   */
  public JButton getStartButton() {
    return startButton;
  }

  /**
   * Get the button which stops the server when clicked.
   *
   * @return the button which stops the server
   */
  public JButton getStopButton() {
    return stopButton;
  }
}
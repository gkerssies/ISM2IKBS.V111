package UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Handles all the user actions on the info server application. Actions like
 * starting and stopping the server, configuring the portnumber and inspecting
 * the logs are processed here.
 *
 * @author Ido Bosman (s1047979)
 */
public class ServerActionListener implements ActionListener {

  private JLabel statusIconLabel, statusTextLabel;
  private JButton startButton, stopButton;
  private JTextField portTextField;

  /**
   * Constructor for the ServerActionListener class.
   *
   * @param statusPanel the panel to manage the server status
   * @param portPanel   the panel to set the portnumber
   */
  public ServerActionListener( StatusPanel statusPanel, PortPanel portPanel ) {
    startButton = statusPanel.getStartButton();
    startButton.addActionListener( this );

    stopButton = statusPanel.getStopButton();
    stopButton.addActionListener( this );

    statusIconLabel = statusPanel.getStatusIconLabel();
    statusTextLabel = statusPanel.getStatusTextLabel();

    portTextField = portPanel.getPortTextField();
  }

  @Override
  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == startButton ) {
      startButton.setEnabled( false );
      stopButton.setEnabled( true );

      statusIconLabel.setIcon( StatusPanel.SERVER_STARTED_ICON );
      statusTextLabel.setText( StatusPanel.SERVER_STARTED_TEXT );

      portTextField.setEnabled( false );
    } else if ( e.getSource() == stopButton ) {
      startButton.setEnabled( true );
      stopButton.setEnabled( false );

      statusIconLabel.setIcon( StatusPanel.SERVER_STOPPED_ICON );
      statusTextLabel.setText( StatusPanel.SERVER_STOPPED_TEXT );

      portTextField.setEnabled( true );
    }
  }
}
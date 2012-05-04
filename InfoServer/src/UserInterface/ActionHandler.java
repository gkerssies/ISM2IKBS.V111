package UserInterface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
public class ActionHandler implements ActionListener, KeyListener {

  private JLabel statusIconLabel, statusTextLabel;
  private JButton startButton, stopButton;
  private JTextField portTextField;
  private static final Color ERROR_RED = new Color( 255, 240, 240 );

  /**
   * Constructor for the ActionHandler class.
   *
   * @param statusPanel the panel to manage the server status
   * @param portPanel   the panel to set the portnumber
   */
  public ActionHandler( StatusPanel statusPanel, PortPanel portPanel ) {
    startButton = statusPanel.getStartButton();
    startButton.addActionListener( this );

    stopButton = statusPanel.getStopButton();
    stopButton.addActionListener( this );

    statusIconLabel = statusPanel.getStatusIconLabel();
    statusTextLabel = statusPanel.getStatusTextLabel();

    portTextField = portPanel.getPortTextField();
    portTextField.addKeyListener( this );
  }

  @Override
  public void actionPerformed( ActionEvent ae ) {
    if ( ae.getSource() == startButton ) {
      startButton.setEnabled( false );
      stopButton.setEnabled( true );

      statusIconLabel.setIcon( StatusPanel.SERVER_STARTED_ICON );
      statusTextLabel.setText( StatusPanel.SERVER_STARTED_TEXT );

      portTextField.setEnabled( false );
    } else if ( ae.getSource() == stopButton ) {
      startButton.setEnabled( true );
      stopButton.setEnabled( false );

      statusIconLabel.setIcon( StatusPanel.SERVER_STOPPED_ICON );
      statusTextLabel.setText( StatusPanel.SERVER_STOPPED_TEXT );

      portTextField.setEnabled( true );
    }
  }

  @Override
  public void keyTyped( KeyEvent ke ) {
  }

  @Override
  public void keyPressed( KeyEvent ke ) {
  }

  @Override
  public void keyReleased( KeyEvent ke ) {
    try {
      // Try to cast the input String from portTextfield to an integer
      int portNumber = Integer.parseInt( portTextField.getText() );

      // Check if the portNumber is inside a specific range
      if ( portNumber > 1024 && portNumber < 49151 ) {
        startButton.setEnabled( true );
        portTextField.setBackground( Color.WHITE );
      } else {
        startButton.setEnabled( false );
        portTextField.setBackground( ERROR_RED );
      }
    } catch ( Exception ex ) {
      startButton.setEnabled( false );
      portTextField.setBackground( ERROR_RED );
    }
  }
}

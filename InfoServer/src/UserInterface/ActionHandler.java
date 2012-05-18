package UserInterface;

import gfy.IOUtililty;
import gfy.Server;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

/**
 * Handles all the user actions on the info server application. Actions like
 * starting and stopping the server, configuring the portnumber and inspecting
 * the logs are processed here.
 *
 * @author Ido Bosman (s1047979)
 */
public class ActionHandler implements ActionListener, KeyListener {

  private JFrame frame;
  private Server server;
  private InformationPanel informationPanel;
  private Timer timer;
  private JLabel statusIconLabel, statusTextLabel;
  private JButton startButton, stopButton, logButton;
  private JTextField portTextField;
  private static final Color ERROR_RED = new Color( 255, 240, 240 );

  /**
   * Constructor for the ActionHandler class.
   *
   * @param frame            the server application frame
   * @param server           the application core
   * @param statusPanel      the panel to manage the server status
   * @param logPanel         the panel with the button that opens the log dialog
   * @param portPanel        the panel to set the portnumber
   * @param informationPanel the panel with the number of the connected clients
   */
  public ActionHandler( JFrame frame, Server server, StatusPanel statusPanel, LogPanel logPanel, PortPanel portPanel, InformationPanel informationPanel ) {
    this.frame = frame;
    this.server = server;
    this.informationPanel = informationPanel;

    // Create a new timer to refresh every .. seconds so the number of connected clients is shown realtime
    timer = new Timer( 1000, this );

    startButton = statusPanel.getStartButton();
    startButton.addActionListener( this );

    stopButton = statusPanel.getStopButton();
    stopButton.addActionListener( this );

    statusIconLabel = statusPanel.getStatusIconLabel();
    statusTextLabel = statusPanel.getStatusTextLabel();

    logButton = logPanel.getLogButton();
    logButton.addActionListener( this );

    portTextField = portPanel.getPortTextField();
    portTextField.addKeyListener( this );
  }

  @Override
  public void actionPerformed( ActionEvent ae ) {
    if ( ae.getSource() == timer ) {
      // Update the number of connected clients every .. seconds
      informationPanel.setConnectedClients( server.getCurrentConnectedClientsCount() );
    } else if ( ae.getSource() == startButton ) {
      // Set frame not stoppable when clicking on the exit button in the frame
      frame.setDefaultCloseOperation( WindowConstants.DO_NOTHING_ON_CLOSE );

      // Convert filled in portnumber (string) to usable portnumber (int)
      // try-catch not necessary because only int characters are allowed in portTextField
      int port = Integer.parseInt( portTextField.getText() );
      if ( port != server.getConfig().getServerport() ) {
        // Change serverport
        server.getConfig().setServerport( port );

        // Save portnumber to the port-configuration file
        IOUtililty.writePortConfig( port );
      }

      // Start the application core (the server)
      server.start();

      // Start the timer to refresh the number of connected clients
      timer.start();

      startButton.setEnabled( false );
      stopButton.setEnabled( true );

      statusIconLabel.setIcon( StatusPanel.SERVER_STARTED_ICON );
      statusTextLabel.setText( StatusPanel.SERVER_STARTED_TEXT );

      portTextField.setEnabled( false );
      portTextField.setToolTipText( null );
    } else if ( ae.getSource() == stopButton ) {
      // Create dialog that forces user confirmation before stopping the server
      int allowToStopServer = JOptionPane.showConfirmDialog(
              frame,
              "Weet u zeker dat u de server wilt stoppen en afsluiten?",
              "U staat op het punt de server te stoppen",
              JOptionPane.YES_NO_OPTION,
              JOptionPane.WARNING_MESSAGE );

      // If the 'Yes' button is clicked in the confirm dialog the server will be stopped
      if ( allowToStopServer == 0 ) {
        // Stop the application core (the server)
        server.stopServer();

        // Stop the timer to refresh the number of connected clients
        timer.stop();

        // Exit the info server application
        System.exit( 0 );

        startButton.setEnabled( true );
        stopButton.setEnabled( false );

        statusIconLabel.setIcon( StatusPanel.SERVER_STOPPED_ICON );
        statusTextLabel.setText( StatusPanel.SERVER_STOPPED_TEXT );

        portTextField.setEnabled( true );
        portTextField.setToolTipText( PortPanel.PORTTEXTFIELD_TOOLTIP );
      }
    } else if ( ae.getSource() == logButton ) {
      // Create dialog that contains the log information
      LogDialog logDialog = new LogDialog( frame );
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
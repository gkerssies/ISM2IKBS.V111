package UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Handles all the user actions on the info server application. Actions like
 * starting and stopping the server, configuring the portnumber and inspecting
 * the logs are processed here.
 *
 * @author Ido Bosman (s1047979)
 */
public class ServerActionListener implements ActionListener {

  private StatusPanel statusPanel;
  private PortPanel portPanel;
  private JLabel statusImage, serverStatus;
  private JButton startServer, stopServer;
  private JTextField port;

  /**
   *
   * @param statusPanel the panel to manage the server status
   * @param portPanel   the panel to set the portnumber
   */
  public ServerActionListener( StatusPanel statusPanel, PortPanel portPanel ) {
    this.statusPanel = statusPanel;
    this.portPanel = portPanel;

    startServer = statusPanel.getStartServer();
    startServer.addActionListener( this );

    stopServer = statusPanel.getStopServer();
    stopServer.addActionListener( this );

    statusImage = statusPanel.getStatusImage();
    serverStatus = statusPanel.getServerStatus();

    port = portPanel.getPort();
  }

  @Override
  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == startServer ) {
      startServer.setEnabled( false );
      stopServer.setEnabled( true );
      statusImage.setIcon( StatusPanel.ICON_SERVER_STARTED );
      serverStatus.setText( StatusPanel.TEXT_SERVER_STARTED );
      port.setEnabled( false );
    } else if ( e.getSource() == stopServer ) {
      startServer.setEnabled( true );
      stopServer.setEnabled( false );
      statusPanel.repaint();
      statusImage.setIcon( StatusPanel.ICON_SERVER_STOPPED );
      serverStatus.setText( StatusPanel.TEXT_SERVER_STOPPED );
      port.setEnabled( true );
    }
  }
}

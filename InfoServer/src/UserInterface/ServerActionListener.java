package UserInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Ido Bosman
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
      statusImage.setIcon( new ImageIcon( "./resources/images/status-green.png" ) );
      serverStatus.setText( "De server is gestart." );
      port.setEnabled( false );
    } else if ( e.getSource() == stopServer ) {
      startServer.setEnabled( true );
      stopServer.setEnabled( false );
      statusPanel.repaint();
      statusImage.setIcon( new ImageIcon( "./resources/images/status-red.png" ) );
      serverStatus.setText( "De server is gestopt." );
      port.setEnabled( true );
    }
  }
}

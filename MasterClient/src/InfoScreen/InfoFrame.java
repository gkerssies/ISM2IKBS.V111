package InfoScreen;

import gfy.ClientConnection;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Janssen-laptop
 */
public class InfoFrame extends JFrame {
  
  private ClientConnection clientConnection;
  
  public InfoFrame(ClientConnection clientConnection) {
    this.clientConnection = clientConnection;
    setLayout(new BorderLayout());
    setVisible(true);
    add(new ResourcesPanel(clientConnection),BorderLayout.NORTH);
    this.pack();
  }
}

package UserInterface;

import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author Ido Bosman (s1047979)
 */
public class PortPanel extends JPanel {

  private JTextField port;

  /**
   * Constructor for the PortPanel class
   */
  public PortPanel() {
    // Create textfield where the user fills in the portnumber
    port = new JTextField();
    port.setPreferredSize( new Dimension( 60, 26 ) );
    add( port );
  }

  /**
   * 
   * @return the textfield which contains the portnumber
   */
  public JTextField getPort() {
    return port;
  }
}

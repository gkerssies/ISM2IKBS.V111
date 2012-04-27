package UserInterface;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Creates the textfield to configure the portnumber. This portnumber will be
 * used by clients to connect with the server.
 *
 * @author Ido Bosman (s1047979)
 */
public class PortPanel extends JPanel {

  private JTextField portTextField;

  /**
   * Constructor for the PortPanel class.
   */
  public PortPanel() {
    // Create textfield where the user fills in the portnumber
    portTextField = new JTextField();
    portTextField.setPreferredSize( new Dimension( 60, 26 ) );
    add( portTextField );
  }

  /**
   *
   * @return the textfield which contains the portnumber
   */
  public JTextField getPortTextField() {
    return portTextField;
  }
}

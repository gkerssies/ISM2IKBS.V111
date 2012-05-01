package UserInterface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.*;

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
    setLayout( new FlowLayout( FlowLayout.LEFT, 0, 0 ) );

    // Create textfield where the user fills in the portnumber
    portTextField = new JTextField();
    portTextField.setPreferredSize( new Dimension( 50, 24 ) );
    portTextField.setBorder(
            new CompoundBorder(
            new BevelBorder( BevelBorder.LOWERED ),
            new EmptyBorder( 3, 3, 3, 3 ) ) );
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
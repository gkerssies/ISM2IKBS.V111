package UserInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

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
    portTextField.setPreferredSize( new Dimension( 50, 22 ) );
    portTextField.setBorder(
            new CompoundBorder(
            new EtchedBorder( EtchedBorder.LOWERED, new Color( 238, 238, 238 ), Color.WHITE ),
            new LineBorder( new Color( 110, 0, 0, 0 ), 3 ) ) );
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
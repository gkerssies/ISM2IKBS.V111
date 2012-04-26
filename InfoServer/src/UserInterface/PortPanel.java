package UserInterface;

import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author Ido Bosman <ido_bosman@hotmail.com>
 */
public class PortPanel extends JPanel {

  private JTextField textfield;

  /**
   * Constructor for the PortPanel class
   */
  public PortPanel() {
    // Create textfield where the user fills in the portnumber
    textfield = new JTextField();
    textfield.setPreferredSize( new Dimension( 60, 26 ) );
    add( textfield );
  }
}

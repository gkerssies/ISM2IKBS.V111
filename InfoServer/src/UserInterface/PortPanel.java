package UserInterface;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * Creates the textfield to configure the portnumber. This portnumber will be
 * used by clients to connect with the server.
 *
 * @author Ido Bosman (s1047979)
 */
public class PortPanel extends JPanel {

  private JTextField portTextField;
  protected static final String PORTTEXTFIELD_TOOLTIP = "Vul een poortnummer in tussen de 1024 en 49150.";

  /**
   * Constructor for the PortPanel class.
   *
   * @param portNumber the default portnumber that is set
   */
  public PortPanel( int portNumber ) {
    setLayout( new FlowLayout( FlowLayout.LEFT, 0, 0 ) );

    // Create textfield where the user fills in the portnumber
    portTextField = new JTextField( portNumber + "" );
    portTextField.setPreferredSize( new Dimension( 50, 24 ) );
    portTextField.setToolTipText( PortPanel.PORTTEXTFIELD_TOOLTIP );
    portTextField.setBorder(
            new CompoundBorder(
            new BevelBorder( BevelBorder.LOWERED ),
            new EmptyBorder( 3, 3, 3, 3 ) ) );
    add( portTextField );
  }

  /**
   * Get the comlete textfield the user can set the portnumber.
   *
   * @return the textfield which contains the portnumber
   */
  public JTextField getPortTextField() {
    return portTextField;
  }
}
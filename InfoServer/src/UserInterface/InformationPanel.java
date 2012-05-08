package UserInterface;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Creates all information components. The number of connected clients will be
 * shown here.
 *
 * @author Ido Bosman (s1047979)
 */
public class InformationPanel extends JPanel {

  private JLabel connectedClientsLabel;

  /**
   * Constructor for the InformationPanel class.
   */
  public InformationPanel() {
    setLayout( new FlowLayout( FlowLayout.LEFT, 0, 0 ) );

    // Create label with information about the number of connected clients
    connectedClientsLabel = new JLabel( "Aantal verbonden clients: 23" );
    connectedClientsLabel.setFont( null );
    add( connectedClientsLabel );
  }
}
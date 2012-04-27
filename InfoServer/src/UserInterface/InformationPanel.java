package UserInterface;

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
    // Create label with information about the number of connected clients
    connectedClientsLabel = new JLabel( "Aantal verbonden clients: 23" );
    connectedClientsLabel.setHorizontalTextPosition( JLabel.CENTER );
    connectedClientsLabel.setFont( null );
    add( connectedClientsLabel );
  }
}

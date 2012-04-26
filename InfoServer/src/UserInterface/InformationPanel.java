package UserInterface;

import javax.swing.*;

/**
 * Creates all information components. The number of connected clients will be
 * shown here.
 *
 * @author Ido Bosman (s1047979)
 */
public class InformationPanel extends JPanel {

  private JLabel connectedClients;

  /**
   * Constructor for the InformationPanel class.
   */
  public InformationPanel() {
    // Create label with information about the number of connected clients
    connectedClients = new JLabel( "Aantal verbonden clients: 23" );
    connectedClients.setHorizontalTextPosition( JLabel.CENTER );
    connectedClients.setFont( null );
    add( connectedClients );
  }
}

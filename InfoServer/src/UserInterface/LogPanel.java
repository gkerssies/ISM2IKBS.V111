package UserInterface;

import java.awt.Cursor;
import javax.swing.*;

/**
 *
 * @author Ido Bosman <ido_bosman@hotmail.com>
 */
public class LogPanel extends JPanel {

  private JButton button;

  /**
   * Constructor for the LogPanel class
   */
  public LogPanel() {
    // Create button that opens a dialog with the logs when clicking on it
    button = new JButton( "Logs inzien" );
    button.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
    add( button );
  }
}

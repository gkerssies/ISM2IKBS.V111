package UserInterface;

import java.awt.Cursor;
import javax.swing.*;

/**
 * Creates a button that opens a dialog when clicked. There will be a
 * list of logs shown in this dialog. The logs are loaded from a logfile.
 *
 * @author Ido Bosman (s1047979)
 */
public class LogPanel extends JPanel {

  private JButton button;

  /**
   * Constructor for the LogPanel class.
   */
  public LogPanel() {
    // Create button that opens a dialog with the logs when clicking on it
    button = new JButton( "Logs inzien" );
    button.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
    add( button );
  }
}

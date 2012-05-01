package UserInterface;

import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Creates a button that opens a dialog when clicked. There will be a list of
 * logs shown in this dialog. The logs are loaded from a logfile.
 *
 * @author Ido Bosman (s1047979)
 */
public class LogPanel extends JPanel {

  private JButton logButton;

  /**
   * Constructor for the LogPanel class.
   */
  public LogPanel() {
    setLayout( new FlowLayout( FlowLayout.LEFT, 0, 0 ) );

    // Create button that opens a dialog with the logs when clicking on it
    logButton = new JButton( "Logs inzien" );
    logButton.setMargin( new Insets( 0, 5, 0, 5 ) );
    logButton.setFocusPainted( false );
    logButton.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
    add( logButton );
  }
}
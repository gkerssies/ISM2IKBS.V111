package UserInterface;

import java.awt.FlowLayout;
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
    logButton = new CustomButton( "Logs inzien" );
    add( logButton );
  }

  /**
   * Get the complete button which opens a dialog with logs when clicked.
   *
   * @return the button which opens a dialog with logs when you click on it
   */
  public JButton getLogButton() {
    return logButton;
  }
}
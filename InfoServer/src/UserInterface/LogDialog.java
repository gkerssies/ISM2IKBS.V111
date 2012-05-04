package UserInterface;

import java.awt.FlowLayout;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Creates a dialog which contains the logged data from the server and clients.
 * The logs are loaded from a logfile stored on the server where the info server
 * application runs on.
 *
 * @author Ido Bosman (s1047979)
 */
public class LogDialog extends JDialog {

  /**
   * Constructor for the LogDialog class.
   *
   * @param frame the server application frame
   */
  public LogDialog( JFrame frame ) {
    super( frame, true );

    setTitle( "Logs" );
    setLayout( new FlowLayout() );
    setSize( 400, 400 );
    setResizable( false );
    setLocationRelativeTo( frame );
    setVisible( true );
  }
}

package UserInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Creates a dialog which contains the logged data from the server and clients.
 * The logs are loaded from a logfile stored on the server where the info server
 * application runs on.
 *
 * @author Ido Bosman (s1047979)
 */
public class LogDialog extends JDialog {

  private JScrollPane scrollPane;

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

    // Create scrollpane and add label with log information to the scrollpane
    scrollPane = new JScrollPane( logLabel( "Log informatie hier includen!" ) );
    scrollPane.setPreferredSize( new Dimension( 390, 364 ) );
    scrollPane.setBorder( new EmptyBorder( 0, 0, 0, 0 ) );
    add( scrollPane );

    // Make the log dialog visible
    setVisible( true );
  }

  /**
   *
   * @param text the log information
   *
   * @return wrapped label that contains the log information
   */
  public WrappableJLabel logLabel( String text ) {
    WrappableJLabel label = new WrappableJLabel( "<html>" + text + "</html>", 370 );
    label.setBorder( new EmptyBorder( -3, 2, 0, 0 ) );
    label.setFont( new Font( Font.MONOSPACED, Font.PLAIN, 11 ) );
    label.setBackground( Color.YELLOW );
    label.setVerticalAlignment( SwingConstants.NORTH );

    return label;
  }
}
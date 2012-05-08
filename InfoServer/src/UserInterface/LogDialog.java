package UserInterface;

import gfy.Log;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Creates a dialog which contains the logged data from the server and clients.
 * The logs are loaded from a logfile stored on the server where the info server
 * application runs on.
 *
 * @author Ido Bosman (s1047979)
 */
public class LogDialog extends JDialog implements ActionListener {

  private WrappableJLabel label;
  private Timer timer;

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

    // Create a new timer to refresh every .. seconds so the number of connected clients is shown realtime
    timer = new Timer( 400, this );
    timer.start();

    // Create the label for the log information
    label = new WrappableJLabel( 370 );
    label.setBorder( new EmptyBorder( -3, 2, 0, 0 ) );
    label.setFont( new Font( Font.MONOSPACED, Font.PLAIN, 11 ) );
    label.setBackground( Color.YELLOW );
    label.setVerticalAlignment( SwingConstants.NORTH );

    // Create scrollpane and add label with log information to the scrollpane
    JScrollPane scrollPane = new JScrollPane( label );
    scrollPane.setPreferredSize( new Dimension( 390, 364 ) );
    scrollPane.setBorder( new EmptyBorder( 0, 0, 0, 0 ) );
    add( scrollPane );

    // Make the log dialog visible
    setVisible( true );
  }

  @Override
  public void actionPerformed( ActionEvent ae ) {
    // If timer is started, run this code everty .. seconds
    if ( ae.getSource() == timer ) {
      // Set all log information into a String typed variable
      String logText = new Log().toString();

      // Set standard text if there aren't any logs available
      if ( !logText.equals( "" ) ) {
        label.setText( "<html>" + logText + "</html>" );
      } else {
        label.setText( "<html>Er is (nog) geen log informatie beschikbaar.</html>" );
      }
    }
  }
}
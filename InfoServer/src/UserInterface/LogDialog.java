package UserInterface;

import gfy.Log;
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
  private JScrollPane scrollPane;
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
    setSize( 600, 400 );
    setResizable( false );
    setLocationRelativeTo( frame );

    // Create a new timer to refresh every .. seconds so the number of connected clients is shown realtime
    timer = new Timer( 250, this );
    timer.start();

    // Create the label for the log information
    createLabel();

    // Create scrollpane and add label with log information to the scrollpane
    createScrollPane();

    // Make the log dialog visible
    setVisible( true );
  }

  /**
   * Create custom label that will contain the log information.
   */
  private void createLabel() {
    label = new WrappableJLabel( 570 );
    label.setBorder( new EmptyBorder( -3, 2, 0, 0 ) );
    label.setFont( new Font( Font.MONOSPACED, Font.PLAIN, 11 ) );
    label.setVerticalAlignment( SwingConstants.NORTH );
  }

  /**
   * Create the scrollpane that contain the custom label and adds a vertical
   * scrollbar to the left of the dialog.
   */
  private void createScrollPane() {
    scrollPane = new JScrollPane( label, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
    scrollPane.setPreferredSize( new Dimension( 590, 364 ) );
    scrollPane.setBorder( new EmptyBorder( 0, 0, 0, 0 ) );
    scrollPane.getVerticalScrollBar().addMouseListener(new StopScrollingHandler(timer) );
    add( scrollPane );
  }

  /**
   * Set the scrollbar from the log dialog automatically to the bottom.
   */
  private void setScrollBarToBottom() {
    scrollPane.getVerticalScrollBar().setValue(
            scrollPane.getVerticalScrollBar().getMaximum()
            + scrollPane.getVerticalScrollBar().getVisibleAmount() );
  }

  /**
   * Set the label text including html tags. The html tags are needed to wrap
   * the text when it's to long to fit in the dialogscreen.
   *
   * @param text the log information
   */
  public void setLabel( String text ) {
    label.setText( "<html>" + text + "</html>" );
  }

  @Override
  public void actionPerformed( ActionEvent ae ) {
    // If timer is started, run this code everty .. seconds
    if ( ae.getSource() == timer ) {
      // Set all log information into a String typed variable
      String logText = new Log().toString();

      // Set standard text if there aren't any logs available
      if ( !logText.equals( "" ) ) {
        setLabel( logText );
      } else {
        setLabel( "Er is (nog) geen log informatie beschikbaar." );
      }

      // Scroll automatically to the bottom of the logs
      setScrollBarToBottom();
    }
  }
}

package gfy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener class for the Info Client.
 *
 * @author thomasbaart
 */
public class InlogListener implements ActionListener {

  private InlogFrame frame;

  /**
   * Default constructor.
   */
  public InlogListener() {
  }

  /**
   * Constructor. Sets the frame to listen for actions on. This ActionListener
   * only supports an InlogFrame.
   *
   * @param frame The frame to listen on.
   */
  public InlogListener( InlogFrame frame ) {
    this.frame = frame;
  }

  @Override
  public void actionPerformed( ActionEvent ae ) {
    if ( ae.getSource() == frame.getCancelButton() ) {
      System.exit( 0 );
      System.out.println( "Hoi" );
    }
  }
}

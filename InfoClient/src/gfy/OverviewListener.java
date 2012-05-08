package gfy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionListener for the overviewFrame.
 *
 * @author thomasbaart
 */
public class OverviewListener implements ActionListener {

  private OverviewPanel panel;

  /**
   * Default constructor.
   */
  public OverviewListener() {
  }

  /**
   * Constructor.
   *
   * @param panel The panel to listen on.
   */
  public OverviewListener( OverviewPanel panel ) {
    this.panel = panel;
  }

  @Override
  public void actionPerformed( ActionEvent ae ) {
    if ( ae.getSource() == panel.getButton() ) {
      System.out.println( "(button) " + panel.getButton().hashCode() + " was pushed!" );
    }
  }
}

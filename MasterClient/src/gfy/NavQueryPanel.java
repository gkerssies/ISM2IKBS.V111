package gfy;

import javax.swing.*;

/**
 * Creates a panel for a NavQuery. Contains title, description and query for the
 * NavQuery and buttons for editing and deleting the NavQuery.
 *
 * @author Gerjan Kerssies
 */
public class NavQueryPanel extends JPanel {

  private NavQuery navQuery;
  private JFrame frame;

  /**
   * Constructor for the NavQueryPanel class.
   *
   * @param navQuery the NavQuery
   * @param frame    the frame where this panel is inside
   */
  public NavQueryPanel( NavQuery navQuery, JFrame frame ) {
    this.navQuery = navQuery;
    this.frame = frame;
  }
}

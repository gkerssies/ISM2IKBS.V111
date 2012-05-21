package gfy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Creates a panel for a NavQuery. Contains title, description and query for the
 * NavQuery and buttons for editing and deleting the NavQuery.
 *
 * @author Gerjan Kerssies
 */
public class NavQueryPanel extends JPanel {

  private JLabel title, description;
  private JButton buttonEdit, buttonDelete;
  private ImageIcon editIcon = new ImageIcon( "./resources/images/status-red.png" );
  private ImageIcon deleteIcon = new ImageIcon( "./resources/images/status-red.png" );
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

    title = new JLabel( this.navQuery.getTitle() );
    description = new JLabel( this.navQuery.getDescription() );

    buttonEdit = new JButton(editIcon);
    buttonEdit.addActionListener( ( ActionListener ) frame );

    buttonDelete = new JButton(deleteIcon);
    buttonDelete.addActionListener( ( ActionListener ) frame );

    add( title );
    add( buttonEdit );
    add( description );
    add( buttonDelete );

    setLayout( new GridLayout( 2, 2 ) );
    setPreferredSize( new Dimension( 330, 60 ) );
  }
}

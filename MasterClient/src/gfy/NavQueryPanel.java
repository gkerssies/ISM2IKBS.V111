package gfy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Creates a panel for a NavQuery. Contains title, description and query for the
 * NavQuery and buttons for editing and deleting the NavQuery.
 *
 * @author Gerjan Kerssies
 */
public class NavQueryPanel extends JPanel implements ActionListener {

  private JPanel panelText, panelButtons;
  private JLabel title, description;
  private JButton buttonEdit, buttonDelete;
  private ImageIcon editIcon = new ImageIcon( "./resources/images/bewerken.gif" );
  private ImageIcon deleteIcon = new ImageIcon( "./resources/images/verwijderen.gif" );
  private NavQuery navQuery;
  private NavQueryOverview nqo;
  private SQLManagement frame;

  /**
   * Constructor for the NavQueryPanel class.
   *
   * @param navQuery the NavQuery
   * @param frame    the frame where this panel is inside
   */
  public NavQueryPanel( NavQuery navQuery, SQLManagement frame, NavQueryOverview nqo ) {
    this.navQuery = navQuery;
    this.nqo = nqo;
    this.frame = frame;

    panelText = new JPanel();
    panelText.setPreferredSize( new Dimension( 350, 50 ) );
    panelButtons = new JPanel();
    panelButtons.setPreferredSize( new Dimension( 20, 50 ) );
    panelButtons = new JPanel();

    add( panelText );
    add( panelButtons );

    title = new JLabel( this.navQuery.getTitle() );
    description = new JLabel( this.navQuery.getDescription() );

    buttonEdit = new JButton( editIcon );
    buttonEdit.addActionListener( ( ActionListener ) this );

    if ( this.navQuery.isBuiltInQuery() == false ) {
      buttonDelete = new JButton( deleteIcon );
      buttonDelete.addActionListener( ( ActionListener ) this );
    }

    panelText.add( title );
    panelText.add( description );

    panelButtons.add( buttonEdit );
    if ( this.navQuery.isBuiltInQuery() == false ) {
      panelButtons.add( buttonDelete );
    }

    setLayout( new FlowLayout() );
  }

  @Override
  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == buttonEdit ) {
      JFrame editFrame = new EditNavQuery( frame, nqo, this.navQuery );
      editFrame.addWindowListener( new autoReloadonWindowCloseHandler( frame ) );
    } else if ( e.getSource() == buttonDelete ) {
      DeleteNavQuery deleteFrame = new DeleteNavQuery( frame, nqo, this.navQuery );
      frame.reload();
    }
  }
}

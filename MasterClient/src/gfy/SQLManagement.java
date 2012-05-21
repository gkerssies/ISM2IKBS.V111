package gfy;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Create a JFrame which can edit query's.
 *
 * @author Gerjan Kerssies
 */
public class SQLManagement extends JFrame implements ActionListener {

  private JPanel panel;
  private JButton buttonAdd;
  private ClientConnection connection;
  private NavQueryOverview nqo;
  private ArrayList<NavQueryPanel> queryPanel;
  private int index;

  /**
   * Constructor for the SQLManagement class.
   *
   * @param connection the connection Object with the client
   */
  public SQLManagement( ClientConnection connection ) {
    this.connection = connection;
    nqo = connection.getNavisionQueryOverview();
    queryPanel = new ArrayList<NavQueryPanel>();

    for ( NavQuery nq : nqo.getNavQueries() ) {
      NavQueryPanel navQueryPanel = new NavQueryPanel( nq, this, nqo );
      queryPanel.add( index, navQueryPanel );
      index++;
    }

    panel = new JPanel();

    buttonAdd = new JButton();
    buttonAdd.setText( "Toevoegen" );
    buttonAdd.setPreferredSize( new Dimension( 110, 25 ) );
    buttonAdd.addActionListener( this );

    panel.add( buttonAdd );

    for ( NavQueryPanel nqp : queryPanel ) {
      panel.add( nqp );
    }

    setLayout( new GridLayout( 4, 1 ) );
    setContentPane( panel );
    setSize( 500, 500 );
    setResizable( false );
    setTitle( "SQL beheer" );
    addWindowListener( new autoCloseOnSaveAuthorizationHandler( connection, nqo, this ) );
    setLocationRelativeTo( getRootPane() );
    setVisible( true );
  }

  /**
   * Get the maximun id of the NavQueries.
   *
   * @return int maximum id
   */
  public int getMaxId() {
    int i = 0;

    for ( NavQuery nq : nqo.getNavQueries() ) {
      if ( nq.getId() > i ) {
        i = nq.getId();
      }
    }

    return i;
  }

  @Override
  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == buttonAdd ) {
      JFrame frame = new AddNavQuery( this, nqo );
    }
  }
}

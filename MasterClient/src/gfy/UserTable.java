/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.TableModel;

/**
 *
 * @author Gerjan Kerssies
 */
public class UserTable extends JPanel {

  private User user;
  private Object[][] users;
  private String clickedUser;
  private boolean DEBUG = true;

  public UserTable( User user, ClientConnection clientConnection ) {
    super( new GridLayout( 1, 0 ) );
    this.user = user;

    String[] columnNames = { "Gebruiker", "Type" };

    users = getUsers();

    final JTable table = new JTable( users, columnNames );
    table.setPreferredScrollableViewportSize( new Dimension( 500, 500 ) );
    table.setFillsViewportHeight( true );

    if ( DEBUG ) {
      table.addMouseListener( new MouseAdapter() {

        public void mouseClicked( MouseEvent e ) {
          setClickedUser( table );
        }
      } );
    }

    JScrollPane scrollPane = new JScrollPane( table );

    add( scrollPane );
  }

  private Object[][] getUsers() {
    Object[][] data = new Object[ user.getUsername().size() ][ 1 ];

    for ( int i = 0; i < user.getUsername().size(); i++ ) {
      data[i] = new Object[] { user.getUsername().get( i ), user.getUserType().get( i ) };
    }

    return data;
  }

  private void setClickedUser( JTable table ) {
    int numRows = table.getRowCount();
    TableModel model = table.getModel();

    for ( int i = 0; i < numRows; i++ ) {
      clickedUser = ( String ) model.getValueAt( i, 0 );
    }
  }

  public String getClickedUser() {
    return clickedUser;
  }
}
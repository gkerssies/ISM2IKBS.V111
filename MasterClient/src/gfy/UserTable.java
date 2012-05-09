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

/**
 *
 * @author Gerjan Kerssies
 */
public class UserTable extends JPanel {

  private User user;
  private Object[][] users;
  private boolean DEBUG = false;

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
          printDebugData( table );
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

  private void printDebugData( JTable table ) {
    int numRows = table.getRowCount();
    int numCols = table.getColumnCount();
    javax.swing.table.TableModel model = table.getModel();

    System.out.println( "Value of data: " );
    for ( int i = 0; i < numRows; i++ ) {
      System.out.print( "    row " + i + ":" );
      for ( int j = 0; j < numCols; j++ ) {
        System.out.print( "  " + model.getValueAt( i, j ) );
      }
      System.out.println();
    }
    System.out.println( "--------------------------" );
  }
}
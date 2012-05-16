package gfy;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import javax.swing.text.TabExpander;

/**
 *
 * @author Gerjan Kerssies
 */
public class UserTable extends JPanel {

  private User user;
  private Object[][] users;
  private String clickedUser;
  private boolean DEBUG = true;
  private CustomTable table;

  public UserTable( User user, ClientConnection clientConnection ) {
    super( new GridLayout( 1, 0 ) );
     this.user = user;
    
    buildTable();
    JScrollPane scrollPane = new JScrollPane( table );
    add( scrollPane );
  }

  protected void buildTable()
  {
    
   

    String[] columnNames = { "Gebruiker", "Type" };

    users = getUsers();

    table = new CustomTable( users, columnNames );
    
    
    table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    table.setPreferredScrollableViewportSize( new Dimension( 500, 500 ) );
    table.setFillsViewportHeight( true );

  
      table.addMouseListener( new MouseAdapter() {

        public void mouseClicked( MouseEvent e ) {
          setClickedUser( table );
        }
      } );
    
  }
  private Object[][] getUsers() {
    Object[][] data = new Object[ user.getUsername().size() ][ 1 ];

    for ( int i = 0; i < user.getUsername().size(); i++ ) {
      data[i] = new Object[] { user.getUsername().get( i ), user.getUserType().get( i ) };
    }

    return data;
  }

  private void setClickedUser( JTable table ) {
    try
    {
    int numRows = table.getRowCount();
    TableModel model = table.getModel();

    for ( int i = 0; i < numRows; i++ ) {
      clickedUser = ( String ) model.getValueAt(table.getSelectedRow(), 0 );
    }
    }
    catch(Exception ex)
    {
      clickedUser = null;
    }
  }

  public String getClickedUser() {
    return clickedUser;
  }

  /**
   * @param user the user to set
   */
  public void setUser( User user ) {
    this.user = user;
  }
}
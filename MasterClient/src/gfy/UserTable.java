package gfy;

import BackupRestore.CustomTable;
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
 * Creates a JPanel with a selectable user table.
 * 
 * @author Gerjan Kerssies
 */
public class UserTable extends JPanel {

  private User user;
  private Object[][] users;
  private String clickedUser;
  private boolean DEBUG = true;
  private CustomTable table;

  /**
   * Constructor for the UserTable class.
   * 
   * @param user the User object
   * @param clientConnection the clientConnection object
   */
  public UserTable( User user, ClientConnection clientConnection ) {
    super( new GridLayout( 1, 0 ) );
    this.user = user;

    buildTable();
    JScrollPane scrollPane = new JScrollPane( table );
    add( scrollPane );
  }

  /**
   * Build the table including the user data.
   */
  protected void buildTable() {
    String[] columnNames = { "Gebruiker", "Type" };

    users = getUsers();

    table = new CustomTable( users, columnNames );
    table.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
    table.setPreferredScrollableViewportSize( new Dimension( 500, 500 ) );
    table.setFillsViewportHeight( true );

    table.addMouseListener( new MouseAdapter() {

      public void mouseClicked( MouseEvent e ) {
        setClickedUser( table );
      }
    } );
  }

  /**
   * Get a user array of all users, which contains usernames and usertypes.
   * 
   * @return the user array
   */
  private Object[][] getUsers() {
    Object[][] data = new Object[ user.getUsername().size() ][ 1 ];

    for ( int i = 0; i < user.getUsername().size(); i++ ) {
      data[i] = new Object[] { user.getUsername().get( i ), user.getUserType().get( i ) };
    }

    return data;
  }

  /**
   * Set clicked user with the username of the selected table row.
   * 
   * @param table the JTable object
   */
  private void setClickedUser( JTable table ) {
    try {
      int numRows = table.getRowCount();
      TableModel model = table.getModel();

      for ( int i = 0; i < numRows; i++ ) {
        clickedUser = ( String ) model.getValueAt( table.getSelectedRow(), 0 );
      }
    } catch ( Exception ex ) {
      clickedUser = null;
    }
  }

  /**
   * Get the clicked user.
   * 
   * @return the clicked user
   */
  public String getClickedUser() {
    return clickedUser;
  }

  /**
   * Set the User object.
   * 
   * @param user the User object
   */
  public void setUser( User user ) {
    this.user = user;
  }
}
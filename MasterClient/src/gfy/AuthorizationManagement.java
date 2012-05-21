package gfy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.TableModel;

/**
 * Creates a JFrame with a overview of all users. From this frame, users can be
 * added, edited and deleted, by selecting a user in the table and clicking on
 * the desired button.
 *
 * @author Gerjan Kerssies
 */
public class AuthorizationManagement extends JFrame implements ActionListener {

  private User user;
  private UserTable userTable;
  private JPanel panel = new JPanel();
  private JButton buttonAdd, buttonEdit, buttonDelete;
  private ClientConnection clientconnection;

  /**
   * Constructor for the AuthorizationManagement class.
   *
   * @param clientconnection the connection Object with the client.
   */
  public AuthorizationManagement( ClientConnection clientconnection ) {
    setDefaultCloseOperation( DISPOSE_ON_CLOSE );
    this.clientconnection = clientconnection;
    buildView();

  }

  /**
   * Add all components to the JFrame, including panels.
   */
  public void buildView() {
    user = clientconnection.getUser();

    setLayout( new BorderLayout() );
    userTable = new UserTable( user, clientconnection );
    userTable.setOpaque( true );
    userTable.setPreferredSize( new Dimension( 500, 500 ) );

    JPanel panelButtons = new JPanel();
    panelButtons.setPreferredSize( new Dimension( 140, 500 ) );

    buttonAdd = new JButton();
    buttonAdd.setText( "Toevoegen" );
    buttonAdd.setPreferredSize( new Dimension( 110, 25 ) );
    buttonAdd.addActionListener( this );

    buttonEdit = new JButton();
    buttonEdit.setText( "Aanpassen" );
    buttonEdit.setPreferredSize( new Dimension( 110, 25 ) );
    buttonEdit.addActionListener( this );

    buttonDelete = new JButton();
    buttonDelete.setText( "Verwijderen" );
    buttonDelete.setPreferredSize( new Dimension( 110, 25 ) );
    buttonDelete.addActionListener( this );

    panel.add( userTable, BorderLayout.WEST );
    panel.add( panelButtons, BorderLayout.EAST );

    panelButtons.add( buttonAdd );
    panelButtons.add( buttonEdit );
    panelButtons.add( buttonDelete );
    setContentPane( panel );

    setSize( 660, 540 );
    setResizable( false );
    setTitle( "Authorisatiebeheer" );
    addWindowListener( new autoCloseOnSaveAuthorizationHandler( clientconnection, user, this ) );
    pack();
    setLocationRelativeTo( getRootPane() );
    setVisible( true );
  }

  /**
   * Opens the frame after a button is clicked. Can open the following frames:
   * EditUser, DeleteUser. When no user is clicked, then an message is shown.
   *
   * @param action the action (can be editUser or deleteUser)
   * @param click  the selected user of UserSettingsPanel
   */
  public void openFrame( String action, String click ) {
    String clickedUser = click;

    if ( clickedUser != null ) {
      switch ( action ) {
        case "editUser":
          JFrame frame = new EditUser( user, clickedUser, this );
          frame.addWindowListener( new autoReloadonWindowCloseHandler( this ) );
          break;

        case "deleteUser":
          DeleteUser deleteUser = new DeleteUser( user, clickedUser, this );
          reload();
          break;
      }
    } else {
      switch ( action ) {
        case "editUser":
          JOptionPane.showMessageDialog( this, "Er is geen gebruiker geselecteerd om te aanpassen!", "Gebruiker wijzigen", JOptionPane.WARNING_MESSAGE );
          break;

        case "deleteUser":
          JOptionPane.showMessageDialog( this, "Er is geen gebruiker geselecteerd om te verwijderen!", "Gebruiker verwijderen", JOptionPane.WARNING_MESSAGE );
          break;
      }
    }
  }

  @Override
  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == buttonAdd ) {
      JFrame frame = new AddUser( user, this );
      frame.addWindowListener( new autoReloadonWindowCloseHandler( this ) );
    } else if ( e.getSource() == buttonEdit ) {
      openFrame( "editUser", userTable.getClickedUser() );

    } else if ( e.getSource() == buttonDelete ) {
      openFrame( "deleteUser",userTable.getClickedUser() );
    }
  }

  /**
   * Reloads the panel.
   */
  public void reload() {
    
    new AuthorizationManagement( clientconnection );
    this.dispose();
  }
}

package gfy;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Creates a JFrame which a user can be edited.
 *
 * @author Gerjan Kerssies
 */
public class EditUser extends JFrame implements ActionListener {

  private User user;
  private AuthorizationManagement authorizationManagement;
  private UserSettingsPanel panel;

  /**
   * Constructor for the InformationPanel class.
   *
   * @param user                    the User object
   * @param username                the username of the clicked user
   * @param authorizationManagement the AuthorizationManagement object
   */
  public EditUser( User user, String username, AuthorizationManagement authorizationManagement ) {
    this.user = user;
    this.authorizationManagement = authorizationManagement;
    this.panel = new UserSettingsPanel( this.user, "editUser", this, username );

    setLayout( new GridLayout() );
    setContentPane( panel );
    setSize( 350, 190 );
    setResizable( false );
    setTitle( "Aanpassen gebruiker" );
    setLocationRelativeTo( getRootPane() );
    setVisible( true );
  }

  /**
   * Save the changed user settings to the User object.
   */
  public void save() {
    if ( panel.getUserType().getSelectedItem() == "beheerder" ) {
      user.setUser( panel.getUsername().getText(), panel.getPassword().getText(), UserType.beheerder );
    } else {
      user.setUser( panel.getUsername().getText(), panel.getPassword().getText(), UserType.gebruiker );
    }
  }

  @Override
  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == panel.getButtonCancel() ) {
      dispose();
    } else if ( e.getSource() == panel.getButtonSave() ) {
      save();
      dispose();
    }
  }
}

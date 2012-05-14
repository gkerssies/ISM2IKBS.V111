package gfy;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Gerjan Kerssies
 */
public class AddUser extends JFrame implements ActionListener {

  private User user;
  private AuthorizationManagement authorizationManagement;
  private UserSettingsPanel panel;

  public AddUser( User user, AuthorizationManagement authorizationManagement ) {
    this.user = user;
    this.authorizationManagement = authorizationManagement;
    this.panel = new UserSettingsPanel( null, "addUser", this, "" );

    setLayout( new GridLayout() );
    setContentPane( panel );
    setSize( 350, 190 );
    setResizable( false );
    setTitle( "Toevoegen gebruiker" );
    setVisible( true );
  }

  public void save() {
    if ( panel.getUserType().getSelectedItem() == "beheerder" ) {
      user.addUser( panel.getUsername().getText(), panel.getPassword().getText(), UserType.beheerder );
    } else {
      user.addUser( panel.getUsername().getText(), panel.getPassword().getText(), UserType.gebruiker );
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

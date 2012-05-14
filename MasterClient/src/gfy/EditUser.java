/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Gerjan Kerssies
 */
public class EditUser extends JFrame implements ActionListener {

  private User user;
  private AuthorizationManagement authorizationManagement;
  private UserSettingsPanel panel;

  public EditUser( User user, String username, AuthorizationManagement authorizationManagement ) {
    this.user = user;
    this.authorizationManagement = authorizationManagement;
    this.panel = new UserSettingsPanel( this.user, "editUser", this, username );

    setLayout( new GridLayout() );
    setContentPane( panel );
    setSize( 350, 190 );
    setResizable( false );
    setTitle( "Aanpassen gebruiker" );
    setVisible( true );
  }

  public void save() {
    if ( panel.getUserType().getSelectedItem() == "beheerder" ) {
      user.setUser( panel.getUsername().getText(), panel.getPassword().getText(), UserType.beheerder );
    } else {
      user.setUser( panel.getUsername().getText(), panel.getPassword().getText(), UserType.gebruiker );
    }
  }

  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == panel.getButtonCancel() ) {
      dispose();
    } else if ( e.getSource() == panel.getButtonSave() ) {
      save();
      dispose();
    }
  }
}

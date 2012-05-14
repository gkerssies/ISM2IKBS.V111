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

  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == panel.getButtonCancel() ) {
      dispose();
    } else if ( e.getSource() == panel.getButtonSave() ) {
      save();
      dispose();
    }
  }
}

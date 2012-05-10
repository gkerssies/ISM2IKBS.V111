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

  private UserSettingsPanel panel;

  public EditUser( String username ) {
    this.panel = new UserSettingsPanel( "editUser", this, username );

    setLayout( new GridLayout() );
    setContentPane( panel );
    setSize( 350, 190 );
    setResizable( false );
    setTitle( "Aanpassen gebruiker" );
    setVisible( true );
  }

  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == panel.getButtonCancel() ) {
      dispose();
    } else if ( e.getSource() == panel.getButtonSave() ) {
    }
  }
}
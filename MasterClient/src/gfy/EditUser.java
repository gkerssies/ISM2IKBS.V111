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

  private JPanel panel;

  public EditUser( String username ) {
    panel = new UserSettingsPanel("editUser");

    setLayout( new GridLayout() );
    setContentPane( panel );
    setSize( 350, 190 );
    setResizable( false );
    setTitle( "Aanpassen gebruiker" );
    setVisible( true );
  }

  public void actionPerformed( ActionEvent e ) {
  }
}

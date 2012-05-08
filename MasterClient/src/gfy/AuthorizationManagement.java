/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.TableView;

/**
 *
 * @author Gerjan Kerssies
 * @version 0.1 - 26-04-2012
 */
public class AuthorizationManagement extends JFrame implements ActionListener {

  private JPanel panel;
  private JButton buttonAdd, buttonEdit, buttonDelete;

  public AuthorizationManagement() {
    panel = new JPanel();
    
    buttonAdd = new JButton();
    buttonAdd.setText( "Toevoegen" );
    buttonAdd.setPreferredSize( new Dimension( 100, 25 ) );
    buttonAdd.addActionListener( this );

    buttonEdit = new JButton();
    buttonEdit.setText( "Aanpassen" );
    buttonEdit.setPreferredSize( new Dimension( 100, 25 ) );
    buttonEdit.addActionListener( this );

    buttonDelete = new JButton();
    buttonDelete.setText( "Verwijderen" );
    buttonDelete.setPreferredSize( new Dimension( 100, 25 ) );
    buttonDelete.addActionListener( this );

    panel.add( buttonAdd );
    panel.add( buttonEdit );
    panel.add( buttonDelete );

    setLayout( new BorderLayout() );
    setContentPane( panel );
    setSize( 500, 300 );
    setResizable( false );
    setTitle( "Authorisatiebeheer" );
    setVisible( true );
  }

  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == buttonAdd ) {
      JFrame frame = new AddUser();
    } else if ( e.getSource() == buttonEdit ) {
      //JFrame frame = new EditUser();
    } else if ( e.getSource() == buttonDelete ) {
      //JFrame frame = new DeleteUser();
    }
  }
}

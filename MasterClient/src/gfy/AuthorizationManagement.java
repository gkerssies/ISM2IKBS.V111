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

  private User user = new User();
  private JPanel panel = new JPanel();
  private JButton buttonAdd, buttonEdit, buttonDelete;
  private ClientConnection clientconnection;

  public AuthorizationManagement(ClientConnection clientconnection) {
    System.out.println( "test" );
    this.clientconnection = clientconnection;
    user = clientconnection.getProtocol().getUsers();
    //user.addUser( "Henk", null, UserType.beheerder );
    //user.addUser( "Jan", null, UserType.gebruiker );
    //user.addUser( "Sjaak", null, UserType.gebruiker );
    //user.addUser( "Klaas", null, UserType.gebruiker );
    //user.addUser( "Piet", null, UserType.gebruiker );

    //System.out.println( user.toString() );

    setLayout( new BorderLayout() );

    UserTable userTable = new UserTable();
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
    setTitle( "Authorisatiebeheer2" );
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

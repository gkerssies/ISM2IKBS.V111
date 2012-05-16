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
 */
public class AuthorizationManagement extends JFrame implements ActionListener {

  private User user;
  private UserTable userTable;
  private JPanel panel = new JPanel();
  private JButton buttonAdd, buttonEdit, buttonDelete;
  private ClientConnection clientconnection;

  public AuthorizationManagement( ClientConnection clientconnection ) {
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.clientconnection = clientconnection;
    buildView();
    
  }
  public void buildView()
  {
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
    setVisible( true );
  }

  public void openFrame( String action ) {
    String clickedUser = userTable.getClickedUser();

    if ( clickedUser != null ) {
      switch ( action ) {
        case "editUser":
          JFrame frame = new EditUser( user, clickedUser, this );
          frame.addWindowListener(new autoReloadonWindowCloseHandler( this ) );
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

  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == buttonAdd ) {
      JFrame frame = new AddUser( user, this );
      frame.addWindowListener(new autoReloadonWindowCloseHandler( this ) );
    } else if ( e.getSource() == buttonEdit ) {
      openFrame( "editUser" );
      
    } else if ( e.getSource() == buttonDelete ) {
      openFrame( "deleteUser" );
    }
  }
  public void reload()
  {
    System.out.println( "test" );
    panel = new JPanel();
   
    buildView();
    setContentPane(panel);
    panel.repaint();
    repaint();
  }
}

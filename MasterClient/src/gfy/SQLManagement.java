/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Create a JFrame which can edit query's.
 *
 * @author Gerjan Kerssies
 */
public class SQLManagement extends JFrame implements ActionListener {

  private JPanel panel;
  private JButton buttonAdd;
  private ClientConnection connection;

  /**
   * Constructor for the SQLManagement class.
   *
   * @param connection the connection Object with the client
   */
  public SQLManagement( ClientConnection connection ) {
    this.connection = connection;
    
    panel = new JPanel();
    
    buttonAdd = new JButton();
    buttonAdd.setText( "Toevoegen" );
    buttonAdd.setPreferredSize( new Dimension( 110, 25 ) );
    buttonAdd.addActionListener( this );
    
    panel.add( buttonAdd );
    
    setLayout( new GridLayout( 4, 1 ) );
    setContentPane( panel );
    setSize( 350, 500 );
    setResizable( false );
    setTitle( "SQL beheer" );
    setLocationRelativeTo( getRootPane() );
    setVisible( true );
  }

  @Override
  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == buttonAdd ) {
      JFrame frame = new AddNavQuery();
    }
  }
}

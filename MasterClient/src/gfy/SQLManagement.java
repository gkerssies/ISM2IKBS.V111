/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Create a JFrame which can edit query's.
 *
 * @author Gerjan Kerssies
 */
public class SQLManagement extends JFrame implements ActionListener {

  private JPanel panel;
  private ClientConnection connection;

  /**
   * Constructor for the SQLManagement class.
   *
   * @param connection the connection Object with the client
   */
  public SQLManagement( ClientConnection connection ) {
    this.connection = connection;
    
    panel = new JPanel();
    
    setLayout( new GridLayout( 4, 1 ) );
    setContentPane( panel );
    setSize( 330, 220 );
    setResizable( false );
    setTitle( "SQL beheer" );
    setLocationRelativeTo( getRootPane() );
    setVisible( true );
  }

  @Override
  public void actionPerformed( ActionEvent e ) {
  }
}

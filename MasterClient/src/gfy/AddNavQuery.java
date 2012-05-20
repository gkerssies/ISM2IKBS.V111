/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Creates a JFrame which a NavQuery can be added.
 *
 * @author Gerjan Kerssies
 */
public class AddNavQuery extends JFrame implements ActionListener {

  private JPanel panel;
  
  /**
   * Constructor for the AddNavQuery class.
   */
  public AddNavQuery() {
    panel = new JPanel();
    
    setLayout( new GridLayout( 4, 1 ) );
    setContentPane( panel );
    setSize( 350, 220 );
    setResizable( false );
    setTitle( "Navision query toevoegen" );
    setLocationRelativeTo( getRootPane() );
    setVisible( true );
  }

  @Override
  public void actionPerformed( ActionEvent e ) {
  }
}

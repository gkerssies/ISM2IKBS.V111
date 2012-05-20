/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * Create a JFrame which can edit query's.
 *
 * @author Gerjan Kerssies
 */
public class SQLManagement extends JFrame implements ActionListener {

  private ClientConnection connection;

  /**
   * Constructor for the SQLManagement class.
   *
   * @param connection the connection Object with the client
   */
  public SQLManagement( ClientConnection connection ) {
    this.connection = connection;
  }

  @Override
  public void actionPerformed( ActionEvent e ) {
  }
}

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
 * @version 0.1 - 03-05-2012
 */
public class ServerSettings extends JFrame implements ActionListener {

  private JPanel panel, panelLabel, panelInput;
  private JLabel label1, label2, label3, label4;
  private JTextArea connectionString;
  private JTextField database, username, password;
  private JButton buttonCancel, buttonSave;

  public ServerSettings() {
    panel = new JPanel();
    /*panelLabel = new JPanel();
    panelLabel.
    panelInput = new JPanel();
    panelInput.setLayout( new GridLayout( 4, 1) );*/

    label1 = new JLabel( "Connectiestring" );
    label2 = new JLabel( "Databasenaam" );
    label3 = new JLabel( "Gebruikersnaam" );
    label4 = new JLabel( "Wachtwoord" );
    
    connectionString = new JTextArea( 3, 15 );
    database = new JTextField( 15 );
    username = new JTextField( 15 );
    password = new JTextField( 15 );

    buttonCancel = new JButton();
    buttonCancel.setText( "Annuleren" );
    buttonCancel.setPreferredSize( new Dimension( 100, 25 ) );
    buttonCancel.addActionListener( this );

    buttonSave = new JButton();
    buttonSave.setText( "Opslaan" );
    buttonSave.setPreferredSize( new Dimension( 100, 25 ) );
    buttonSave.addActionListener( this );

    panel.add( label1 );
    panel.add( connectionString );
    panel.add( label2 );
    panel.add( database );
    panel.add( label3 );
    panel.add( username );
    panel.add( label4 );
    panel.add( password );
    /*panel.add( buttonCancel, BorderLayout.EAST );
    panel.add( buttonSave, BorderLayout.EAST );*/
    
    /*panelLabel.add( label1 );
    panelInput.add( connectionString );
    panelLabel.add( label2 );
    panelInput.add( database );
    panelLabel.add( label3 );
    panelInput.add( username );
    panelLabel.add( label4 );
    panelInput.add( password );
    panel.add( buttonCancel );
    panel.add( buttonSave );
    
    panel.add( panelLabel, BorderLayout.WEST );
    panel.add( panelInput, BorderLayout.EAST );*/
    
    //setLayout( new BoxLayout( panel, WIDTH) );
    //setLayout( new BorderLayout() );
    setLayout( new GridLayout( 4, 1) );
    setContentPane( panel );
    setSize( 350, 300 );
    setResizable( false );
    setTitle( "Serverinstellingen" );
    setVisible( true );
  }

  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == buttonCancel ) {
    } else if ( e.getSource() == buttonSave ) {
    }
  }
}

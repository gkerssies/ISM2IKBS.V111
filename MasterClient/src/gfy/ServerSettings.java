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

  private JPanel panel, panelLabels, panelInput, panelButtons;
  private JLabel label1, label2, label3, label4;
  private JTextArea connectionString;
  private JTextField database, username, password;
  private JButton buttonCancel, buttonSave;

  public ServerSettings() {
    panel = new JPanel();
    panelLabels = new JPanel();
    panelLabels.setPreferredSize( new Dimension( 110, 140 ) );
    panelInput = new JPanel();
    panelInput.setPreferredSize( new Dimension( 190, 140 ) );
    panelButtons = new JPanel();

    label1 = new JLabel( "Connectiestring" );
    label1.setPreferredSize( new Dimension( 100, 25 ) );
    label2 = new JLabel( "Databasenaam" );
    label2.setPreferredSize( new Dimension( 100, 25 ) );
    label3 = new JLabel( "Gebruikersnaam" );
    label3.setPreferredSize( new Dimension( 100, 25 ) );
    label4 = new JLabel( "Wachtwoord" );
    label4.setPreferredSize( new Dimension( 100, 25 ) );

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

    panel.add(panelLabels);
    panel.add(panelInput);
    panel.add(panelButtons);
    
    panelLabels.add( label1 );
    panelLabels.add( label2 );
    panelLabels.add( label3 );
    panelLabels.add( label4 );
    
    panelInput.add( connectionString );
    panelInput.add( database );
    panelInput.add( username );
    panelInput.add( password );
    
    panelButtons.add( buttonCancel );
    panelButtons.add( buttonSave );

    setLayout( new GridLayout( 4, 1 ) );
    setContentPane( panel );
    setSize( 330, 220 );
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

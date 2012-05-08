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
public class AddUser extends JFrame implements ActionListener {

  private JPanel panel, panelLabels, panelInput, panelButtons;
  private JLabel label1, label2, label3, label4;
  private JTextField username, password, confirmPassword;
  private JComboBox userType;
  private JButton buttonCancel, buttonSave;

  public AddUser() {
    panel = new JPanel();
    panelLabels = new JPanel();
    panelLabels.setPreferredSize( new Dimension( 110, 140 ) );
    panelInput = new JPanel();
    panelInput.setPreferredSize( new Dimension( 190, 140 ) );
    panelButtons = new JPanel();

    label1 = new JLabel( "Gebruikersnaam" );
    label2 = new JLabel( "Wachtwoord" );
    label3 = new JLabel( "Bevestig wachtwoord" );
    label4 = new JLabel( "Type gebruiker" );

    username = new JTextField( 15 );
    password = new JTextField( 15 );
    confirmPassword = new JTextField( 15 );
    userType = new JComboBox();

    buttonCancel = new JButton();
    buttonCancel.setText( "Annuleren" );
    buttonCancel.setPreferredSize( new Dimension( 100, 25 ) );
    buttonCancel.addActionListener( this );

    buttonSave = new JButton();
    buttonSave.setText( "Opslaan" );
    buttonSave.setPreferredSize( new Dimension( 100, 25 ) );
    buttonSave.addActionListener( this );

    panel.add( label1 );
    panel.add( label2 );
    panel.add( label3 );
    panel.add( label4 );

    panel.add( username );
    panel.add( password );
    panel.add( confirmPassword );
    panel.add( userType );
    panel.add( buttonCancel );
    panel.add( buttonSave );

    setLayout( new GridLayout() );
    setContentPane( panel );
    setSize( 350, 300 );
    setResizable( false );
    setTitle( "Toevoegen gebruiker" );
    setVisible( true );
  }

  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == buttonCancel ) {
    } else if ( e.getSource() == buttonSave ) {
    }
  }
}

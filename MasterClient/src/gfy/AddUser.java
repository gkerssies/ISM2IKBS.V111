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
    panelLabels.setPreferredSize( new Dimension( 140, 110 ) );
    panelInput = new JPanel();
    panelInput.setPreferredSize( new Dimension( 190, 110 ) );
    panelButtons = new JPanel();

    label1 = new JLabel( "Gebruikersnaam" );
    label1.setPreferredSize( new Dimension( 130, 20 ) );
    label2 = new JLabel( "Wachtwoord" );
    label2.setPreferredSize( new Dimension( 130, 20 ) );
    label3 = new JLabel( "Bevestig wachtwoord" );
    label3.setPreferredSize( new Dimension( 130, 20 ) );
    label4 = new JLabel( "Type gebruiker" );
    label4.setPreferredSize( new Dimension( 130, 20 ) );

    username = new JTextField( 15 );
    password = new JTextField( 15 );
    confirmPassword = new JTextField( 15 );
    userType = new JComboBox();
    userType.setPreferredSize( new Dimension( 169, 20 ) );

    buttonCancel = new JButton();
    buttonCancel.setText( "Annuleren" );
    buttonCancel.setPreferredSize( new Dimension( 100, 25 ) );
    buttonCancel.addActionListener( this );

    buttonSave = new JButton();
    buttonSave.setText( "Opslaan" );
    buttonSave.setPreferredSize( new Dimension( 100, 25 ) );
    buttonSave.addActionListener( this );

    panel.add( panelLabels );
    panel.add( panelInput );
    panel.add( panelButtons );

    panelLabels.add( label1 );
    panelLabels.add( label2 );
    panelLabels.add( label3 );
    panelLabels.add( label4 );

    panelInput.add( username );
    panelInput.add( password );
    panelInput.add( confirmPassword );
    panelInput.add( userType );

    panelButtons.add( buttonCancel );
    panelButtons.add( buttonSave );

    setLayout( new GridLayout() );
    setContentPane( panel );
    setSize( 350, 190 );
    setResizable( false );
    setTitle( "Toevoegen gebruiker" );
    setVisible( true );
  }

  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == buttonCancel ) {
      dispose();
    } else if ( e.getSource() == buttonSave ) {
    }
  }
}

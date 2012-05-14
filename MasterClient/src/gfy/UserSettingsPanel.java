/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Gerjan Kerssies
 */
public class UserSettingsPanel extends JPanel {

  private JPanel panelLabels, panelInput, panelButtons;
  private JLabel label1, label2, label3, label4;
  private JTextField username, password, confirmPassword;
  private JComboBox userType;
  private JButton buttonCancel, buttonSave;
  private JFrame frame;
  private User user;

  public UserSettingsPanel( User user, String action, JFrame frame, String username ) {
    this.user = user;

    this.frame = frame;
    panelLabels = new JPanel();
    panelLabels.setPreferredSize( new Dimension( 140, 110 ) );
    panelInput = new JPanel();
    panelInput.setPreferredSize( new Dimension( 190, 110 ) );
    panelButtons = new JPanel();

    add( panelLabels );
    add( panelInput );
    add( panelButtons );

    label1 = new JLabel( "Gebruikersnaam" );
    label1.setPreferredSize( new Dimension( 130, 20 ) );
    label2 = new JLabel( "Wachtwoord" );
    label2.setPreferredSize( new Dimension( 130, 20 ) );
    label3 = new JLabel( "Bevestig wachtwoord" );
    label3.setPreferredSize( new Dimension( 130, 20 ) );
    label4 = new JLabel( "Type gebruiker" );
    label4.setPreferredSize( new Dimension( 130, 20 ) );

    this.username = new JTextField( 15 );
    password = new JTextField( 15 );
    confirmPassword = new JTextField( 15 );

    String[] types = { "gebruiker", "beheerder" };
    userType = new JComboBox( types );
    userType.setPreferredSize( new Dimension( 169, 20 ) );

    if ( action == "editUser" ) {
      this.username.setText( username );

      switch ( user.getUserType( username ) ) {
        case gebruiker:
          userType.setSelectedItem( 0 );
          break;

        case beheerder:
          userType.setSelectedItem( 1 );
          break;
      }
    }

    buttonCancel = new JButton();
    buttonCancel.setText( "Annuleren" );
    buttonCancel.setPreferredSize( new Dimension( 100, 25 ) );
    buttonCancel.addActionListener( ( ActionListener ) frame );

    buttonSave = new JButton();
    buttonSave.setText( "Opslaan" );
    buttonSave.setPreferredSize( new Dimension( 100, 25 ) );
    buttonSave.addActionListener( ( ActionListener ) frame );

    panelLabels.add( label1 );
    panelLabels.add( label2 );
    panelLabels.add( label3 );
    panelLabels.add( label4 );

    panelInput.add( this.username );
    panelInput.add( password );
    panelInput.add( confirmPassword );
    panelInput.add( userType );

    panelButtons.add( buttonCancel );
    panelButtons.add( buttonSave );
  }

  /**
   * @return the username
   */
  public JTextField getUsername() {
    return username;
  }

  /**
   * @return the password
   */
  public JTextField getPassword() {
    return password;
  }

  /**
   * @return the confirmPassword
   */
  public JTextField getConfirmPassword() {
    return confirmPassword;
  }

  /**
   * @return the userType
   */
  public JComboBox getUserType() {
    return userType;
  }

  public JButton getButtonSave() {
    return buttonSave;
  }

  /**
   * @return the buttonCancel
   */
  public JButton getButtonCancel() {
    return buttonCancel;
  }
}

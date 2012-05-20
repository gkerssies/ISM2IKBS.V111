package gfy;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Creates a JPanel with all the input fields to add or edit a user. This panel
 * is used by JFrame AddUser and EditUser.
 *
 * @author Gerjan Kerssies
 */
public class UserSettingsPanel extends JPanel {

  private JPanel panelLabels, panelInput, panelButtons;
  private JLabel label1, label2, label3, label4;
  private JTextField username;
  private JPasswordField password, confirmPassword;
  private JComboBox userType;
  private JButton buttonCancel, buttonSave;
  private JFrame frame;
  private User user;

  /**
   * Constructor for the UserSettingsPanel class.
   *
   * @param user     the User object
   * @param action   the action of the panel (can be addUser or editUser)
   * @param frame    the frame where this panel is inside
   * @param username (only if action is editUser)
   */
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
    password = new JPasswordField( 15 );
    confirmPassword = new JPasswordField( 15 );

    String[] types = { "gebruiker", "beheerder" };
    userType = new JComboBox( types );
    userType.setPreferredSize( new Dimension( 169, 20 ) );

    if ( action.equals( "editUser" ) ) {
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
   * @return the username (JTextField)
   */
  public JTextField getUsername() {
    return username;
  }

  /**
   * @return the password (JTextField)
   */
  public JTextField getPassword() {
    return password;
  }

  /**
   * @return the confirmPassword (JTextField)
   */
  public JTextField getConfirmPassword() {
    return confirmPassword;
  }

  /**
   * @return the userType (JComboBox)
   */
  public JComboBox getUserType() {
    return userType;
  }

  /**
   * @return the buttonSave (JButton)
   */
  public JButton getButtonSave() {
    return buttonSave;
  }

  /**
   * @return the buttonCancel (JButton)
   */
  public JButton getButtonCancel() {
    return buttonCancel;
  }
}

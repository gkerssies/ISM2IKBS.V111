package view.login;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import view.overview.OverviewFrame;

/**
 * The loginframe.
 *
 * @author Thomas Baart <m.thomasbaart@gmail.com>
 */
public class LoginFrame extends JFrame implements ActionListener {

  private JPanel contentPanel, loginForm, usernameForm, passwordForm, buttonPanel;
  private JLabel usernameLabel, passwordLabel;
  private JTextField usernameField;
  private JPasswordField passwordField;
  private JButton cancelButton, loginButton;

  /**
   * Default constructor. Assembles the frame.
   */
  public LoginFrame() {
    contentPanel( loginForm( usernameForm(), passwordForm() ), buttonPanel() );
    add( contentPanel );
    setTitle( "Info client - Inloggen" );
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    pack();
    setResizable( false );
  }

  /**
   * Assembles the contentPanel, adding the loginForm and the buttonPanel.
   *
   * @param loginForm   The panel containing the loginForm.
   * @param buttonPanel The panel containing the buttons.
   *
   * @return The assembled contentPanel.
   */
  private JPanel contentPanel( JPanel loginForm, JPanel buttonPanel ) {
    contentPanel = new JPanel( new BorderLayout() );
    contentPanel.add( loginForm, BorderLayout.NORTH );
    contentPanel.add( buttonPanel, BorderLayout.SOUTH );
    return contentPanel;
  }

  /**
   * Assembles the loginForm, adding the usernameForm and passwordForm.
   *
   * @param usernameForm The panel containing the parts for filling in the
   *                     username.
   * @param passwordForm The panel containing the parts for filling in the
   *                     password.
   *
   * @return The assembled loginForm.
   */
  private JPanel loginForm( JPanel usernameForm, JPanel passwordForm ) {
    loginForm = new JPanel( new BorderLayout() );
    loginForm.add( usernameForm, BorderLayout.NORTH );
    loginForm.add( passwordForm, BorderLayout.SOUTH );
    return loginForm;
  }

  /**
   * Assembles the usernameForm, adding a JLabel and a JTextField to it.
   *
   * @return The assembled usernameForm.
   */
  private JPanel usernameForm() {
    usernameForm = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
    usernameLabel = new JLabel( "Gebruikersnaam" );
    usernameField = new JTextField( 20 );
    usernameForm.add( usernameLabel );
    usernameForm.add( usernameField );
    return usernameForm;
  }

  /**
   * Assembles the passwordForm, adding a JLabel and a JPasswordField to it.
   *
   * @return The assembled passwordForm.
   */
  private JPanel passwordForm() {
    passwordForm = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
    passwordLabel = new JLabel( "Wachtwoord" );
    passwordField = new JPasswordField( 20 );
    passwordForm.add( passwordLabel );
    passwordForm.add( passwordField );
    return passwordForm;
  }

  /**
   * Assembles the buttonPanel, adding a cancelButton and a loginButton to it.
   *
   * @return The assembled buttonPanel.
   */
  private JPanel buttonPanel() {
    buttonPanel = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
    cancelButton = new JButton( "Annuleren" );
    cancelButton.addActionListener( this );
    loginButton = new JButton( "Inloggen" );
    loginButton.addActionListener( this );
    buttonPanel.add( cancelButton );
    buttonPanel.add( loginButton );
    return buttonPanel;
  }

  @Override
  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == cancelButton ) {
      System.out.println( "Application shutting down - cancelButton was clicked." );
      System.exit( 0 );
    } else if ( e.getSource() == loginButton ) {
      System.out.println( "LoginButton was clicked." );
      JFrame overviewFrame = new OverviewFrame();
      this.setVisible( false );
      overviewFrame.setVisible( true );
    }
  }
}
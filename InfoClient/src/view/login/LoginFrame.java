package view.login;

import gfy.Auth;
import gfy.ClientConnection;
import gfy.Main;
import gfy.UserType;
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
  private ClientConnection clientConnection;

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
      System.out.println( "LoginButton was clicked. Attempting to login..." );
      initializeConnection( usernameField.getText(), new String( passwordField.getPassword() ) );
    }
  }

  /**
   * Initializes the connection to the info server.
   *
   * @param username The username to attempt to log in with.
   * @param password The password to attempt to log in with.
   *
   * @return The error code. Returns 0 when the connection was established
   *         without errors.
   */
  private int initializeConnection( String username, String password ) {
    clientConnection = new ClientConnection( "localhost", 4444 );
    clientConnection.start();
    try {
      Thread.sleep( 1500 );
      if ( clientConnection.isConnected() ) {
        clientConnection.sendCommand( "AUTH>" );
        Auth authentication = new Auth( username, password, UserType.gebruiker );
        clientConnection.sendObject( authentication );
        System.out.println( clientConnection.recieveCommand() );
      }
    } catch ( Exception ex ) {
      System.out.println( "Er is iets fout gegaan tijdens het maken van de verbinding." );
    }
    Main.setClientConnection( clientConnection );
    openOverviewWindow();
    return 0;
  }

  private void openOverviewWindow() {
    JFrame overviewFrame = new OverviewFrame(clientConnection);
    this.setVisible( false );
    overviewFrame.setVisible( true );
  }
}

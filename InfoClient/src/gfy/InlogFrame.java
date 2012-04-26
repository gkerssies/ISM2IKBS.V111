package gfy;

import UserInterface.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

/**
 * Frame that shows when launching the application, users need to enter their
 * username and password here before they can continue to the overview.
 *
 * @author thomasbaart
 */
public class InlogFrame extends JFrame {
  
  /*
   * TODO: Add actionlistener class
   * TODO: Add getters for the buttons and fields
   * TODO: Clean up the setup method! Way too crowded!
   */
  private InputPanel usernamePanel, passwordPanel, buttonPanel, loginFormPanel;
  private TexturedPanel mainPanel;
  private TexturedTextField usernameField;
  private TexturedPasswordField passwordField;
  private ImgButton cancelButton, loginButton;
  private Dimension inlogFrameDim, userMonitorDim;
  private static final String fieldBackground = "resources/images/backgrounds/fieldPattern.png";
  private static final String mainPanelBackground = "resources/images/backgrounds/mainPanelPattern.png";
  private static final String userNameLabelImage = "resources/images/labels/usernameLabel.png";
  private static final String passwordLabelImage = "resources/images/labels/passwordLabel.png";
  private static final String cancelButtonImage = "resources/images/buttons/cancelButton.png";
  private static final String loginButtonImage = "resources/images/buttons/loginButton.png";

  /**
   * Default constructor.
   */
  public InlogFrame() {
    super();
    setup();
  }

  /**
   * Sets up the InlogFrame.
   */
  private void setup() {
    mainPanel = new TexturedPanel( mainPanelBackground );
    mainPanel.setLayout( new BorderLayout() );

    loginFormPanel = new InputPanel();
    loginFormPanel.setLayout( new BorderLayout() );
    LineBorder outerBorder = new LineBorder( new Color( 0, 0, 0, 0 ), 4 );
    LineBorder innerBorder = new LineBorder( Color.GRAY, 1 );
    CompoundBorder border = new CompoundBorder( outerBorder, innerBorder );
    loginFormPanel.setBorder( border );

    usernamePanel = new InputPanel( userNameLabelImage );
    usernamePanel.setBackground( new Color( 255, 255, 255, 150 ) );
    passwordPanel = new InputPanel( passwordLabelImage );
    passwordPanel.setBackground( new Color( 255, 255, 255, 150 ) );
    buttonPanel = new InputPanel();

    outerBorder = new LineBorder( Color.GRAY, 1 );
    innerBorder = new LineBorder( new Color( 0, 0, 0, 0 ), 3 );
    border = new CompoundBorder( outerBorder, innerBorder );

    usernameField = new TexturedTextField( fieldBackground, 15 );
    usernameField.setBorder( border );
    passwordField = new TexturedPasswordField( fieldBackground, 15 );
    passwordField.setBorder( border );

    cancelButton = new ImgButton( cancelButtonImage );
    loginButton = new ImgButton( loginButtonImage );

    usernamePanel.add( usernameField );
    passwordPanel.add( passwordField );
    buttonPanel.add( cancelButton );
    buttonPanel.add( loginButton );

    loginFormPanel.add( usernamePanel, BorderLayout.NORTH );
    loginFormPanel.add( passwordPanel, BorderLayout.SOUTH );
    mainPanel.add( loginFormPanel, BorderLayout.NORTH );
    mainPanel.add( buttonPanel, BorderLayout.SOUTH );
    add( mainPanel );

    userMonitorDim = Toolkit.getDefaultToolkit().getScreenSize();

    setLayout( new GridLayout() );
    setTitle( "Info Client - Login" );
    setVisible( true );
    pack();
    inlogFrameDim = getSize();

    setLocation( ( userMonitorDim.width / 2 ) - ( inlogFrameDim.width / 2 ),
                 ( int ) ( userMonitorDim.height / 2.75 ) - ( inlogFrameDim.height / 2 ) );

    setResizable( false );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
}

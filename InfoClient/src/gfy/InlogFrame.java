package gfy;

import UserInterface.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

/**
 * Frame that shows when launching the application, users need to enter their
 * username and password here before they can continue to the overview.
 *
 * @author thomasbaart
 */
public class InlogFrame extends JFrame {

  private InputPanel usernamePanel, passwordPanel, buttonPanel, loginFormPanel;
  private TexturedPanel mainPanel;
  private TexturedTextField usernameField;
  private TexturedPasswordField passwordField;
  private ImgButton cancelButton, loginButton;
  private Dimension inlogFrameDim, userMonitorDim;
  private ActionListener listener;
  private static final String fieldBackground = "resources/images/backgrounds/fieldPattern.png";
  private static final String mainPanelBackground = "resources/images/backgrounds/mainPanelPattern.png";
  private static final String userNameLabelImage = "resources/images/labels/usernameLabel.png";
  private static final String passwordLabelImage = "resources/images/labels/passwordLabel.png";
  private static final String cancelButtonImage = "resources/images/buttons/cancelButton.png";
  private static final String loginButtonImage = "resources/images/buttons/loginButton.png";
  private static final Color transparant = new Color( 0, 0, 0, 0 );
  private static final Color transparantGray = new Color( 255, 255, 255, 150 );

  /**
   * Default constructor.
   */
  public InlogFrame() {
    super();
    listener = new InlogListener( this );
    setup();
  }

  /**
   * Sets up the InlogFrame.
   */
  private void setup() {
    CompoundBorder border = new CompoundBorder( new LineBorder( Color.GRAY, 1 ),
                                                new LineBorder( transparant, 3 ) );

    setupUsernamePanel( border );
    setupPasswordPanel( border );
    setupButtonPanel();
    setupLoginFormPanel( usernamePanel, passwordPanel );
    setupMainPanel( loginFormPanel, buttonPanel );

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

  /**
   * Sets up the usernamePanel with the appropriate label, field and style
   * settings.
   *
   * @param border Border to style the TexturedTextField with.
   *
   * @return The set up usernamePanel.
   */
  private InputPanel setupUsernamePanel( Border border ) {
    usernamePanel = new InputPanel( userNameLabelImage );
    usernamePanel.setBackground( transparantGray );

    usernameField = new TexturedTextField( fieldBackground, 15 );
    getUsernameField().setBorder( border );

    usernamePanel.add( getUsernameField() );

    return usernamePanel;
  }

  /**
   * Sets up the passwordPanel with the appropriate label, field and style
   * settings.
   *
   * @param border Border to style the TexturedPasswordField with.
   *
   * @return The set up passwordPanel.
   */
  private InputPanel setupPasswordPanel( Border border ) {
    passwordPanel = new InputPanel( passwordLabelImage );
    passwordPanel.setBackground( transparantGray );

    passwordField = new TexturedPasswordField( fieldBackground, 15 );
    getPasswordField().setBorder( border );

    passwordPanel.add( getPasswordField() );

    return passwordPanel;
  }

  /**
   * Sets up the buttonPanel with the appropriate buttons.
   *
   * @return The set up buttonPanel.
   */
  private InputPanel setupButtonPanel() {
    buttonPanel = new InputPanel();

    cancelButton = new ImgButton( cancelButtonImage );
    loginButton = new ImgButton( loginButtonImage );

    cancelButton.addActionListener( listener );
    loginButton.addActionListener( listener );
    
    buttonPanel.add( getCancelButton() );
    buttonPanel.add( getLoginButton() );

    return buttonPanel;
  }

  /**
   * Sets up the inputPanel with the appropriate subpanels.
   *
   * @param topPanel    Panel to use as the top panel.
   * @param bottomPanel Panel to use as the bottom panel.
   *
   * @return The set up inputPanel.
   */
  private InputPanel setupLoginFormPanel( JPanel topPanel, JPanel bottomPanel ) {
    loginFormPanel = new InputPanel();
    loginFormPanel.setLayout( new BorderLayout() );

    LineBorder outerBorder = new LineBorder( transparant, 4 );
    LineBorder innerBorder = new LineBorder( Color.GRAY, 1 );
    CompoundBorder border = new CompoundBorder( outerBorder, innerBorder );
    loginFormPanel.setBorder( border );

    loginFormPanel.add( topPanel, BorderLayout.NORTH );
    loginFormPanel.add( bottomPanel, BorderLayout.SOUTH );

    return loginFormPanel;
  }

  /**
   * Sets up the mainPanel with the appropriate subpanels.
   *
   * @param topPanel    Panel to use as the top panel.
   * @param bottomPanel Panel to use as the bottom panel.
   *
   * @return The set up mainPanel.
   */
  private TexturedPanel setupMainPanel( JPanel topPanel, JPanel bottomPanel ) {
    mainPanel = new TexturedPanel( mainPanelBackground );
    mainPanel.setLayout( new BorderLayout() );

    mainPanel.add( topPanel, BorderLayout.NORTH );
    mainPanel.add( bottomPanel, BorderLayout.SOUTH );

    return mainPanel;
  }

  /**
   * @return the usernameField
   */
  public TexturedTextField getUsernameField() {
    return usernameField;
  }

  /**
   * @return the passwordField
   */
  public TexturedPasswordField getPasswordField() {
    return passwordField;
  }

  /**
   * @return the cancelButton
   */
  public ImgButton getCancelButton() {
    return cancelButton;
  }

  /**
   * @return the loginButton
   */
  public ImgButton getLoginButton() {
    return loginButton;
  }
}

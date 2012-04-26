package gfy;

import UserInterface.ImgButton;
import UserInterface.InputPanel;
import UserInterface.TexturedPanel;
import UserInterface.TexturedPasswordField;
import UserInterface.TexturedTextField;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;

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
  private static final String fieldBackground = "resources/images/backgrounds/fieldPattern.png";
  private static final String mainPanelBackground = "resources/images/backgrounds/mainPanelPattern.png";
  private static final String userNameLabelImage = "resources/images/labels/usernameLabel.png";
  private static final String passwordLabelImage = "resources/images/labels/passwordLabel.png";
  private static final String cancelButtonImage = "resources/images/buttons/cancelButton.png";
  private static final String loginButtonImage = "resources/images/buttons/loginButton.png";

  public InlogFrame() {
    super();
    setup();
  }

  private void setup() {
    mainPanel = new TexturedPanel( mainPanelBackground );
    loginFormPanel = new InputPanel();
    usernamePanel = new InputPanel( userNameLabelImage );
    passwordPanel = new InputPanel( passwordLabelImage );
    buttonPanel = new InputPanel();

    usernameField = new TexturedTextField( fieldBackground, 15 );
    passwordField = new TexturedPasswordField( fieldBackground, 15 );

    cancelButton = new ImgButton( cancelButtonImage );
    loginButton = new ImgButton( loginButtonImage );

    usernamePanel.add( usernameField );
    passwordPanel.add( passwordField );
    buttonPanel.add( cancelButton );
    buttonPanel.add( loginButton );

    loginFormPanel.add( usernamePanel );
    loginFormPanel.add( passwordPanel );
    mainPanel.add( loginFormPanel );
    mainPanel.add( buttonPanel );
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

package gfy;

import UserInterface.InputPanel;
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

  private InputPanel usernameInputPanel, passwordInputPanel, buttonPanel;
  private Dimension inlogFrameDim, userMonitorDim;

  public InlogFrame() {
    super();
    setupPanels();
    setupFrame();
  }

  private void setupPanels() {
    usernameInputPanel = new InputPanel( "resources/images/labels/usernameLabel.png" );
    
    passwordInputPanel = new InputPanel( "resources/images/labels/passwordLabel.png" );
    buttonPanel = new InputPanel();
    add(usernameInputPanel);
    add(passwordInputPanel);
    add(buttonPanel);
  }

  private void setupFrame() {
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

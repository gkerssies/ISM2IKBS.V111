package gfy.panels;

import UserInterface.InputPanel;
import UserInterface.TexturedTextField;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

/**
 * UsernamePanel containing JLabel and TexturedTextField for InlogFrame.java
 *
 * @author thomasbaart
 */
public class UsernamePanel extends InputPanel {

  private TexturedTextField inputField;

  /**
   * Default constructor.
   */
  public UsernamePanel() {
    super();
    generateTextField();
  }

  /**
   *
   * @param fileName Image file to make the label from.
   */
  public UsernamePanel( String fileName ) {
    super( fileName );
    generateTextField();
  }

  /**
   * Generates the TextField for the user to enter his username into.
   */
  private void generateTextField() {
    inputField = new TexturedTextField( "resources/images/backgrounds/fieldPattern.png", 15 );
    LineBorder outerBorder = new LineBorder( Color.gray, 1 );
    LineBorder innerBorder = new LineBorder( new Color( 0, 0, 0, 0 ), 3 );
    CompoundBorder compoundBorder = new CompoundBorder( outerBorder, innerBorder );
    inputField.setBorder( compoundBorder );
    add( inputField );
  }
}

package UserInterface;

import java.awt.Cursor;
import java.awt.Insets;
import javax.swing.JButton;

/**
 * The standard (custum) button that will be used for the info server
 * application
 *
 * @author Ido Bosman (s1047979)
 */
public class CustomButton extends JButton {

  /**
   * Constructor for the CustomButton class. This constructor creates a button
   * with your own text. The button is standard clickable.
   *
   * @param text sets the text on the button
   */
  public CustomButton( String text ) {
    setText( text );
    setEnabled( true );

    setButtonSettings();
  }

  /**
   * Constructor for the CustomButton class. Besides choosing the button text
   * you can also set te clickable state of the button to false.
   *
   * @param text    sets the text on the button
   * @param enabled sets the button clickable or not
   */
  public CustomButton( String text, Boolean enabled ) {
    setText( text );
    setEnabled( enabled );

    setButtonSettings();
  }

  /**
   * Set the button settings that are configured in all constructors.
   */
  private void setButtonSettings() {
    setMargin( new Insets( 0, 5, 0, 5 ) );
    setFocusPainted( false );
    setCursor( new Cursor( Cursor.HAND_CURSOR ) );
  }
}
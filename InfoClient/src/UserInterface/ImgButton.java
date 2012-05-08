package UserInterface;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author thomasbaart
 */
public class ImgButton extends JButton {

  /**
   * Default constructor for ImgButton. Generates a normal JButton.
   */
  public ImgButton() {
    super();
    setOpaque( false );
  }

  /**
   * Generate a button from an image, without borders.
   *
   * @param fileName
   */
  public ImgButton( String fileName ) {
    super( new ImageIcon( fileName ) );
    setOpaque( false );
    setBorder( null );
  }
}

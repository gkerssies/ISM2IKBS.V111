package UserInterface;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPasswordField;

/**
 * Custom JPasswordField that accepts an image File to use as its tiled background.
 * <p> Note: This class makes a borderless JPasswordField. Set the border using
 * JTextField's
 * <code>setBorder</code> method.
 *
 * @author thomasbaart
 */
public class TexturedPasswordField extends JPasswordField {

  TexturePaint texture;

  /**
   * Default constructor. Creates a default JPasswordField.
   */
  public TexturedPasswordField() {
    super();
  }

  /**
   * Constructor of the TexturedTextField class.
   *
   * @param fileString The path of the string to generate a texture from.
   * @param i          The length of the TextField in chars.
   */
  public TexturedPasswordField( String fileString, int i ) {
    super( i );
    try {
      File file = new File( fileString );
      BufferedImage img = ImageIO.read( file );
      Rectangle rect = new Rectangle( 0, 0, img.getWidth( null ), img.getHeight( null ) );
      texture = new TexturePaint( img, rect );
      setBackground( new Color( 0, 0, 0, 0 ) );
      setBorder( null );
    } catch ( IOException e ) {
      System.out.println( "IOException occured in TexturedPasswordField." );
    }
  }

  @Override
  public void paintComponent( Graphics g ) {
    Graphics2D g2 = ( Graphics2D ) g;
    g2.setPaint( texture );
    g.fillRect( 0, 0, getWidth(), getHeight() );
    super.paintComponent( g );
  }
}
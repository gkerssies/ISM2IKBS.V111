package UserInterface;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Custom JPanel that accepts an Image or ImageIcon resource to use as a tiled
 * background.
 *
 * @author Thomas Baart
 */
public class TexturedPanel extends JPanel {

  private TexturePaint painter = null;

  /**
   * Creates a default JPanel.
   */
  public TexturedPanel() {
    super();
  }

  /**
   * Creates a new TexturedPanel that tiles the provided image.
   *
   * @param texture The image resource to build a texture from
   */
  public TexturedPanel( Image texture ) {
    super();

    if ( texture != null ) {
      setupImagePainter( texture );
    }
  }

  /**
   * Creates a new TexturedPanel that tiles the provided icon.
   *
   * @param fileName Image file to generate the texture from.
   */
  public TexturedPanel( String fileName ) {
    super();

    if ( fileName != null ) {
      ImageIcon textureIcon = new ImageIcon( fileName );
      setupIconPainter( textureIcon );
    }
  }

  /**
   * Returns the image buffer used by this TexturedPanel's painter.
   *
   * @return The image resource that's used to build the texture with
   */
  public Image getTexture() {
    if ( painter == null ) {
      return null;
    } else {
      return painter.getImage();
    }
  }

  /**
   * Creates a new TexturePaint using the provided image.
   */
  private void setupImagePainter( Image texture ) {
    if ( texture == null ) {
      painter = null;
      return;
    }

    int w = texture.getWidth( this );
    int h = texture.getHeight( this );

    if ( w <= 0 || h <= 0 ) {
      painter = null;
      return;
    }

    BufferedImage buff = new BufferedImage( w, h, BufferedImage.TYPE_INT_ARGB_PRE );

    Graphics2D g2 = buff.createGraphics();
    g2.drawImage( texture, 0, 0, this );
    painter = new TexturePaint( buff, new Rectangle( 0, 0, w, h ) );

    g2.dispose();
  }

  /**
   * Creates a new TexturePaint using the provided icon.
   */
  private void setupIconPainter( Icon texture ) {
    if ( texture == null ) {
      painter = null;
      return;
    }

    int w = texture.getIconWidth();
    int h = texture.getIconHeight();

    if ( w <= 0 || h <= 0 ) {
      painter = null;
      return;
    }

    BufferedImage buff = new BufferedImage( w, h, BufferedImage.TYPE_INT_ARGB_PRE );

    Graphics2D g2 = buff.createGraphics();
    texture.paintIcon( this, g2, 0, 0 );
    painter = new TexturePaint( buff, new Rectangle( 0, 0, w, h ) );

    g2.dispose();
  }

  /**
   * Paints this component with its textured background.
   */
  protected void paintComponent( Graphics g ) {
    super.paintComponent( g );

    if ( painter != null ) {
      int w = getWidth();
      int h = getHeight();
      Insets in = getInsets();

      int x = in.left;
      int y = in.top;
      w = w - in.left - in.right;
      h = h - in.top - in.bottom;

      if ( w >= 0 && h >= 0 ) {
        Graphics2D g2 = ( Graphics2D ) g;
        Paint pt = g2.getPaint();
        g2.setPaint( painter );
        g2.fillRect( x, y, w, h );
        g2.setPaint( pt );
      }
    }
  }
}

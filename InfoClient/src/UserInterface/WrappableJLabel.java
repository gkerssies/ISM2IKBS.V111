package UserInterface;

import java.awt.Dimension;
import javax.swing.JLabel;

/**
 * Modified JLabel that is able to wrap around.
 *
 * @author thomasbaart
 */
public class WrappableJLabel extends JLabel {

  private final int preferredWidth;

  /**
   * Constructor of WrappableJLabel. Note that the preferredWidth isn't honored
   * in all the layoutmanagers.
   *
   * @param preferredWidth The preferred width in pixels.
   */
  public WrappableJLabel( final int preferredWidth ) {
    this.preferredWidth = preferredWidth;
  }

  /**
   * Constructor of WrappableJLabel, directly sets the labels text. Note that
   * the preferredWidth isn't honored
   * in all the layoutmanagers.
   *
   * @param string         The text to set this label to.
   * @param preferredWidth The preferred width in pixels.
   */
  public WrappableJLabel( String string, final int preferredWidth ) {
    setText( string );
    this.preferredWidth = preferredWidth;
  }

  @Override
  public Dimension getPreferredSize() {
    Dimension superPreferred = super.getPreferredSize();
    return new Dimension(
            ( int ) Math.min( preferredWidth, superPreferred.getWidth() ),
            ( int ) superPreferred.getHeight() );
  }
}
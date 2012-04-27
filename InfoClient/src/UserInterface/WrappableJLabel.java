package UserInterface;

import java.awt.Dimension;
import javax.swing.JLabel;

public class WrappableJLabel extends JLabel {

  private final int preferredWidth;

  public WrappableJLabel( final int preferredWidth ) {
    this.preferredWidth = preferredWidth;
  }

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
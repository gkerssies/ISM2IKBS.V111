package UserInterface;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Right aligned JPanel with a transparent background and optional label
 * generated from an image file.
 *
 * @author thomasbaart
 */
public class InputPanel extends JPanel {

  private JLabel label;

  /**
   * Default constructor. Creates a right aligned panel with a fully transparent
   * background.
   */
  public InputPanel() {
    super( new FlowLayout( FlowLayout.RIGHT ) );
    setBackground( new Color( 0, 0, 0, 0 ) );
  }

  /**
   * Constructor. Creates a right aligned panel with a fully transparent
   * background and a label.
   *
   * @param fileName Image file to make the label from.
   */
  public InputPanel( String fileName ) {
    super( new FlowLayout( FlowLayout.RIGHT ) );
    setBackground( new Color( 0, 0, 0, 0 ) );
    label = new JLabel( new ImageIcon( fileName ) );
    this.add( label );
  }
}

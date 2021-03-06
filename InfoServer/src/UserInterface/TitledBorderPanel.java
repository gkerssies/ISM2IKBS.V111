package UserInterface;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.border.*;

/**
 * This class creates a panel with a border around it which contains a title.
 * This panel is only meant to create a nice look and doesn't contain server
 * functionalities.
 *
 * @author Ido Bosman (s1047979)
 */
public class TitledBorderPanel extends JPanel {

  /**
   * Constructor for the TitledBorderPanel class.
   *
   * @param title  sets the title of the panel
   * @param margin sets the free space around the panel
   */
  public TitledBorderPanel( String title, int[] margin ) {
    setLayout( new FlowLayout( FlowLayout.LEFT, 5, 5 ) );

    // Create empty border that functions as margin
    Border emptyBorder = new EmptyBorder( margin[0], margin[1], margin[2], margin[3] );

    // Create titled border
    Border etchedBorder = new EtchedBorder( EtchedBorder.LOWERED );
    Border titledBorder = new TitledBorder( etchedBorder, title );

    // Set the created borders around the panel
    setBorder( new CompoundBorder( emptyBorder, titledBorder ) );
  }
}
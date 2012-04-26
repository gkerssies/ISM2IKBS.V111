package UserInterface;

import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Ido Bosman
 */
public class TitledBorderPanel extends JPanel {

  /**
   * Constructor for the TitledBorderPanel class
   * 
   * @param title  sets the title of the panel
   * @param margin sets the free space around the panel
   */
  public TitledBorderPanel( String title, int[] margin ) {
    setLayout( new FlowLayout( FlowLayout.LEFT ) );

    // Create a titled border around the panel
    Border emptyBorder = new EmptyBorder( margin[0], margin[1], margin[2], margin[3] );
    Border etchedBorder = new EtchedBorder( EtchedBorder.LOWERED );
    Border titledBorder = new TitledBorder( etchedBorder, title );
    setBorder( new CompoundBorder( emptyBorder, titledBorder ) );
  }
}

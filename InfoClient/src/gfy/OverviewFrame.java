package gfy;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author thomasbaart
 */
public class OverviewFrame extends JFrame {
  private Dimension overviewFrameDim, userMonitorDim;
  
  public OverviewFrame() {
    super();
    userMonitorDim = Toolkit.getDefaultToolkit().getScreenSize();

    setLayout( new GridLayout() );
    setTitle( "Info Client - Login" );
    setVisible( true );
    pack();
    overviewFrameDim = getSize();

    setLocation( ( userMonitorDim.width / 2 ) - ( overviewFrameDim.width / 2 ),
                 ( int ) ( userMonitorDim.height / 2.75 ) - ( overviewFrameDim.height / 2 ) );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
  
}

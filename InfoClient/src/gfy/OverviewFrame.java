package gfy;

import UserInterface.TexturedPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author thomasbaart
 */
public class OverviewFrame extends JFrame {
  private Dimension overviewFrameDim, userMonitorDim;
  private TexturedPanel mainPanel;
  
  public OverviewFrame() {
    super();
    mainPanel = new TexturedPanel( "resources/images/backgrounds/mainPanelPattern.png");
    mainPanel.setLayout( new FlowLayout());
    generateOverviewFrames();
    
    add(mainPanel);
    userMonitorDim = Toolkit.getDefaultToolkit().getScreenSize();

    setLayout( new GridLayout() );
    setTitle( "Info Client - Weergave overzicht" );
    setVisible( true );
    pack();
    overviewFrameDim = getSize();

    setLocation( ( userMonitorDim.width / 2 ) - ( overviewFrameDim.width / 2 ),
                 ( int ) ( userMonitorDim.height / 2.75 ) - ( overviewFrameDim.height / 2 ) );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
  
  private void generateOverviewFrames() {
    mainPanel.add(new OverviewPanel());
    mainPanel.add(new OverviewPanel());
  }
}

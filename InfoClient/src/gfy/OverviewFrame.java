package gfy;

import UserInterface.TexturedPanel;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.*;

/**
 *
 * @author thomasbaart
 */
public class OverviewFrame extends JFrame {

  private Dimension overviewFrameDim, userMonitorDim;
  private TexturedPanel mainPanel;
  private JPanel overViewPanelContainer;

  public OverviewFrame() {
    super();
    overViewPanelContainer = new JPanel();
    overViewPanelContainer.setLayout( new BoxLayout( overViewPanelContainer, BoxLayout.Y_AXIS) );
    overViewPanelContainer.setBackground( new Color( 0, 0, 0, 0 ) );

    generateOverviewFrames();

    mainPanel = new TexturedPanel( "resources/images/backgrounds/mainPanelPattern.png" );
    mainPanel.setLayout( new BorderLayout() );
    mainPanel.add(overViewPanelContainer, BorderLayout.CENTER);
    
    add( mainPanel );

    userMonitorDim = Toolkit.getDefaultToolkit().getScreenSize();

    setLayout( new GridLayout() );
    setTitle( "Info Client - Weergave overzicht" );
    setVisible( true );
    pack();
    overviewFrameDim = getSize();

    setLocation( ( userMonitorDim.width / 2 )
                 - ( overviewFrameDim.width / 2 ),
                 ( int ) ( userMonitorDim.height / 2.75 )
                 - ( overviewFrameDim.height / 2 ) );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  private void generateOverviewFrames() {
    String testIcon = "resources/images/icons/testIcon.png";
    overViewPanelContainer.add( new OverviewPanel( testIcon,
                                                   "TestTitel",
                                                   "Mauris Iaculis Porttitor Posuere. Praesent Id Metus Massa, Ut Blandit Odio. Proin",
                                                   1 ) );
    overViewPanelContainer.add( new OverviewPanel( testIcon,
                                                   "Andere query",
                                                   "Mauris Iaculis Porttitor Posuere. Praesent Id Metus Massa, Ut Blandit Odio. Proin",
                                                   2 ) );
  }
}

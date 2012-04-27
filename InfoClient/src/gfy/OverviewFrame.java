package gfy;

import UserInterface.TexturedPanel;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author thomasbaart
 */
public class OverviewFrame extends JFrame {

  private Dimension overviewFrameDim, userMonitorDim;
  private TexturedPanel mainPanel, overViewPanelContainer;
  private JPanel panel1, panel2;
  private GridBagConstraints gbc;

  public OverviewFrame() {
    super();
    setLayout( new BorderLayout() );
    overViewPanelContainer = new TexturedPanel( "resources/images/backgrounds/mainPanelPattern.png" );
    overViewPanelContainer.setLayout( new GridBagLayout() );
    
    gbc = new GridBagConstraints();
    gbc.insets = new Insets( 2, 2, 2, 2);
    gbc.weightx = 0;
    gbc.weighty = 0;
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    
    generateOverviewFrames();

    mainPanel = new TexturedPanel();
    mainPanel.setLayout( new BorderLayout() );
    mainPanel.add( overViewPanelContainer, BorderLayout.CENTER );

    add( mainPanel, BorderLayout.CENTER );

    userMonitorDim = Toolkit.getDefaultToolkit().getScreenSize();

    setTitle( "Info Client - Weergave overzicht" );
    setVisible( true );
    setSize( 357,163);
    overviewFrameDim = getSize();

    setLocation( ( userMonitorDim.width / 2 )
                 - ( overviewFrameDim.width / 2 ),
                 ( int ) ( userMonitorDim.height / 2.75 )
                 - ( overviewFrameDim.height / 2 ) );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  private void generateOverviewFrames() {
    String testIcon = "resources/images/icons/testIcon.png";

    panel1 = new OverviewPanel( testIcon,
                                "TestTitel",
                                "Mauris Iaculis Porttitor Posuere. Praesent Id Metus Massa, Ut Blandit Odio. Proin" );
    panel2 = new OverviewPanel( testIcon,
                                "Andere query",
                                "Ut Blandit Odio. Proin" );

    overViewPanelContainer.add( panel1, gbc );
    overViewPanelContainer.add( panel2, gbc );
  }
}

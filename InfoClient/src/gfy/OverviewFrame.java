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
    gbc.insets = new Insets( 2, 2, 2, 2 );
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
    pack();

    overviewFrameDim = getSize();

    setLocation( ( userMonitorDim.width / 2 )
                 - ( overviewFrameDim.width / 2 ),
                 ( int ) ( userMonitorDim.height / 2.75 )
                 - ( overviewFrameDim.height / 2 ) );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setVisible( true );
    repaint();
  }

  private void generateOverviewFrames() {
    String testIcon = "resources/images/icons/testIcon.png";

    panel1 = new OverviewPanel( testIcon,
                                "Contactgegevens",
                                "Klantenbestand afdeling Customer Service" );
    panel2 = new OverviewPanel( testIcon,
                                "Sales data Q1 2012",
                                "Fietsenverkoop gedurende financieel kwartaal 1, 2012" );

    overViewPanelContainer.add( panel1, gbc );
    overViewPanelContainer.add( panel2, gbc );
  }
}

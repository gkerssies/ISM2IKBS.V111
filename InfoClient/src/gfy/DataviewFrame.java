package gfy;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 * The frame to load the query in. Contains a table view and optionally graph
 * views.
 *
 * @author thomasbaart
 */
public class DataviewFrame extends JFrame {

  private Dimension userMonitorDim, dataviewFrameDim;

  public DataviewFrame() {
  }

  public DataviewFrame( int hashCode ) {
    userMonitorDim = Toolkit.getDefaultToolkit().getScreenSize();

    setTitle( "Info Client - " + hashCode );
    pack();

    dataviewFrameDim = getSize();

    setLocation( ( userMonitorDim.width / 2 ) - ( dataviewFrameDim.width / 2 ),
                 ( int ) ( userMonitorDim.height / 2.75 ) - ( dataviewFrameDim.height / 2 ) );
    setupTabs();
    pack();
    setSize( 400, 400 );
    setVisible( true );
  }

  private void setupTabs() {
    JTabbedPane tabbedPane = new JTabbedPane();

    JComponent panel1 = makeTextPanel( "Panel #1" );
    tabbedPane.addTab( "Tab 1", null, panel1,
                       "Does nothing" );
    tabbedPane.setMnemonicAt( 0, KeyEvent.VK_1 );

    JComponent panel2 = makeTextPanel( "Panel #2" );
    tabbedPane.addTab( "Tab 2", null, panel2,
                       "Does twice as much nothing" );
    tabbedPane.setMnemonicAt( 1, KeyEvent.VK_2 );

    JComponent panel3 = makeTextPanel( "Panel #3" );
    tabbedPane.addTab( "Tab 3", null, panel3,
                       "Still does nothing" );
    tabbedPane.setMnemonicAt( 2, KeyEvent.VK_3 );

    JComponent panel4 = makeTextPanel(
            "Panel #4 (has a preferred size of 410 x 50)." );
    panel4.setPreferredSize( new Dimension( 410, 50 ) );
    tabbedPane.addTab( "Tab 4", null, panel4,
                       "Does nothing at all" );
    tabbedPane.setMnemonicAt( 3, KeyEvent.VK_4 );

    this.add(tabbedPane);
  }

  private JPanel makeTextPanel( String text ) {
    JPanel panel = new JPanel();
    panel.add( new JLabel( text ) );
    return panel;
  }
}

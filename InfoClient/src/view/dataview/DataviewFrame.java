package view.dataview;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Thomas Baart <m.thomasbaart@gmail.com>
 */
public class DataviewFrame extends JFrame {

  private JTabbedPane tabbedPane;

  public DataviewFrame() {
    super();
    setup();
  }

  private void setup() {
    tabbedPane = new JTabbedPane();
    JPanel testPanel = new JPanel();
    JPanel testPanel2 = new JPanel();
    tabbedPane.addTab( "TestPanel", testPanel);
    tabbedPane.addTab( "TestPanel 2", testPanel2);
    add(tabbedPane);
  }

}

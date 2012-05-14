package view.dataview;

import gfy.NavQueryResultSet;
import javax.swing.*;

/**
 *
 * @author Thomas Baart <m.thomasbaart@gmail.com>
 */
public class DataviewFrame extends JFrame {

  private JTabbedPane tabbedPane;
  private NavQueryResultSet nqrs;

  public DataviewFrame(NavQueryResultSet nqrs) {
    super();
    this.nqrs = nqrs;
    setup();
    
  }

  private void setup() {
    
    JTable table = new JTable( nqrs.getRow(), nqrs.getRow());
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.add(table);
    
    tabbedPane = new JTabbedPane();
    JPanel testPanel = new JPanel();
    testPanel.add(scrollPane);
    JPanel testPanel2 = new JPanel();
    tabbedPane.addTab( "Data", testPanel);
    tabbedPane.addTab( "Grafiek", testPanel2);
    add(tabbedPane);
  }

}

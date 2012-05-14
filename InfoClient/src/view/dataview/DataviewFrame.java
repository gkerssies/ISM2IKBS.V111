package view.dataview;

import gfy.NavQueryResultSet;
import gfy.NavQuery;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author Thomas Baart <m.thomasbaart@gmail.com>
 */
public class DataviewFrame extends JFrame {

  private JTabbedPane tabbedPane;
  private NavQueryResultSet nqrs;
  private NavQuery nvq;

  public DataviewFrame(NavQueryResultSet nqrs,NavQuery nvq) {
    super();
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.nqrs = nqrs;
    this.nvq = nvq;
    setup();
    
  }

  private void setup() {
    setSize(700,500);
    this.setTitle(nvq.getTitle());
    tabbedPane = new JTabbedPane();
    
    JTable table = new JTable( nqrs.getRow(), nqrs.getColumns());
    JScrollPane scrollPane = new JScrollPane(table);
    
    
    JPanel datatable = new JPanel();
    datatable.setLayout(new FlowLayout());
    scrollPane.add(datatable);
    
    
    
    
    
    
    
    tabbedPane.addTab( "Data", scrollPane);
    tabbedPane.addTab( "Grafiek", datatable);
    add(tabbedPane);
  }

}

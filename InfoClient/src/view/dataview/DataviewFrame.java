package view.dataview;

import gfy.NavQuery;
import gfy.NavQueryResultSet;
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
    
    pack();
    setLocationRelativeTo( getRootPane() );
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
    GraphPanel gp = null;
     GraphPanel gp2 = null;
    
    if (nvq.getId() == 0)
    {
       gp = new GraphPanel(nqrs,nvq,2,1);
       gp2 = new GraphPanel(nqrs,nvq,2,2);
    }
    else
    {
      gp = new GraphPanel(nqrs,nvq,1,1);
      gp2 = new GraphPanel(nqrs,nvq,1,2);
    }
    tabbedPane.addTab( "Data", scrollPane);
    tabbedPane.addTab( "Grafiek (Staaf diagram)", gp);
    tabbedPane.addTab( "Grafiek (Taart diagram)", gp2);
    add(tabbedPane);
  }

}

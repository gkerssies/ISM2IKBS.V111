package InfoScreen;

import gfy.ClientConnection;
import gfy.serverInfo;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Janssen-laptop
 */
public class ResourcesPanel extends JPanel{
  
  protected static final ImageIcon PERFORMANCE_ICON = new ImageIcon( "./resources/images/perfomance.png" );
  
  private JProgressBar memoryBar;
  private JProgressBar memoryBarAppUsage;
  private JPanel imagePerformancePanel;
  private JPanel resultPerformancePanel;
  private JPanel systemMemoryPanel;
  private JPanel appMemoryPanel;
  private ClientConnection clientConnection;
  private serverInfo info;
  
  
  private JLabel lSystemMemory;
  private JLabel lAppMemory;
  
  public ResourcesPanel(ClientConnection clientConnection)
  {
    this.clientConnection = clientConnection;
    info = clientConnection.getInfo();
    setLayout(new BorderLayout());
    
    setMemoryBar();
    setMemoryBarAppUseage();
    
    
    setToolTipText( "Geheugen gebruik" );
    setBorder( new TitledBorder( new EtchedBorder( 1 ), "Performance" ) );
    setLayout( new BorderLayout() );
    
    this.add(setImagePanel(),BorderLayout.WEST);
    this.add(setResultPerformancePanel(),BorderLayout.EAST);
    
    resultPerformancePanel.repaint();
  }
  public JPanel setImagePanel()
  {
   
   imagePerformancePanel = new JPanel(new BorderLayout());
   imagePerformancePanel.add(new JLabel(PERFORMANCE_ICON),BorderLayout.WEST );
   return imagePerformancePanel;
  }
  
  public JPanel setResultPerformancePanel()
  {
    System.out.println(info.getMaxMemory() / 1024 + " : " + info.getFreeMemory() / 1024);
    resultPerformancePanel = new JPanel(new BorderLayout());
    resultPerformancePanel.add(setSystemMemoryPanel(),BorderLayout.NORTH);
  
    resultPerformancePanel.add(setAppMemoryPanel(),BorderLayout.CENTER);
    
    return resultPerformancePanel;
  }
  
  public JPanel setSystemMemoryPanel()
  {
    
    systemMemoryPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    lSystemMemory  = new JLabel("Systeem werkgeheugen ");
    systemMemoryPanel.add(lSystemMemory);
    systemMemoryPanel.add(setMemoryBar());
    systemMemoryPanel.repaint();
    return systemMemoryPanel;
  }
  
  public JPanel setAppMemoryPanel()
  {
    
    appMemoryPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    lAppMemory = new JLabel("CPU ");
    appMemoryPanel.add(lAppMemory);
    appMemoryPanel.add(setMemoryBarAppUseage());
    appMemoryPanel.repaint();
    return appMemoryPanel;
  }
  
  public JProgressBar setMemoryBar()
  {
    memoryBar = new JProgressBar(25,(int) info.getMaxMemory() / 1024);
    memoryBar.setValue((int) info.getFreeMemory() / 1024);
    memoryBar.setPreferredSize(new Dimension(200, 15) );
    return memoryBar;
  }
  
  public JProgressBar setMemoryBarAppUseage()
  {
    double t = info.getCpuAPP() * 1000;
    
    if (t > 0.8)
    {
      t = 100;
    }
    
    int x = (int) (double) t;
    System.out.println(info.getCpuAPP());
    memoryBarAppUsage = new JProgressBar(25,100);
    memoryBarAppUsage.setValue(25 + x);
    memoryBarAppUsage.setPreferredSize(new Dimension(200, 15) );
    return memoryBarAppUsage;
  }
  
  
}

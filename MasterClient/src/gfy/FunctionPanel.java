package gfy;

import java.util.Vector;
import javax.swing.Icon;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * Custom panel for user interface
 * @author Janssen-laptop
 */
public class FunctionPanel extends JPanel {
  
  private Vector<String> appTitle;
  private JList appList;;
  
  public FunctionPanel()
  {
    appTitle = new Vector<>();
    appTitle.add("Deel1");
    appTitle.add("Deel2");
    appList = new JList( appTitle ) ;
    this.add(appList);
  }
}

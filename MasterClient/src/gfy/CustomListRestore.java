package gfy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.*;

/**
 *
 * @author Janssen-laptop
 */
public class CustomListRestore extends JPanel {

  private JButton backupLoad;
  private JPanel loadPanel;

  public CustomListRestore() {
    
    loadPanel =  new JPanel(new FlowLayout());
    
    setToolTipText("backup inladen");
    setBorder(new TitledBorder(new EtchedBorder(1), "Bestand inladen") );
    setLayout(new BorderLayout());
    backupLoad = new JButton("Backup zoeken ...");
    loadPanel.add(backupLoad);
    
    this.add(loadPanel,BorderLayout.WEST);

  }
}

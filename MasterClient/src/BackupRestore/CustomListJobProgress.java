package BackupRestore;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.border.*;

/**
 *
 * @author Janssen-laptop
 */
public class CustomListJobProgress extends JPanel {

  private JProgressBar progress;
  private JPanel loadPanel;
  private int type;

  public CustomListJobProgress( CustomEventHandlerBackup Event, int type ) {
    this.type = type;
    loadPanel = new JPanel( new FlowLayout() );

    
    setBorder( new TitledBorder( new EtchedBorder( 1 ), "Bezig met backuppen" ) );
    setLayout( new BorderLayout() );
    progress = new JProgressBar( 50, 100 );
    progress.setPreferredSize(new Dimension(400, 20) );
    progress.setValue( 0 );
    loadPanel.add( progress );

    this.add( loadPanel, BorderLayout.WEST );

  }
  
  public void setType(int type)
  {
    this.type = type;
    if ( type == 1 ) {
      setBorder( new TitledBorder( new EtchedBorder( 1 ), "Bezig met backuppen" ) );
    } else if ( type == 2 ) {
      setBorder( new TitledBorder( new EtchedBorder( 1 ), "Bezig met herstellen van backup" ) );
    }
  }

  /**
   * @return the progress
   */
  public JProgressBar getProgress() {
    return progress;
  }
}

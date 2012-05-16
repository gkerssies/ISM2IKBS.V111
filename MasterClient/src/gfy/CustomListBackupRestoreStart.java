package gfy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Janssen-laptop
 */
public class CustomListBackupRestoreStart extends JPanel {

  private JButton startButton, cancelButton;
  private JPanel buttonPanel;
  private String type;

  public CustomListBackupRestoreStart( CustomEventHandlerBackup event ) {

    type = "";
    buttonPanel = new JPanel( new FlowLayout() );

    setBorder( new TitledBorder( new EtchedBorder( 1 ), "" ) );
    setLayout( new BorderLayout() );

    startButton = new JButton( "Start backup" );
    cancelButton = new JButton( "Stop backup" );

    event.addObject( startButton, "START" );
    event.addObject( cancelButton, "STOP" );

    //   buttonPanel.add(cancelButton);
    buttonPanel.add( startButton );

    this.add( buttonPanel, BorderLayout.EAST );
  }

  /**
   * @param type the type to set
   */
  public void setType( String type ) {
    this.type = type;
    startButton.setText("Start " + type);
  }
}

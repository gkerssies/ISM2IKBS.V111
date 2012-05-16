package gfy;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.*;

/**
 *
 * @author Janssen-laptop
 */
public class CustomListBackupOptions extends JPanel {

  private JCheckBox cbLogs, cbUsers, cbSettings, cbNavision;
  private JPanel checkboxPanel;

  public CustomListBackupOptions() {

    checkboxPanel = new JPanel( new FlowLayout() );

    setToolTipText( "backup opties" );
    setBorder( new TitledBorder( new EtchedBorder( 1 ), "Backup opties" ) );
    setLayout( new BorderLayout() );


    cbLogs = new JCheckBox( "Applicatie logs", true );
    cbUsers = new JCheckBox( "Gebruikers", true );
    cbSettings = new JCheckBox( "Instellingen", true );
    cbNavision = new JCheckBox( "Navision sql", true );

    checkboxPanel.add( cbLogs );
    checkboxPanel.add( cbUsers );
    checkboxPanel.add( cbSettings );
    checkboxPanel.add( cbNavision );
    this.add( checkboxPanel, BorderLayout.WEST );


  }

  public void disableAllCheckboxes() {
    for ( Component t : checkboxPanel.getComponents() ) {
      if ( t.getClass().getSimpleName().equals( "JCheckBox" ) ) {
        JCheckBox current = ( JCheckBox ) t;
        current.setEnabled( false );
      }
    }
  }

  public void clearAllCheckboxes() {
    for ( Component t : checkboxPanel.getComponents() ) {
      if ( t.getClass().getSimpleName().equals( "JCheckBox" ) ) {
        JCheckBox current = ( JCheckBox ) t;
        current.setSelected( false );
      }
    }
  }

  public void enableAllCheckboxes() {
    for ( Component t : checkboxPanel.getComponents() ) {
      if ( t.getClass().getSimpleName().equals( "JCheckBox" ) ) {
        JCheckBox current = ( JCheckBox ) t;
        current.setEnabled( true );
      }
    }
  }
}

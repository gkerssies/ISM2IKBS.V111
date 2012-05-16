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
public class CustomListBackupType extends JPanel {

  private JRadioButton rbRestore, rbBackup;
  private JPanel checkboxPanel;

  public CustomListBackupType( CustomEventHandlerBackup event ) {

    checkboxPanel = new JPanel( new FlowLayout() );

    setToolTipText( "Selecteer actie" );
    setBorder( new TitledBorder( new EtchedBorder( 1 ), "Backup type" ) );
    setLayout( new BorderLayout() );

    ButtonGroup myButtons = new ButtonGroup();
    rbBackup = new JRadioButton( "Een backup maken" );
    rbRestore = new JRadioButton( "een backup herstellen" );

    myButtons.add( rbBackup );
    myButtons.add( rbRestore );

    event.addObject( rbBackup, "BACKUP" );
    event.addObject( rbRestore, "RESTORE" );

    rbBackup.addActionListener( event );
    rbRestore.addActionListener( event );

    rbBackup.setSelected( true );

    checkboxPanel.add( rbBackup );
    checkboxPanel.add( rbRestore );

    this.add( checkboxPanel, BorderLayout.WEST );

  }

  /**
   * @param b the rbRestore to set
   */
  public void setRbRestoreStatus( boolean b ) {
    this.rbRestore.setSelected( b );
  }

  /**
   * @param b the rbBackup to set
   */
  public void setRbBackupStatus( boolean b ) {
    this.rbBackup.setSelected( b );
  }
}

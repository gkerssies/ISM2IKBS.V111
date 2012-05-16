package gfy;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Janssen-laptop
 */
public class BackupScreen extends JFrame {

  private JRadioButton rbSelectBackup, rbSelectRestore;
  private JTextField inputFile;
  private CustomListBackupOptions backupOptions;
  private CustomListBackupType backupType;
  private CustomListRestore restorePanel;
  private CustomEventHandlerBackup customevent;
  private CustomListBackupRestoreStart startpanel;

  public BackupScreen() {
    customevent = new CustomEventHandlerBackup( this );
    setTitle( "Backup / herstel van server" );
    setSize( 425, 275 );
    backupOptions = new CustomListBackupOptions();
    backupType = new CustomListBackupType( getCustomevent() );
    restorePanel = new CustomListRestore();
    startpanel = new CustomListBackupRestoreStart( getCustomevent() );
    setLayout( new BorderLayout() );
    add( backupOptions, BorderLayout.CENTER );
    add( backupType, BorderLayout.NORTH );
    add( startpanel, BorderLayout.SOUTH );
    pack();
    setLocationRelativeTo( getRootPane() );
    setVisible( true );
  }

  public void setRestoreGUI() {
    remove( getBackupOptions() );
    add( getRestorePanel(), BorderLayout.CENTER );
    startpanel.setType("Herstel");
    this.pack();
    repaint();
  }

  public void setBackupGUI() {
    remove( getRestorePanel() );
    add( getBackupOptions(), BorderLayout.CENTER );
    startpanel.setType("Backup");
    this.pack();
    repaint();
  }

  /**
   * @return the backupOptions
   */
  public CustomListBackupOptions getBackupOptions() {
    return backupOptions;
  }

  /**
   * @return the backupType
   */
  public CustomListBackupType getBackupType() {
    return backupType;
  }

  /**
   * @return the restorePanel
   */
  public CustomListRestore getRestorePanel() {
    return restorePanel;
  }

  /**
   * @return the customevent
   */
  public CustomEventHandlerBackup getCustomevent() {
    return customevent;
  }

  /**
   * @return the startpanel
   */
  public CustomListBackupRestoreStart getStartpanel() {
    return startpanel;
  }
}

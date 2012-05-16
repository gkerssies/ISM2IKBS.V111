package gfy;

import java.awt.BorderLayout;
import javax.swing.*;

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
  private CustomListJobProgress jobProgressPanel;
  private Timer updateProgressTimer;

  public BackupScreen() {
    customevent = new CustomEventHandlerBackup( this );
    updateProgressTimer = new Timer(100,customevent);
    
    setTitle( "Backup / herstel van server" );
    setSize( 425, 275 );
    backupOptions = new CustomListBackupOptions();
    backupType = new CustomListBackupType( getCustomevent() );
    restorePanel = new CustomListRestore();
    startpanel = new CustomListBackupRestoreStart( getCustomevent() );
    jobProgressPanel = new CustomListJobProgress(customevent,1);
    
    
    setLayout( new BorderLayout() );
    
    customevent.addObject(updateProgressTimer,"TIMER");
    
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
    jobProgressPanel.setType(1);
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
  
  public void setJOBGUI() {
    System.out.println( "test" );
    remove( restorePanel );
    remove( backupType);

   
    
    add( jobProgressPanel, BorderLayout.NORTH );
  
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

  /**
   * @return the updateProgressTimer
   */
  public Timer getUpdateProgressTimer() {
    return updateProgressTimer;
  }

  /**
   * @param updateProgressTimer the updateProgressTimer to set
   */
  public void setUpdateProgressTimer( Timer updateProgressTimer ) {
    this.updateProgressTimer = updateProgressTimer;
  }

  /**
   * @return the jobProgressPanel
   */
  public CustomListJobProgress getJobProgressPanel() {
    return jobProgressPanel;
  }
}

 

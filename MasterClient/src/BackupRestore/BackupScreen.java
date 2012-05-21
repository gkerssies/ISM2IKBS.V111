package BackupRestore;

import gfy.ClientConnection;
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
  private JFileChooser fchooser;
  private ClientConnection clientConnection;
  private int backuptype;

  public BackupScreen( ClientConnection clientConnection ) {
    this.clientConnection = clientConnection;
    backuptype = 0;
    fchooser = new JFileChooser();
    fchooser.setFileSelectionMode( JFileChooser.DIRECTORIES_ONLY );

    customevent = new CustomEventHandlerBackup( this );
    updateProgressTimer = new Timer( 100, customevent );

    setTitle( "Backup / herstel van server" );
    setSize( 425, 275 );
    backupOptions = new CustomListBackupOptions();
    backupType = new CustomListBackupType( customevent );
    restorePanel = new CustomListRestore( customevent );
    startpanel = new CustomListBackupRestoreStart( customevent );
    jobProgressPanel = new CustomListJobProgress( customevent, 1 );


    setLayout( new BorderLayout() );

    customevent.addObject( updateProgressTimer, "TIMER" );

    add( backupOptions, BorderLayout.CENTER );
    add( backupType, BorderLayout.NORTH );
    add( startpanel, BorderLayout.SOUTH );
    pack();
    setLocationRelativeTo( getRootPane() );
    setVisible( true );
  }
  
   /**
    * File directory choosers
   * @return the directory
   */
  public String chooseDirectory() {

    if ( backuptype == 0 ) {
      fchooser.showSaveDialog( this );
    } else {
      fchooser.showOpenDialog( this );
    }

    try {
      return fchooser.getSelectedFile().getAbsolutePath();
    } catch ( Exception ex ) {
      System.out.println( "IO FOUT Tijdens Selectie" );
      return null;
    }
  }

  public void setRestoreGUI() {
    remove( getBackupOptions() );
    add( getRestorePanel(), BorderLayout.CENTER );
    startpanel.setType( "Herstel" );
    jobProgressPanel.setType( 1 );
    this.pack();
    repaint();
  }

  public void setRestoreGUI2() {
    remove( getRestorePanel() );
    add( getBackupOptions(), BorderLayout.CENTER );
    startpanel.setType( "Herstel" );
    this.pack();
    repaint();
  }

  public void setBackupGUI() {
    remove( getRestorePanel() );
    add( getBackupOptions(), BorderLayout.CENTER );
    startpanel.setType( "Backup" );
    backupOptions.enableAllCheckboxes();
    backupOptions.checkAllCheckboxes();
    this.pack();
    repaint();
  }

  public void setJOBGUI() {
    System.out.println( "test" );
    remove( restorePanel );
    remove( backupType );



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

  /**
   * @return the clientConnection
   */
  public ClientConnection getClientConnection() {
    return clientConnection;
  }

  /**
   * @return the backuptype
   */
  public int getBackuptype() {
    return backuptype;
  }

  /**
   * @param backuptype the backuptype to set
   */
  public void setBackuptype( int backuptype ) {
    this.backuptype = backuptype;
  }
}

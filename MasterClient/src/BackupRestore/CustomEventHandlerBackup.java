package BackupRestore;

import gfy.IOUtililty;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Janssen-laptop
 */
public class CustomEventHandlerBackup implements ActionListener {

  private BackupWorker bw;
  private RestoreWorker rw;
  private final String radio = "Radiobutton";
  private final String checkbox = "checkbox";
  private BackupScreen backupScreen;
  private ArrayList<Object> myObjects;
  private ArrayList<String> myObjectsMarker;
  private String restoreDirectory;

  public CustomEventHandlerBackup( BackupScreen bs ) {
    this.backupScreen = bs;
    myObjects = new ArrayList<>();
    myObjectsMarker = new ArrayList<>();
  }

  public void addObject( Object o, String marker ) {
    myObjects.add( o );
    myObjectsMarker.add( marker );
  }

  @Override
  public void actionPerformed( ActionEvent e ) {
    int c = 0;
    for ( Object t : myObjects ) {
      if ( t.equals( e.getSource() ) ) {
        switch ( myObjectsMarker.get( c ) ) {
          case "RESTORE":
            backupScreen.setRestoreGUI();
            backupScreen.setBackuptype( 1 );
            break;
          case "BACKUP":
            backupScreen.setBackupGUI();
            backupScreen.setBackuptype( 0 );
            break;
          case "START":
            if ( backupScreen.getBackuptype() == 0 ) {
              String dir = backupScreen.chooseDirectory();
              if ( dir == null ) {
                
                break;
              }
              

              bw = new BackupWorker( dir,
                                     backupScreen.getClientConnection(),
                                     backupScreen.getBackupOptions().getCbLogs().isSelected(),
                                     backupScreen.getBackupOptions().getCbUsers().isSelected(),
                                     backupScreen.getBackupOptions().getCbSettings().isSelected(),
                                     backupScreen.getBackupOptions().getCbNavision().isSelected() );
              bw.start();
            } else if ( backupScreen.getBackuptype() == 1 ) {
              rw = new RestoreWorker(
                      restoreDirectory,
                      backupScreen.getClientConnection(),
                      backupScreen.getBackupOptions().getCbLogs().isSelected(),
                      backupScreen.getBackupOptions().getCbUsers().isSelected(),
                      backupScreen.getBackupOptions().getCbSettings().isSelected(),
                      backupScreen.getBackupOptions().getCbNavision().isSelected() );
              rw.start();
            }
            
            backupScreen.getBackupOptions().disableAllCheckboxes();
            backupScreen.getBackupOptions().clearAllCheckboxes();
            backupScreen.getStartpanel().getStartButton().setText( "Wachten ..." );
            backupScreen.getStartpanel().getStartButton().setEnabled( false );
            backupScreen.setJOBGUI();
            backupScreen.getUpdateProgressTimer().start();
            break;

          case "LOADBACKUP":

            String dir = backupScreen.chooseDirectory();
            restoreDirectory = dir;
            backupScreen.setRestoreGUI2();
            backupScreen.getBackupOptions().disableAllCheckboxes();
            backupScreen.getBackupOptions().clearAllCheckboxes();
            if ( IOUtililty.FileExsist( "log.txt", dir ) ) {
              backupScreen.getBackupOptions().getCbLogs().setEnabled( true );
            }
            if ( IOUtililty.FileExsist( "db.cfg", dir ) ) {
              backupScreen.getBackupOptions().getCbSettings().setEnabled( true );
            }
            if ( IOUtililty.FileExsist( "users.odb", dir ) ) {
              backupScreen.getBackupOptions().getCbUsers().setEnabled( true );
            }
            if ( IOUtililty.FileExsist( "navision.odb", dir ) ) {
              backupScreen.getBackupOptions().getCbNavision().setEnabled( true );
            }
            break;

          case "TIMER":
            if ( backupScreen.getJobProgressPanel().getProgress().getValue() == 100 ) {
              backupScreen.getUpdateProgressTimer().stop();
              backupScreen.setVisible( false );
              JOptionPane.showMessageDialog( backupScreen, "Procedure succesvol", "Melding", JOptionPane.INFORMATION_MESSAGE );
              backupScreen.dispose();
            }
            if ( backupScreen.getBackuptype() == 0 ) {
              backupScreen.getJobProgressPanel().getProgress().setValue(
                      backupScreen.getJobProgressPanel().getProgress().getValue() + 1 );
              backupScreen.getBackupOptions().getCbLogs().setSelected( bw.isjLOGDone() );
              backupScreen.getBackupOptions().getCbUsers().setSelected( bw.isjUsersDone() );
              backupScreen.getBackupOptions().getCbSettings().setSelected( bw.isjSettingsDone() );
              backupScreen.getBackupOptions().getCbNavision().setSelected( bw.isjNavisionDone() );
            } else if ( backupScreen.getBackuptype() == 1 ) {
              backupScreen.getJobProgressPanel().getProgress().setValue(
                      backupScreen.getJobProgressPanel().getProgress().getValue() + 1 );
              backupScreen.getBackupOptions().getCbLogs().setSelected( rw.isjLOGDone() );
              backupScreen.getBackupOptions().getCbUsers().setSelected( rw.isjUsersDone() );
              backupScreen.getBackupOptions().getCbSettings().setSelected( rw.isjSettingsDone() );
              backupScreen.getBackupOptions().getCbNavision().setSelected( rw.isjNavisionDone() );
            }
            break;
        }
      } else {
        c++;
      }
    }
  }
}

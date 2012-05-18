/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author Janssen-laptop
 */
public class CustomEventHandlerBackup implements ActionListener {

  private BackupWorker bw;
  private final String radio = "Radiobutton";
  private final String checkbox = "checkbox";
  private BackupScreen backupScreen;
  private ArrayList<Object> myObjects;
  private ArrayList<String> myObjectsMarker;

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
        if ( myObjectsMarker.get( c ).equals( "RESTORE" ) ) {
          backupScreen.setRestoreGUI();
          backupScreen.setBackuptype(1);
        } else if ( myObjectsMarker.get( c ).equals( "BACKUP" ) ) {
          backupScreen.setBackupGUI();
          backupScreen.setBackuptype(0);
        } else if ( myObjectsMarker.get( c ).equals( "START" ) ) {
          if(backupScreen.getBackuptype() == 0)
          {
          String dir = backupScreen.chooseDirectory();
          bw = new BackupWorker( dir,
                                              backupScreen.getClientConnection(),
                                              backupScreen.getBackupOptions().getCbLogs().isSelected(),
                                              backupScreen.getBackupOptions().getCbUsers().isSelected(),
                                              backupScreen.getBackupOptions().getCbSettings().isSelected(),
                                              backupScreen.getBackupOptions().getCbNavision().isSelected() );
          bw.start();
          }
          else if(backupScreen.getBackuptype() == 1)
          {
            
          }

          backupScreen.getBackupOptions().disableAllCheckboxes();
          backupScreen.getBackupOptions().clearAllCheckboxes();
          backupScreen.getStartpanel().getStartButton().setText( "Wachten ..." );
          backupScreen.getStartpanel().getStartButton().setEnabled( false );
          backupScreen.setJOBGUI();
          backupScreen.getUpdateProgressTimer().start();
        } else if ( myObjectsMarker.get( c ).equals( "TIMER" ) ) {
          if ( backupScreen.getJobProgressPanel().getProgress().getValue() == 100 ) {
            backupScreen.getUpdateProgressTimer().stop();
            backupScreen.setVisible( false );
            JOptionPane.showMessageDialog( backupScreen, "Procedure succesvol", "Melding", JOptionPane.INFORMATION_MESSAGE );
            backupScreen.dispose();
          }

          backupScreen.getJobProgressPanel().getProgress().setValue(
          backupScreen.getJobProgressPanel().getProgress().getValue() + 1 );
          
          backupScreen.getBackupOptions().getCbLogs().setSelected(bw.isjLOGDone());
          backupScreen.getBackupOptions().getCbUsers().setSelected(bw.isjUsersDone());
          backupScreen.getBackupOptions().getCbSettings().setSelected(bw.isjSettingsDone());
          backupScreen.getBackupOptions().getCbNavision().setSelected(bw.isjNavisionDone());
          
        }
      } else {
        c++;
      }
    }
  }
}

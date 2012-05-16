/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JRadioButton;

/**
 *
 * @author Janssen-laptop
 */
public class CustomEventHandlerBackup implements ActionListener {
  
  private final String radio = "Radiobutton";
  private final String checkbox = "checkbox";
  
  private BackupScreen backupScreen;
  private ArrayList<Object> myObjects;
  private ArrayList<String> myObjectsMarker;
  public CustomEventHandlerBackup(BackupScreen bs)
  {
    this.backupScreen = bs;
    myObjects = new ArrayList<>();
    myObjectsMarker = new ArrayList<>();
  }
  
  public void addObject(Object o,String marker)
  {
    myObjects.add( o );
    myObjectsMarker.add(marker);
  }
  
  
  @Override
  public void actionPerformed( ActionEvent e ) 
  {
    System.out.println( "here" );
    int c = 0;
    for(Object t : myObjects)
    {
      if(t.equals(e.getSource()) )
      {
       if(myObjectsMarker.get( c ).equals("RESTORE") )
       {
         backupScreen.setRestoreGUI();
       }
       if(myObjectsMarker.get( c ).equals("BACKUP") )
       {
         backupScreen.setBackupGUI();
       }
      }
      else
      {
        c++;
      }
    }
  }
  
}

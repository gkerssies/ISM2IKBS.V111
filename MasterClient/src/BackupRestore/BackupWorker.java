package BackupRestore;

import gfy.ClientConnection;
import gfy.IOUtililty;
import sun.rmi.log.ReliableLog;

/**
 * This class handles the backup in the background
 *
 * @author Janssen-laptop
 */
public class BackupWorker extends Thread {

  private boolean jLOG;
  private boolean jUsers;
  private boolean jSettings;
  private boolean jNavision;
  private boolean jLOGDone;
  private boolean jUsersDone;
  private boolean jSettingsDone;
  private boolean jNavisionDone;
  private boolean busy = true;
  private ClientConnection clientConnection;
  private String directory;

  public BackupWorker( String directory, ClientConnection clientConnection, boolean jLOG, boolean jUsers, boolean jSettings, boolean jNavision ) {
    this.clientConnection = clientConnection;

    this.jLOGDone = false;
    this.jUsersDone = false;
    this.jSettingsDone = false;
    this.jNavisionDone = false;

    this.jLOG = jLOG;
    this.jUsers = jUsers;
    this.jSettings = jSettings;
    this.jNavision = jNavision;



    this.directory = directory;
  }

  @Override
  public void run() {

    try {
      Thread.sleep( 1000 );
    } catch ( Exception ex ) {
    }

    if ( jLOG == true ) {
      jLOG = false;
      IOUtililty.writeLogFile(clientConnection.getLogView(), directory);
      jLOGDone = true;
    }

    if ( jSettings ) {
      try {
        Thread.sleep( 1000 );
      } catch ( Exception ex ) {
      }
      jSettings = false;
      IOUtililty.writeDatabaseConfig( clientConnection.getDatabase(), directory );
      jSettingsDone = true;
    }

    if ( jUsers ) {
      try {
        Thread.sleep( 2000 );
      } catch ( Exception ex ) {
      }
      jSettings = false;
      IOUtililty.writeUserDatabase( clientConnection.getUser(), directory );
      jUsersDone = true;
    }

    if ( jNavision ) {
      try {
        Thread.sleep( 150 );
      } catch ( Exception ex ) {
      }
      jNavision = false;
      IOUtililty.writeNavisionInfo( clientConnection.getNavisionQueryOverview(), directory );
      jNavisionDone = true;
    }
    
  }

  /**
   * @return the jLOGDone
   */
  public boolean isjLOGDone() {
    return jLOGDone;
  }

  /**
   * @return the jUsersDone
   */
  public boolean isjUsersDone() {
    return jUsersDone;
  }

  /**
   * @return the jSettingsDone
   */
  public boolean isjSettingsDone() {
    return jSettingsDone;
  }

  /**
   * @return the jNavisionDone
   */
  public boolean isjNavisionDone() {
    return jNavisionDone;
  }
}

package BackupRestore;

import gfy.ClientConnection;
import gfy.IOUtililty;

/**
 * This class handles the backup in the background
 *
 * @author Janssen-laptop
 */
public class RestoreWorker extends Thread {

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

  public RestoreWorker( String directory, ClientConnection clientConnection, boolean jLOG, boolean jUsers, boolean jSettings, boolean jNavision ) {
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
      jLOGDone = true;
    }

    try {
      Thread.sleep( 1000 );
    } catch ( Exception ex ) {
    }

    if ( jSettings ) {
      jSettings = false;
      clientConnection.setDatabase(IOUtililty.loadDatabaseConfig(directory));
      jSettingsDone = true;
    }

    try {
      Thread.sleep( 2000 );
    } catch ( Exception ex ) {
    }

    if ( jUsers ) {
      jSettings = false;
      clientConnection.setUser(IOUtililty.loadUserDatabase( directory ) );
      jUsersDone = true;
    }

    try {
      Thread.sleep( 150 );
    } catch ( Exception ex ) {
    }
    
    if ( jNavision ) {
      jNavision = false;
      clientConnection.setQueryOverview(IOUtililty.loadNavQueryOverview( directory ) );
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

package gfy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;

/**
 * This class is used to get all logs and serialize them for the clients
 *
 * @author Janssen-laptop
 */
public class LogView implements Serializable {

  private String CurrentLog;
  private String OldLog;

  public LogView( Log l ) {
    CurrentLog = l.toString();
    OldLog = "";
  }
  
  public LogView()
  {
    
  }

  /**
   * This method returns the old log from the file
   * @return the CurrentLog
   */
  public String loadLogfile() {
    try {
      FileReader fr = new FileReader( "./resources/logs/server-log.txt" );
      BufferedReader br = new BufferedReader( fr );
      String t = br.readLine();
      OldLog = t;
      while ( t != null ) {
        OldLog += t + "\r\n";
        t = br.readLine();
      }
      return OldLog;
    } catch ( Exception ex ) {
      return ex.getMessage();
    }
  }

  /**
   * Getter for currentLog
   * @return the CurrentLog
   */
  public String getCurrentLog() {
    return CurrentLog;
  }

  /**
   * @return the OldLog
   */
  public String getOldLog() {
    return OldLog;
  }
}

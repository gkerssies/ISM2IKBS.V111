package gfy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * The static log for the server application.
 *
 * @author Jormen Janssen
 * @author Ido Bosman (s1047979)
 * @version 0.1 - 29 april 2012
 */
public class Log {

  private static ArrayList<String> title = new ArrayList<>();
  private static ArrayList<String> exception = new ArrayList<>();
  private static ArrayList<String> description = new ArrayList<>();
  private static ArrayList<LogType> type = new ArrayList<>();

  /**
   * Adds a logitem to the static log ArrayList.
   *
   * @param title       the log title
   * @param exception   the java exeception (ex.getMessage())
   * @param description the error explained in friendly human readable text
   * @param type        the log type (Enum UserType)
   */
  public static void addItem( String title, String exception, String description, LogType type ) {
    Log.title.add( title );
    Log.exception.add( exception );
    Log.description.add( description );
    Log.type.add( type );
  }

  /**
   * method for clearing al log messages.
   */
  public static void clear() {
    Log.title.clear();
    Log.exception.clear();
    Log.description.clear();
    Log.type.clear();
  }

  /**
   * method for returning the count of messages.
   *
   * @return the count of curring messages in queue
   */
  static int getCount() {
    return Log.title.size();
  }

  /**
   * method for returning al log messages.
   *
   * @return all log items as a string
   */
  @Override
  public String toString() {
    String temp = "";
    int y = 0;

    try {
      for ( String t : title ) {
        temp += "[" + type.get( y ) + "] " + t + "<br />";
        y++;
      }
    } catch ( Exception ex ) {
      temp += "[Error] Er is een fout opgetreden tijdens het opvragen van de logs<br />";
    }

    return temp;
  }

  /**
   * Write all logs made to a file. The logs will append to the logs that
   * already exists in the file.
   *
   * @throws IOException input/output error
   */
  public static void writeToFile() throws IOException {
    // Clone the created logs to prevent error
    ArrayList<String> cTitle = ( ArrayList<String> ) title.clone();
    ArrayList<String> cException = ( ArrayList<String> ) exception.clone();
    ArrayList<String> cDescription = ( ArrayList<String> ) description.clone();
    ArrayList<LogType> cType = ( ArrayList<LogType> ) type.clone();

    // Open new writer which writes the logs to a file
    BufferedWriter writer = new BufferedWriter( new FileWriter( "./resources/logs/server-log.txt", true ) );

    // Add date and time to logs that will be written to file
    DateFormat dateFormat = new SimpleDateFormat( "dd-MM-yyyy HH:mm:ss" );
    writer.write( "@" + dateFormat.format( Calendar.getInstance().getTime() ) );
    writer.newLine();

    int y = 0;
    for ( String item : cTitle ) {
      writer.write( "[" + cType.get( y ) + "] " + item );
      writer.newLine();
      y++;
    }

    // Add whitespace between different write to file attempts
    writer.newLine();

    // Close the writer
    writer.close();
  }
}

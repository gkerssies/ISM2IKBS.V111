package gfy;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

/**
 * The static log for the server application
 *
 * @author Jormen Janssen
 * @author Ido Bosman (s1047979)
 * @version 0.1 - 29 april 2012
 */
public class Log {

  private static ArrayList<String> logitem = new ArrayList<String>();
  private static ArrayList<String> jxception = new ArrayList<String>();
  private static ArrayList<String> friendlyerror = new ArrayList<String>();
  private static ArrayList<LogType> type = new ArrayList<LogType>();

  /**
   * Adds a logitem to the static log ArrayList<>.
   *
   * @param l the log title
   * @param j the java exeception (ex.getMessage())
   * @param f the error explained in friendly human readable text
   * @param t the log type (Enum UserType)
   */
  public static void addItem( String l, String j, String f, LogType t ) {
    logitem.add( l );
    jxception.add( j );
    friendlyerror.add( f );
    type.add( t );
  }

  /**
   * method for clearing al log messages.
   */
  public static void Clear() {
    logitem.clear();
    jxception.clear();
    friendlyerror.clear();
    type.clear();
  }

  /**
   * method for returning the count of messages
   *
   * @return the count of curring messages in queue
   */
  static int getCount() {
    return logitem.size();
  }

  /**
   * method for returning al log messages
   *
   * @return all log items as a string
   */
  @Override
  public String toString() {

    int y = 0;
    String temp = "";

    try {
      for ( String t : logitem ) {
        if ( !jxception.get( y ).equals( "" ) ) {
          temp += "[" + type.get( y ) + "] " + t + "<br />";
        } else {
          temp += "[" + type.get( y ) + "] " + t + "<br />";
        }
        // temp += "[" + type.get( y ) + "] " + t + "; " + jxception.get( y ) + "; " + friendlyerror.get( y ) + "<br />";
        y++;
      }
    } catch ( ConcurrentModificationException ex ) {
      temp += "[Error] Er is een fout opgetreden tijdens het opvragen van de logs<br />";
    }

    return temp;
  }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;
import java.util.ArrayList;

/**
 * The static log for the server application
 * 
 * @author Jormen Janssen
 * @version 0.1 - 29 april 2012
 */
public class Log {
  
  private static ArrayList<String> logitem = new ArrayList<String>();
  private static ArrayList<String> jxception = new ArrayList<String>();
  private static ArrayList<String> friendlyerror = new ArrayList<String>();
  private static ArrayList<LogType> type = new ArrayList<LogType>();
  
   /**
    * Adds a logitem to the static log ArrayList<>.
   * @param l the log title
   * @param j the java exeception (ex.getMessage())
   * @param f the error explained in friendly human readable text
   * @param t the log type (Enum UserType)
   */
  public static void addItem(String l,String j,String f,LogType t)
  {
    logitem.add(l);
    jxception.add(j);
    friendlyerror.add(f);
    type.add(t);
  }
  @Override
  public String toString()
  {
    int y =0;
    String temp = "";
    for(String t : logitem)
    {
      temp += t + " " + jxception.get(y) + " " + friendlyerror.get( y ) + " " + type;
      y++;
    }
    return temp;
  }
  
  
}

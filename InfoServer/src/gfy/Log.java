/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;
import java.util.ArrayList;

/**
 *
 * @author Jormen Janssen
 * @version 0.1 - 26 april 2012
 */
public class Log {
  
  private static ArrayList<String> logitem = new ArrayList<String>();
  private static ArrayList<String> jxception = new ArrayList<String>();
  private static ArrayList<String> friendlyerror = new ArrayList<String>();
  private static ArrayList<LogType> type = new ArrayList<LogType>();
  
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
    String temp = "";
    for(String t : logitem)
    {
      temp += t;
    }
    return temp;
  }
  
  
}

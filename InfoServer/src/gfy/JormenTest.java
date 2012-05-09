/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Janssen-laptop
 */
public class JormenTest 
{
  public static void main( String[] args ) {
    
    System.out.println( "begin" );
    Database dbSettings = IOUtillty.loadDatabaseConfig();
    System.out.println(dbSettings.toString());
    
   
  }
}

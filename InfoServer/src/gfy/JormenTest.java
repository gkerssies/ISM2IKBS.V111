/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

/**
 *
 * @author Janssen-laptop
 */
public class JormenTest 
{
  public static void main( String[] args ) {
    
    System.out.println( "begin" );
   // Database dbSettings = IOUtillty.loadDatabaseConfig();
    User test = new User();
    test.addUser("aap", "test", UserType.gebruiker);
    IOUtillty.writeUserDatabase( test );
    User testje2 = IOUtillty.loadUserDatabase();
    System.out.println(testje2.toString());
   
  }
}

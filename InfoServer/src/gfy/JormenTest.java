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
    
    User myUser = new User();
    Database dbSettings = new Database("Navision", "SQLSERVER", 11000,"Gebruikersnaam", "Password");
    Config config = new Config(4444, dbSettings, myUser);
    

    
    
    myUser.addUser("Admin","1234", UserType.gebruiker);
    myUser.addUser("IDO","12345566666", UserType.gebruiker);
    myUser.addUser("Gerjan","test", UserType.gebruiker);
    myUser.addUser("aap","test", UserType.gebruiker);
    myUser.setUser("IDO","Flapdrop", UserType.beheerder);
    System.out.println(myUser.removeUser("aap") );
    
    System.out.println(config.getDatabase());
    System.out.println(config.getUserdatabase());
    Server myServer = new Server(config);
    myServer.start();
    
    ClientProperty c = new ClientProperty();
    c.setLoggedin( true,"Jormen",UserType.gebruiker);
    System.out.println(c.isUserType(UserType.gebruiker) );
    
    while(true)
    {
      try {
        Thread.sleep(1000);
      } catch ( InterruptedException ex ) {
        
      }
      if(Log.getCount() != 0)
      {
       System.out.println(new Log());
       Log.Clear();
      }
    }
    
   
  }
}

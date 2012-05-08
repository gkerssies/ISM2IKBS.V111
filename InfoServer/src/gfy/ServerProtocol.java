/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Janssen-laptop
 * @version 0.2 - 08-m
 */
public class ServerProtocol extends Protocol 
{
  @Override
  public String getProtocol()
  {
  
    return "Server";
  }
  
  /**
   * this method overides the proccescommand and parses the commands being sent.
   */
  @Override
  public void proccesCommand()
  {
      String t = "";
      t = super.recieveCommand();
      if(t.equals("AUTH") )
      {
        super.setBusy(true);
        authenticate();
      }
      else if (t.equals("CLOSE") )
      {
      
        super.unbindStreams();
      
      
      }
      else
      {
        System.out.println(t);
      }
              
  }
  /**
   * this is method for the authetication
   */
  public void authenticate()
  {
    Auth clientAuth = (Auth) super.recieveObject();
    User user = super.getServer().getConfig().getUserdatabase();
    if (user.verifyCredential(clientAuth.getUsername(), clientAuth.getPassword()))
    {
      Log.addItem("Client login succesvol @ " + super.getServer().getServerSocket().getInetAddress() , "", "", LogType.Event);
    }
    else
    {
      Log.addItem("Client login failed", "", "", LogType.Event);
    }
    super.setBusy(false);
  }
}

  

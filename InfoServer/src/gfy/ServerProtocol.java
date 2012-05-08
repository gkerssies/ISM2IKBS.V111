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
 */
public class ServerProtocol extends Protocol 
{
  @Override
  public String getProtocol()
  {
  
    return "Server";
  }

  @Override
  public void proccesCommand()
  {
      String t = "";
      t = super.recieveCommand();
      if (t.equals("AUTH") )
      {
        authenticate();
      }
      else
      {
        System.out.println(t);
      }
              
  }
  
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
  }
}

  

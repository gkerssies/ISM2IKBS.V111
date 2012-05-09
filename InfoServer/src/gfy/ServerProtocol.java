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
  Client client;
  @Override
  public String getProtocol()
  {
  
    return "Server";
  }
  public ServerProtocol(Client client)
  {
    this.client = client;
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
        super.setBusy(true);
        client.forceStop();
      }
      else if (t.equals("GET-USERS") )
      {
        System.out.println( "fase 2" );
        super.setBusy(true);
        getUsers();
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
      Log.addItem("Client login succesvol @ " + super.getSocket().getInetAddress() , "", "", LogType.Event);
      super.getClientproperty().setLoggedin( true, clientAuth.getUsername(), clientAuth.getUsertype() );
      sendCommand("OK");
    }
    else
    {
      Log.addItem("Client login failed", "", "", LogType.Event);
    }
    super.setBusy(false);
  }
  
  public void getUsers()
  {
        super.sendCommand("OK");
        //super.sendObject(super.getServer().getConfig().getUserdatabase());
        super.setBusy(false);
  }
}

  

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

/**
 * The client protocol class extends the protocol classs
 * @author Janssen-laptop
 */
public class ClientProtocol extends Protocol{
  
  
  @Override
  public String getProtocol() {
    return "Client";
  }

  @Override
  public void proccesCommand() {
    
    if(super.recieveCommand().equals("UPDATE"))
    {
      System.out.println( "works" );
    }
  }
  public User getUsers()
  {
    super.setBusy(true);
    super.sendCommand("GET-USERS");
    if (super.recieveCommand().equals("OK") )
    {
      return (User) super.recieveObject();
    }
    else
    {
      return null;
    }
  }
  
  
  
}

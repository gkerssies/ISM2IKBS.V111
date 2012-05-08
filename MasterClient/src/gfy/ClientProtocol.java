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
    System.out.println( "fase1" );
    super.setBusy(true);
    System.out.println( "fase2" );
    super.sendCommand("GET-USERS");
    System.out.println( "faerererse3" );
    if (super.recieveCommand().equals("OK") )
    {
      System.out.println( "fase4" );
      super.setBusy(false);
      return (User) super.recieveObject();
    }
    else
    {
      System.out.println( "failed" );
      return null;
    }
  }
  
  
  
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jormen Janssen
 * @version 0.1 - 29 april 2012
 */
public abstract class Protocol 
{
   private PrintWriter commandlineout;
   private ObjectOutputStream objectlineout;
   private BufferedReader commandlinein;
   private ObjectInputStream objectlinein;
   private Socket socket;
   private Server server;
  
  public abstract String getProtocol();
  public abstract void proccesCommand();
  
  public String recieveCommand()
  {
    try
    {
    String t;
    t = commandlinein.readLine();
    
    
    String[] strings = t.split(">");
    t = strings[0];
    return t;
    }
    catch(Exception ex)
    {
      System.out.println();
      return null;
    }
    
  }
  public Object recieveObject()
  {
    try
    {
      Object t = objectlinein.readObject();
    return t;
    }
    catch(Exception ex)
    {
      System.out.println( "geen object verbinding" + ex.getMessage());
      return null;
    }
  }
  public void sendCommand(String text)
  {
    String strings[] = text.split(">");
    text = strings[0];
    commandlineout.println(text);
    commandlineout.flush();
  }
  public void sendObject(Object o)
  {
    try{
       objectlineout.writeObject(o);
    } 
    catch ( IOException ex ) {
      Logger.getLogger( Protocol.class.getName() ).log( Level.SEVERE, null, ex );
    }
  }
  
  public boolean reqruireCommand()
  {
    return true;
  }
 
  public boolean bindStreams(Socket clientSocket)
  {
    socket = clientSocket;
    boolean bind = true;
    try
    {
      commandlinein = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
      commandlineout = new PrintWriter(getSocket().getOutputStream(),true);
      objectlineout = new ObjectOutputStream(getSocket().getOutputStream());
      objectlinein = new ObjectInputStream(getSocket().getInputStream());
       
    }
    catch(IOException ex)
    {
      System.out.println(ex.getMessage());
      bind = false;
    }
    catch(Exception ex)
    {
      System.out.println( "dikke fail" );
    }
            
    finally
    {
      return bind;
    }
  }

  /**
   * @return the server
   */
  public Server getServer() {
    return server;
  }

  /**
   * @param server the server to set
   */
  public void setServer( Server server ) {
    this.server = server;
  }

  /**
   * @return the socket
   */
  public Socket getSocket() {
    return socket;
  }
  
  
}

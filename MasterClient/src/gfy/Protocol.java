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
 * Protocol base class
 * @author Jormen Janssen
 * @version 0.2 - 8 mei 2012
 */
public abstract class Protocol 
{
   
   private ObjectOutputStream objectlineout;
   private ObjectInputStream objectlinein;
   private boolean busy = false;
   private InputStream is;
   private OutputStream os;
  
  public abstract String getProtocol();
  public abstract void proccesCommand();
  
  /**
 * Method for recieving a command
 * @return the command as an string
 */
  public String recieveCommand()
  {
    String t = "CLOSE";
    try
    {
    
    t = objectlinein.readUTF();
    String[] strings = t.split(">");
    t = strings[0];
    return t;
    }
    catch(UTFDataFormatException fault)
    {
      System.out.println( "formaat fout" );
      return t;
    }
    catch(Exception ex)
    {
      
      System.out.println( "Fout tijdens het lezen " + ex.getMessage());
      return t;
    }
    
  }
  
  /**
   * Method for recieving an object to a client
   * @return the object which is recieved through a socket
   */
  public Object recieveObject()
  {
    try
    {
      Object t = objectlinein.readObject();
    return t;
    }
    catch(IOException ex)
    {
      System.out.println( "Fout tijdens het lezen van een object" + ex.getMessage() );
      return null;
    }
    catch(ClassNotFoundException ex)
    {
      System.out.println("Het gestuurde object wordt niet ontvangen" );
      return null;
    }
  }
  public void sendCommand(String text)
  {
    try {
      String strings[] = text.split(">");
      text = strings[0];
      objectlineout.writeUTF(text);
      objectlineout.flush();
    } catch ( IOException ex ) 
    {
      System.out.println( "fout tijdens verzenden" );
    }
  }
  
  /**
   * Method for sending an object to a client
   * @param object the sending object
   */
  public void sendObject(Object o)
  {
    try{
       objectlineout.writeObject(o);
    } 
    catch ( IOException ex ) {
      
    }
  }
  
  public boolean reqruireCommand()
  {
    return true;
  }
  /**
   * Method for disconnecting an stream.
   *
   */
  public void unbindStreams()
  {
    try
    {
    objectlinein.close();
    objectlineout.close();
    }
    catch(Exception ex)
    {
      System.out.println( "Fout tijdens het verbreken van de verbinding" + ex.getMessage() );
    }
  }
  
  /**
   * 
   * @return status the status of the streams if the stream is succesfully connected
   */
  public boolean bindStreams(Socket clientSocket)
  {
    boolean bind = true;
    try
    {
      objectlineout = new ObjectOutputStream(clientSocket.getOutputStream());
      objectlinein = new ObjectInputStream(clientSocket.getInputStream());
       
    }
    catch(IOException ex)
    {
      System.out.println("Fout tijdens het koppelen van de verbinding" + ex.getMessage());
      bind = false;
    }
    catch(Exception ex)
    {
      System.out.println( "Fout tijdens het koppelen van de verbinding" + ex.getMessage());
    }
            
    finally
    {
      return bind;
    }
  }



  /**
   * @return the busy
   */
  public boolean isBusy() {
    return busy;
  }

  /**
   * @param busy the busy to set
   */
  public void setBusy( boolean busy ) {
    this.busy = busy;
  }




  
  
}

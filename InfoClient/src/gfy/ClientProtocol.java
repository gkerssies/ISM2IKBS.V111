/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

/**
 * The client protocol class extends the protocol classs
 *
 * @author Janssen-laptop
 */
public class ClientProtocol extends Protocol {

  @Override
  public String getProtocol() {
    return "Client";
  }

  public void processCommand() {
    String t = super.recieveCommand();
    System.out.println( t );
    if ( t.equals( "UPDATE" ) ) {
      System.out.println( "works" );
    } else {
      System.out.println( t );
    }
  }
}

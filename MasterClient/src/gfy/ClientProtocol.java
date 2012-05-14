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

  @Override
  public void proccesCommand() {
    String t = super.recieveCommand();
    System.out.println( t );
    if ( t.equals( "UPDATE" ) ) {
      System.out.println( "works" );
    } else {
      System.out.println( t );
    }
  }

  public User getUsers() {
    System.out.println( "fase1" );
    super.setBusy( true );
    super.sendCommand( "GET-USERS" );
    System.out.println( super.recieveCommand() );
    //if (super.recieveCommand().equals("OK") )
    //{
    // System.out.println( "fase4" );
    // super.setBusy(false);
    return new User();
    // return (User) super.recieveObject();
    //}
    //else
    //{
    // System.out.println( "failed" );
    //  return null;
    //}
  }
}

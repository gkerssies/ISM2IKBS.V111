/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

/**
 * The server protocol class which handles the communication and exchange of
 * various commands and objects
 *
 * @author Janssen-laptop
 * @version 0.2 - 08-m
 */
public class ServerProtocol extends Protocol {

  Client client;

  @Override
  public String getProtocol() {

    return "Server";
  }

  public ServerProtocol( Client client ) {
    this.client = client;
  }

  /**
   * this method overides the proccescommand and parses the commands being sent.
   */
  @Override
  public void proccesCommand() {
    String t = "";
    t = super.recieveCommand();
    if ( t.equals( "AUTH" ) ) {
      super.setBusy( true );
      authenticate();
    } else if ( t.equals( "CLOSE" ) ) {
      super.setBusy( true );
      client.forceStop();
    } else if ( t.equals( "STOP" ) ) {
      super.setBusy( true );
      super.getServer().stopServer();
      System.exit( 0 );
    } else if ( t.equals( "GET-USERS" ) ) {
      super.setBusy( true );
      getUsers();
    } else if ( t.equals( "GET-DATABASE" ) ) {
      super.setBusy( true );
      getDatabase();
    } else if ( t.equals( "SET-DATABASE" ) ) {
      super.setBusy( true );
      setDatbase();

    } else if ( t.equals( "SET-USERS" ) ) {
      super.setBusy( true );
      setUser();
    } else {
      System.out.println( t );
    }

  }

  /**
   * this is method for the authetication
   */
  public void authenticate() {
    Auth clientAuth = ( Auth ) super.recieveObject();
    User user = super.getServer().getConfig().getUserdatabase();
    if ( user.verifyCredential( clientAuth.getUsername(), clientAuth.getPassword() ) ) {
      super.getClientproperty().setLoggedin( true, clientAuth.getUsername(), clientAuth.getUsertype() );
      sendCommand( "OK" );
      Log.addItem( "Client login succesvol [" + super.getClientproperty().getUsername() + "] @ [" + super.getSocket().getInetAddress().getHostAddress() + "]", "", "", LogType.Event );
    } else {
      sendCommand( "ERROR" );
      Log.addItem( "Client login mislukt [Authenticatie fout] @ [" + super.getSocket().getInetAddress().getHostAddress() + "]", "", "", LogType.Event );
    }
    super.setBusy( false );
  }

  public void getUsers() {
    super.sendCommand( "OK" );
    super.sendObject( super.getServer().getConfig().getUserdatabase() );
    super.setBusy( false );
    Log.addItem( "Transactie succesvol [Gebuikers] [" + super.getClientproperty().getUsername() + "]", "", "", LogType.Transaction );
  }

  public void getDatabase() {
    super.sendCommand( "OK" );
    super.sendObject( super.getServer().getConfig().getDatabase() );
    super.setBusy( false );
    Log.addItem( "Transactie succesvol [Nav Instellingen opvragen] [" + super.getClientproperty().getUsername() + "]", "", "", LogType.Transaction );
  }

  public void setDatbase() {
    Database database = ( Database ) super.recieveObject();
    super.getServer().getConfig().setDatabase( database );
    super.setBusy( false );
    Log.addItem( "Transactie succesvol [Nav Instellingen bijwerken] [" + super.getClientproperty().getUsername() + "]", "", "", LogType.Transaction );
    IOUtillty.writeDatabaseConfig( database );
  }
  
  public void setUser() {
    User userdb = ( User ) super.recieveObject();
    super.getServer().getConfig().setUserdatabase( userdb );
    super.setBusy( false );
    Log.addItem( "Transactie succesvol [Nav Instellingen bijwerken] [" + super.getClientproperty().getUsername() + "]", "", "", LogType.Transaction );
    IOUtillty.writeUserDatabase( userdb );
  }
  
  
}

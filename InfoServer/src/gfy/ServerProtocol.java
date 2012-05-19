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
    switch ( t ) {
      case "AUTH":
        super.setBusy( true );
        authenticate();
        break;
      case "CLOSE":
        super.setBusy( true );
        client.forceStop();
        break;
      case "STOP":
        super.setBusy( true );
        super.getServer().stopServer();
        System.exit( 0 );
        break;
      case "GET-USERS":
        super.setBusy( true );
        getUsers();
        break;
      case "GET-DATABASE":
        super.setBusy( true );
        getDatabase();
        break;
      case "SET-DATABASE":
        super.setBusy( true );
        setDatbase();
        break;
      case "GET-NAV-OVERVIEW":
        super.setBusy( true );
        getNavOverview();
        break;
      case "GET-NAV-RESULT":
        super.setBusy( true );
        getNavResult();
        break;
      case "SET-USERS":
        super.setBusy( true );
        setUser();
        break;
      case "GET-LOGS":
        super.setBusy( true );
        getLog();
        break;
      case "SET-NAV-OVERVIEW":
        super.setBusy( true );
        setNavQueryOverview();
        break;
      case "GET-INFO":
        super.setBusy( true );
        sendInfo();
        break;
      default:
        System.out.println( t );
        break;
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
    Log.addItem( "Transactie succesvol [Gebruikers] [" + super.getClientproperty().getUsername() + "]", "", "", LogType.Transaction );
  }

  public void getNavOverview() {
    super.sendCommand( "OK" );
    super.sendObject( super.getServer().getConfig().getNavqueryoverview() );
    super.setBusy( false );
    Log.addItem( "Transactie succesvol [Navision query overzicht] [" + super.getClientproperty().getUsername() + "]", "", "", LogType.Transaction );
  }

  public void getNavResult() {

    int t = Integer.parseInt( super.recieveCommand() );
    boolean match = false;
    for ( NavQuery nq : super.getServer().getConfig().getNavqueryoverview().getNavQueries() ) {
      if ( nq.getId() == t ) {
        match = true;
        super.sendCommand( "OK" );
        DatabaseUtility db = new DatabaseUtility( super.getServer().getConfig().getDatabase() );
        db.setQuery( nq.getSqlquery() );
        NavQueryResultSet nvrs = new NavQueryResultSet( db.getDataFromSql(), db.getMetaDataFromSql() );
        super.sendObject( nvrs );
        db.close();
      }
    }
    // System.out.println( match );
    //super.sendObject( super.getServer().getConfig().getNavqueryoverview());

    super.setBusy( false );
    Log.addItem( "Transactie succesvol [Navision query resultaat] [" + super.getClientproperty().getUsername() + "]", "", "", LogType.Transaction );
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
    IOUtililty.writeDatabaseConfig( database );
  }

  public void setUser() {
    User userdb = ( User ) super.recieveObject();
    super.getServer().getConfig().setUserdatabase( userdb );
    super.setBusy( false );
    Log.addItem( "Transactie succesvol [Gebruikers bijwerken] [" + super.getClientproperty().getUsername() + "]", "", "", LogType.Transaction );
    IOUtililty.writeUserDatabase( userdb );
  }

  public void setNavQueryOverview() {
    NavQueryOverview nqo = ( NavQueryOverview ) super.recieveObject();
    super.getServer().getConfig().setNavqueryoverview( nqo );
    super.setBusy( false );
    Log.addItem( "Transactie succesvol [Navision info bijwerken] [" + super.getClientproperty().getUsername() + "]", "", "", LogType.Transaction );
    IOUtililty.writeNavisionInfo( nqo );
  }

  public void getLog() {
    LogView lview = new LogView();
    lview.loadLogfile();
    super.sendObject( lview );
    super.setBusy( false );
    Log.addItem( "Transactie succesvol [Log inlezen] [" + super.getClientproperty().getUsername() + "]", "", "", LogType.Transaction );

  }
  
   public void sendInfo() {
     serverInfo srv = new serverInfo();
     srv.getInfo();
    super.sendObject( srv);
    super.setBusy( false );
    Log.addItem( "Transactie succesvol [Server Info opvragen] [" + super.getClientproperty().getUsername() + "]", "", "", LogType.Transaction );
  }
  
}

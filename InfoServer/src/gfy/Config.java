package gfy;

/**
 * Config class for the server configuration holds : Global settings, Navison
 * Settings and the user database.
 *
 * @author Jormen Janssen
 * @version 0.1 - 26 april 2012
 */
public class Config {

  private int serverport;
  private Database database;
  private User userdatabase;
  private NavQueryOverview navqueryoverview;

  /**
   * Constructor for the config class
   *
   * @param serverport   the tcp port number for the TCP/IP server
   * @param database     the database settings for the config
   * @param userdatabase the memory based userdatabase
   */
  public Config( int serverport, Database database, User userdatabase,NavQueryOverview nqo) {
    this.serverport = serverport;
    this.database = database;
    this.userdatabase = userdatabase;
    this.navqueryoverview = nqo;
  }

  /**
   * @return the serverport
   */
  public int getServerport() {
    return serverport;
  }

  /**
   * @param serverport the serverport to set
   */
  public void setServerport( int serverport ) {
    Log.addItem( "Server poort veranderd (" + this.serverport + " > " + serverport + ")", "", "", LogType.Event );
    this.serverport = serverport;
  }

  /**
   * @return the database
   */
  public Database getDatabase() {
    return database;
  }

  /**
   * @return the userdatabase
   */
  public User getUserdatabase() {
    return userdatabase;
  }

  /**
   * @param database the database settings to set
   */
  public void setDatabase( Database database ) {
    this.database = database;
  }

  /**
   * @param userdatabase the userdatabase to set
   */
  public void setUserdatabase( User userdatabase ) {
    this.userdatabase = userdatabase;
  }

  /**
   * @return the navqueryoverview
   */
  public NavQueryOverview getNavqueryoverview() {
    return navqueryoverview;
  }

  /**
   * @param navqueryoverview the navqueryoverview to set
   */
  public void setNavqueryoverview( NavQueryOverview navqueryoverview ) {
    this.navqueryoverview = navqueryoverview;
  }
  
  /**
   * Check os version
   * @return if the os is windows or mac
   */
   public static int checkWinMac(){
        String os   = System.getProperty("os.name");
        
        if(os.startsWith("Win", 0)){
            return 1;
        } else if(os.startsWith("Mac", 0)){
            return 2;
        } else{
            return 0;
        }
    }
  
}

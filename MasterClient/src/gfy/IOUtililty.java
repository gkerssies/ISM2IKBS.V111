package gfy;

import java.io.*;

/**
 * Utility IO Class for loading, saving and other IO functionality.
 *
 * @author Janssen-laptop
 * @version 0.1 - 9 mei 2012
 */
public class IOUtililty {

  /**
   * Write the database settings to ./config/db.cfg.
   *
   * @param database the database to write
   */
  public static void writeDatabaseConfig( Database database, String location ) {
    try {
      FileWriter fw = new FileWriter( location + "/db.cfg" );
      PrintWriter pw = new PrintWriter( fw );
      pw.println( "[Databaseconfig]" );
      pw.println( "name:" + database.getName() );
      pw.println( "host:" + database.getHost() );
      pw.println( "port:" + database.getPort() );
      pw.println( "username:" + database.getUsername() );
      pw.println( "password:" + database.getPassword() );
      pw.close();
      fw.close();
    } catch ( IOException ioe ) {
    }
  }

  /**
   * Write the database settings to ./config/db.cfg.
   *
   * @param WriteLogFile the logfile to write
   */
  public static void writeLogFile( LogView lview, String location ) {
    try {
      FileWriter fw = new FileWriter( location + "/log.txt" );
      PrintWriter pw = new PrintWriter( fw );
      pw.println( lview.getOldLog() + "\r\n" + lview.getCurrentLog() );
      pw.close();
      fw.close();
    } catch ( IOException ioe ) {
    }
  }

  /**
   * Write the port configuration settings to ./config/port.cfg.
   *
   * @param serverPort the portnumber that is given to the server
   */
  public static void writePortConfig( int serverPort ) {
    try {
      FileWriter fw = new FileWriter( "./resources/config/port.cfg" );
      PrintWriter pw = new PrintWriter( fw );
      pw.println( "[Globalconfig]" );
      pw.println( "port:" + serverPort );
      pw.close();
      fw.close();
    } catch ( IOException ioe ) {
    }
  }

  /**
   * Check if there is a port configuration file already.
   *
   * @return boolean gives true if the port configuration file exsist
   */
  public static boolean portConfigExsist() {
    File file = new File( "./resources/config/port.cfg" );
    return file.exists();
  }

  /**
   * Load the port settings from ./config/port.cfg.
   *
   * @return the server portnumber
   */
  public static int loadPortConfig() {
    int port = 0;

    try {
      FileReader fr = new FileReader( "./resources/config/port.cfg" );
      BufferedReader br = new BufferedReader( fr );
      String t = br.readLine();
      while ( t != null ) {
        if ( !t.startsWith( "[" ) ) {
          String[] c = getKeyValue( t );

          switch ( c[0] ) {
            case "port":
              port = Integer.parseInt( c[1] );
              break;
          }

        }
        t = br.readLine();
      }

      // If portnumber is out of range, reset it to prevent error later
      if ( port > 1024 && port < 49151 ) {
        return port;
      } else {


        // Write portnumber '0' to file (portnumber reset)
        writePortConfig( 0 );

        return 0;
      }

    } catch ( Exception ex ) {

      // Write portnumber '0' to file (portnumber reset)
      writePortConfig( 0 );

      return 0;
    }
  }

  /**
   * Check if there is a database already.
   *
   * @return boolean gives true if the database config exsist
   */
  public static boolean databaseConfigExsist() {
    File file = new File( "./resources/config/db.cfg" );
    return file.exists();
  }

  /**
   * Check if a file exsists
   *
   * @param file the file
   * @param location the directory
   * @return boolean gives true if the file exsist
   */
  public static boolean FileExsist(String f,String location) {
    File file = new File( location + "/" + f );
    return file.exists();
  }

  /**
   * Check if there is a user database already.
   *
   * @return boolean gives true if the user databaseexsist
   */
  public static boolean userDatabaseExsist() {
    File file = new File( "./resources/config/users.odb" );
    return file.exists();
  }

  /**
   * Load all database settings from ./config/db.cfg.
   *
   * @return Database the new databaseconfig
   */
  public static Database loadDatabaseConfig() {
    String name = "";
    String host = "";
    int port = 0;
    String username = "";
    String password = "";
    try {
      FileReader fr = new FileReader( "./resources/config/db.cfg" );
      BufferedReader br = new BufferedReader( fr );
      String t = br.readLine();
      while ( t != null ) {
        if ( !t.startsWith( "[" ) ) {
          String[] c = getKeyValue( t );

          switch ( c[0] ) {
            case "name":
              name = c[1];
              break;
            case "host":
              host = c[1];
              break;
            case "port":
              port = Integer.parseInt( c[1] );
              break;
            case "username":
              username = c[1];
              break;
            case "password":
              password = c[1];
              break;
          }

        }
        t = br.readLine();
      }
      return new Database( name, host, port, username, password );

    } catch ( Exception ex ) {

      return new Database( "Navision", "SQLSEVER", 0, "", "" );
    }
  }
  
  /**
   * Load all database settings from a config
   * @param the directory
   * @return Database the new databaseconfig
   */
  public static Database loadDatabaseConfig(String location) {
    String name = "";
    String host = "";
    int port = 0;
    String username = "";
    String password = "";
    try {
      FileReader fr = new FileReader(location + "/db.cfg" );
      BufferedReader br = new BufferedReader( fr );
      String t = br.readLine();
      while ( t != null ) {
        if ( !t.startsWith( "[" ) ) {
          String[] c = getKeyValue( t );

          switch ( c[0] ) {
            case "name":
              name = c[1];
              break;
            case "host":
              host = c[1];
              break;
            case "port":
              port = Integer.parseInt( c[1] );
              break;
            case "username":
              username = c[1];
              break;
            case "password":
              password = c[1];
              break;
          }

        }
        t = br.readLine();
      }
      return new Database( name, host, port, username, password );

    } catch ( Exception ex ) {

      return new Database( "Navision", "SQLSEVER", 0, "", "" );
    }
  }

  
  /**
   * split a string in two parts by key and value.
   *
   * @return string[] the first [0] is the key [1] is the value
   */
  public static String[] getKeyValue( String value ) {
    String[] t = new String[ 5 ];
    t = value.split( ":" );
    return t;
  }

  public static void writeUserDatabase( User user, String directory ) {
    try {
      System.out.println( directory + "/users.odb" );
      FileOutputStream fo = new FileOutputStream( directory + "/users.odb" );
      ObjectOutputStream oos = new ObjectOutputStream( fo );
      oos.writeObject( user );
      oos.close();
      fo.close();
    } catch ( Exception ex ) {
      System.out.println( ex.getMessage() );
    }
  }

  public static void writeNavisionInfo( NavQueryOverview nav, String directory ) {
    try {
      System.out.println( directory + "/navision.odb" );
      FileOutputStream fo = new FileOutputStream( directory + "/navision.odb" );
      ObjectOutputStream oos = new ObjectOutputStream( fo );
      oos.writeObject( nav );
      oos.close();
      fo.close();
    } catch ( Exception ex ) {
      System.out.println( ex.getMessage() );
    }
  }

  public static User loadUserDatabase() {
    try {
      FileInputStream fi = new FileInputStream( "./resources/config/users.odb" );
      ObjectInputStream ois = new ObjectInputStream( fi );
      User loaduser = ( User ) ois.readObject();
      ois.close();
      fi.close();
      return loaduser;
    } catch ( Exception ex ) {

      User tempuser = new User();
      tempuser.addUser( "admin", "admin", UserType.gebruiker );
      return tempuser;
    }
  }


 public static User loadUserDatabase(String location) {
    try {
      FileInputStream fi = new FileInputStream(location + "/users.odb" );
      ObjectInputStream ois = new ObjectInputStream( fi );
      User loaduser = ( User ) ois.readObject();
      ois.close();
      fi.close();
      return loaduser;
    } catch ( Exception ex ) {

      User tempuser = new User();
      tempuser.addUser( "admin", "admin", UserType.gebruiker );
      return tempuser;
    }
  }
}

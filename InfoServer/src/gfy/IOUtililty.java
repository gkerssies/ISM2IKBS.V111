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
  public static void writeDatabaseConfig( Database database ) {
    try {
      FileWriter fw = new FileWriter( "./resources/config/db.cfg" );
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
      Log.addItem( "Fout tijdens opslaan [Database Configuratie]", ioe.getMessage(), "", LogType.Error );
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
      Log.addItem( "Fout tijdens opslaan [Globale Configuratie]", ioe.getMessage(), "", LogType.Error );
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
        Log.addItem( "Poort configuratie [corrupt]", "", "", LogType.Error );
        Log.addItem( "Poort configuratie [reset]", "", "", LogType.Event );

        // Write portnumber '0' to file (portnumber reset)
        writePortConfig( 0 );

        return 0;
      }

    } catch ( Exception ex ) {
      Log.addItem( "Poort configuratie [corrupt]", ex.getMessage(), "", LogType.Error );
      Log.addItem( "Poort configuratie [reset]", "", "", LogType.Event );

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
   * Check if there is a user database already.
   *
   * @return boolean gives true if the user databaseexsist
   */
  public static boolean userDatabaseExsist() {
    File file = new File( "./resources/config/users.odb" );
    return file.exists();
  }

  /**
   * Check if Navison info exsist.
   *
   * @return boolean gives true if the navision info is availible
   */
  public static boolean navInfoExsist() {
    File file = new File( "./resources/config/navision.odb" );
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
      br.close();
      fr.close();
      return new Database( name, host, port, username, password );

    } catch ( Exception ex ) {
      Log.addItem( "Datbase configuratie [corrupt]", ex.getMessage(), "", LogType.Error );
      Log.addItem( "Database configuratie [reset]", "", "", LogType.Event );
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

  public static void writeUserDatabase( User user ) {
    try {
      FileOutputStream fo = new FileOutputStream( "./resources/config/users.odb" );
      ObjectOutputStream oos = new ObjectOutputStream( fo );
      oos.writeObject( user );
      oos.close();
      fo.close();
    } catch ( Exception ex ) {
      Log.addItem( "Fout tijdens opslaan [Gebruikers database]", ex.getMessage(), "", LogType.Error );
    }
  }

  public static void writeNavisionInfo( NavQueryOverview nqo ) {
    try {
      FileOutputStream fo = new FileOutputStream( "./resources/config/navision.odb" );
      ObjectOutputStream oos = new ObjectOutputStream( fo );
      oos.writeObject( nqo );
      oos.close();
      fo.close();
    } catch ( Exception ex ) {
      Log.addItem( "Fout tijdens opslaan [Navision info]", ex.getMessage(), "", LogType.Error );
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
      Log.addItem( "Fout tijdens inlezen [Gebruikers database]", ex.getMessage(), "", LogType.Error );
      Log.addItem( "Gebruikers database [reset]", "", "", LogType.Event );
      User tempuser = new User();
      tempuser.addUser( "admin", "admin", UserType.gebruiker );
      return tempuser;
    }
  }

  public static NavQueryOverview loadNavQueryOverview() {
    try {
      FileInputStream fi = new FileInputStream( "./resources/config/Navision.odb" );
      ObjectInputStream ois = new ObjectInputStream( fi );
      NavQueryOverview nqo = ( NavQueryOverview ) ois.readObject();
      ois.close();
      fi.close();
      return nqo;
    } catch ( Exception ex ) {
      Log.addItem( "Fout tijdens inlezen [Nav info]", ex.getMessage(), "", LogType.Error );
      Log.addItem( "Nav info [reset]", "", "", LogType.Event );
      NavQueryOverview nqo = new NavQueryOverview();
      return nqo;
    }
  }
}

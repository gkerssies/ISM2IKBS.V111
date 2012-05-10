package gfy;

import java.io.*;

/**
 * Utility IO Class for loading, saving and other IO functionality.
 * @author Janssen-laptop
 * @version 0.1 - 9 mei 2012
 */
public class IOUtillty {

  /**
   * Write the database settings to ./config/db.cfg.
   *
   * @param database the database to write
   */
  public static void writeDatabaseConfig( Database database ) {
    try {
      FileWriter fw = new FileWriter( "./config/db.cfg" );
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
   * Check if there is a database already.
   *
   * @return boolean gives true if the database config exsist
   */
  public static boolean databaseConfigExsist() {
    File file = new File( "./config/db.cfg" );
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
      Log.addItem("Datbase configuratie [corrupt]", ex.getMessage(), "", LogType.Error);
      Log.addItem("Database configuratie [reset]", "", "", LogType.Event);
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
  
  public static void writeUserDatabase(User user)
  {
    try
    {
    FileOutputStream fo = new FileOutputStream( "./resources/config/users.odb" );
    ObjectOutputStream oos = new ObjectOutputStream(fo);
    oos.writeObject(user);
    oos.close();
    fo.close();
    }
    catch(Exception ex)
    {
      Log.addItem( "Fout tijdens opslaan [Gebruikers database]", ex.getMessage(), "", LogType.Error );
    }
  }
  
  public static User loadUserDatabase()
  {
    try
    {
    FileInputStream fi = new FileInputStream( "./resources/config/users.odb" );
    ObjectInputStream ois = new ObjectInputStream(fi);
    User loaduser = (User) ois.readObject();
    ois.close();
    fi.close();
    return loaduser;
    }
    catch(Exception ex)
    {
      Log.addItem( "Fout tijdens opslaan [Gebruikers database]", ex.getMessage(), "", LogType.Error );
      Log.addItem("Gebruikers database [reset]", "", "", LogType.Event);
      User tempuser = new User();
      tempuser.addUser("admin", "admin", UserType.gebruiker);
      return tempuser;
    }
  }
}

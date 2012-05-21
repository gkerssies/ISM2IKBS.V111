package gfy;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.font.TrueTypeFont;
import sun.invoke.empty.Empty;

/**
 * Database Utility class
 */
public class DatabaseUtility {

  private String connectionstring;
  private String Query;
  private Database database;
  private Connection connection;
  private Statement stmt;
  private ResultSet resultset;
  

  /**
   * Create a new database connection.
   *
   * @param database the database settings
   */
  public DatabaseUtility( Database database ) {
    this.database = database;
    
    String con = "";
    
    if ( Config.checkWinMac() == 1 ) {
        con = "jdbc:sqlserver://";
      } else if ( Config.checkWinMac() == 2 ) {
        con = "jdbc:jtds:sqlserver://";
      }
    
    this.connectionstring = con + database.getHost() + ":" + database.getPort() + ";databaseName=" + database.getName() + ";integratedSecurity=false;";
    try {
      if ( Config.checkWinMac() == 1 ) {
        Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
      } else if ( Config.checkWinMac() == 2 ) {
        Class.forName( "net.sourceforge.jtds.jdbc.Driver" );
      }
      connection = DriverManager.getConnection( connectionstring, database.getUsername(), database.getPassword() );
    } catch ( Exception ex ) {
      System.out.println(this.connectionstring);
      Log.addItem( "SQL connectie fout", ex.getMessage(), "Fout tijdens verbinden sql", LogType.Error );
      System.out.println( ex.getMessage() );
      System.out.println(hasConnection());
    }
  }

  /**
   * Check for database connection
   *
   * @return true if the connection is alive
   */
  public boolean hasConnection() {
    try {
      return connection.isValid( 10 );
    } catch ( Exception ex ) {
      return false;
    }

  }

  public ResultSet getDataFromSql() {
    try {
      stmt = connection.createStatement();
      resultset  = stmt.executeQuery(Query);
      return resultset;
    } catch ( Exception ex ) {
      System.out.println(this.connectionstring);
      Log.addItem( "SQL query fout", Query, Query, LogType.Info );
      return null;

    }
  }
  
  public void close()
  {
    try {
      connection.close();
    } catch ( SQLException ex ) {
      Log.addItem("Fout tijdens Sql verbinding sluiten", ex.getMessage(), "", LogType.Error);
    }
  }
  
  public void setQuery(String qry)
  {
    Query = qry;
  }
  public ResultSetMetaData getMetaDataFromSql()
  {
    try
    {
      return resultset.getMetaData();
    }
    catch(Exception ex)
    {
      return null;
    }
    
  }
  
}

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
    this.connectionstring = "jdbc:sqlserver://" + database.getHost() + ":" + database.getPort() + ";databaseName=" + ";integratedSecurity=false;";

    try {
      Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
      connection = DriverManager.getConnection( connectionstring, database.getUsername(), database.getPassword() );
    } catch ( Exception ex ) {
      Log.addItem( "SQL connectie fout", ex.getMessage(), "Fout tijdens verbinden sql", LogType.Error );
      System.out.println( ex.getMessage() );
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

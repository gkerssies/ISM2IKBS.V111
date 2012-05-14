/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

/**
 *
 * @author Janssen-laptop
 */
public class JormenTest 
{
  public static void main( String[] args ) {
    
    System.out.println( "begin" );
    Database dbSettings = IOUtillty.loadDatabaseConfig();
    User user = IOUtillty.loadUserDatabase();
    Config config = new Config(4444, dbSettings, user);
    Server server = new Server(config);
    //server.start();
    try
    {
      Thread.sleep(800);
      DatabaseUtility db = new DatabaseUtility(dbSettings);
      db.setQuery("Select * from [dbo].[User Role]");
      NavQueryResultSet nqrs = new NavQueryResultSet(db.getDataFromSql(), db.getMetaDataFromSql());
      System.out.println(nqrs.toString());
      JFrametest x = new JFrametest(nqrs.getRow(), nqrs.getColumns());
    }
    catch(Exception ex)
    {
      
    }
   
  }
}

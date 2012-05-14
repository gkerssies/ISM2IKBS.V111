package gfy;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

public class NavQueryResultSet implements Serializable {

  private Vector<String> columns;
  private Vector<Vector> row;
  private Vector<String> rowdata;

  public NavQueryResultSet( ResultSet resultset, ResultSetMetaData rsmd ) {
    columns = new Vector<>();

    try {
      row = new Vector<>();
      for ( int i = 1; i <= rsmd.getColumnCount(); i++ ) {
        columns.add( rsmd.getColumnName( i ) );
      }

      while ( resultset.next() ) {
        rowdata = new Vector<>();
        for ( int i = 1; i <= rsmd.getColumnCount(); i++ ) {
          rowdata.add( resultset.getString( i ) );

        }
        row.add( rowdata );
      }

    } catch ( Exception e ) {
      System.out.println( "fout hier" + e.getMessage() );
    }

  }
  public NavQueryResultSet()
  {
    
  }

  @Override
  public String toString() {
    return getColumns() + " kolommen \r\n" + getRow().toString();
  }

  /**
   * @return the row
   */
  public Vector<Vector> getRow() {
    return row;
  }

  /**
   * @return the columns
   */
  public Vector<String> getColumns() {
    return columns;
  }
}

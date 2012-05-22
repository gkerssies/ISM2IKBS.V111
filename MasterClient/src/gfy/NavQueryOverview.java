package gfy;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Janssen-laptop
 * @author Ido Bosman (s1047979)
 * @version 0.1 - 8 mei 2012
 */
public class NavQueryOverview implements Serializable {

  private ArrayList<NavQuery> navQueries;

  /**
   * Constructor for the NavQueryOverview class.
   */
  public NavQueryOverview() {
    navQueries = new ArrayList<NavQuery>();
  }

  /**
   *
   * @param nq object with detailed query data
   */
  public void addNavQuery( NavQuery nq ) {
    getNavQueries().add( nq );
  }

  /**
   *
   * @param nq object with detailed query data
   */
  public void editNavQuery( int index, String title, String description, String query ) {
    getNavQueries().get( index ).setTitle( title );
    getNavQueries().get( index ).setTitle( description );
    getNavQueries().get( index ).setSqlquery( query );
  }

  /**
   *
   * @param nq object with detailed query data
   */
  public void deleteNavQuery( NavQuery nq ) {
    getNavQueries().remove( nq );
  }

  /**
   * @return the navQueries
   */
  public ArrayList<NavQuery> getNavQueries() {
    return navQueries;
  }
}

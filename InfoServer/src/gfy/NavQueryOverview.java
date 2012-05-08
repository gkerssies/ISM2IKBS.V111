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
   * @param nq object with detailled query data
   */
  public void addNavQuery( NavQuery nq ) {
    navQueries.add( nq );
  }

  /**
   *
   * @param nq object with detailled query data
   */
  public void deleteNavQuery( NavQuery nq ) {
    navQueries.remove( nq );
  }
}

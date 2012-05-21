package gfy;

/**
 * Removes the selected NavQuery.
 *
 * @author Gerjan Kerssies
 */
public class DeleteNavQuery {
  
  private SQLManagement sqlManagement;
  private NavQueryOverview nqo;
  private NavQuery query;

  /**
   * Constructor for the EditNavQuery class.
   *
   * @param sqlManagement the SQLManagement object
   * @param nqo           the NavQueryOverview object
   * @param query         the NavQuery to edit
   */
  public DeleteNavQuery( SQLManagement sqlManagement, NavQueryOverview nqo, NavQuery query ) {
    this.sqlManagement = sqlManagement;
    this.nqo = nqo;
    this.query = query;
    
    nqo.deleteNavQuery( query );
  }
}

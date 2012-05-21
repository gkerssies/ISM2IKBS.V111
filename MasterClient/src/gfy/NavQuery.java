package gfy;

import java.io.Serializable;

/**
 * @author Janssen-laptop
 * @author Ido Bosman (s1047979)
 * @version 0.2 - 16 mei 2012
 */
public class NavQuery implements Serializable {

  private int id;
  private String title;
  private String description;
  private String sqlQuery;
  private boolean builtInQuery;
  /**
   * Constructor for the NavQuery class.
   *
   * @param id          the unique id from the NavQuery object
   * @param title       the title from the NavQuery object
   * @param description the description from the NavQuery object
   */
  public NavQuery( int id, String title, String description,String navqry) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.sqlQuery = navqry;
  }

  /**
   *
   * @return the unique id from the NavQuery object
   */
  public int getId() {
    return id;
  }

  /**
   *
   * @return the title from the NavQuery object
   */
  public String getTitle() {
    return title;
  }

  /**
   *
   * @return the description from the NavQuery object
   */
  public String getDescription() {
    return description;
  }

  /**
   *
   * @param title the title from the NavQuery object
   */
  public void setTitle( String title ) {
    this.title = title;
  }

  /**
   *
   * @param description the description from the NavQuery object
   */
  public void setDescription( String description ) {
    this.description = description;
  }

  /**
   * @return the sqlQuery
   */
  public String getSqlquery() {
    return sqlQuery;
  }

  /**
   * @return if the query is built-in
   */
  public boolean isBuiltInQuery() {
    return builtInQuery;
  }
}
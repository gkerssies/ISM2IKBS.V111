package gfy;

import java.io.Serializable;

/**
 * @author Janssen-laptop
 * @author Ido Bosman (s1047979)
 * @version 0.1 - 8 mei 2012
 */
public class NavQuery implements Serializable {

  private String Title;
  private String Description;
  private int uid;

  public NavQuery( String Title, String Description, int uid ) {
    this.Title = Title;
    this.Description = Description;
    this.uid = uid;
  }
}

package gfy;

/**
 *
 * @author Jormen Janssen
 * @version 0.1 - 29 april 2012
 */
public class ClientProperty {

  private String username;
  private boolean loggedin;
  private UserType usertype;

  /**
   * @return the username
   */
  public String getUsername() {
    return username;
  }

  /**
   * @return the user logged in status
   */
  public boolean isLoggedin() {
    return loggedin;
  }

  /**
   * @param t the type of user
   *
   * @return if the usertype is a specified user type
   */
  public boolean isUserType( UserType t ) {

    if ( this.usertype.equals( t ) ) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * @param loggedin the loggedin to set
   * @param username the username of the user
   * @param usertype the type of user
   */
  public void setLoggedin( boolean loggedin, String username, UserType usertype ) {
    this.loggedin = loggedin;
    this.username = username;
    this.usertype = usertype;
  }
}

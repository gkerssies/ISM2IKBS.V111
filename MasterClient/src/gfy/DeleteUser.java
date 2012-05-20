package gfy;

/**
 * Removes the selected user.
 * 
 * @author Gerjan Kerssies
 */
public class DeleteUser {

  private User user;
  private AuthorizationManagement authorizationManagement;

  /**
   * Constructor for the DeleteUser class.
   * Removes the selected user ftom the User object.
   * 
   * @param user                    the User object
   * @param username                the username of the clicked user
   * @param authorizationManagement the AuthorizationManagement object
   */
  public DeleteUser( User user, String username, AuthorizationManagement authorizationManagement ) {
    this.user = user;
    this.authorizationManagement = authorizationManagement;

    user.removeUser( username );
  }
}

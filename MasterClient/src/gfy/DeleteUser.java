package gfy;

/**
 *
 * @author Gerjan Kerssies
 */
public class DeleteUser {

  private User user;
  private AuthorizationManagement authorizationManagement;

  public DeleteUser( User user, String username, AuthorizationManagement authorizationManagement ) {
    this.user = user;
    this.authorizationManagement = authorizationManagement;

    user.removeUser( username );
  }
}

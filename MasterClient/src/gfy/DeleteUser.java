/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import javax.swing.JFrame;

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

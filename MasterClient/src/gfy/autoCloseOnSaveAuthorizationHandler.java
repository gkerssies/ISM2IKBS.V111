package gfy;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Janssen-laptop
 */
public class autoCloseOnSaveAuthorizationHandler implements WindowListener {

  private AuthorizationManagement am;
  private User user;
  private ClientConnection connection;

  public autoCloseOnSaveAuthorizationHandler( ClientConnection connection, User user, AuthorizationManagement am ) {
    this.connection = connection;
    this.user = user;
    this.am = am;
  }

  @Override
  public void windowOpened( WindowEvent e ) {
  }

  @Override
  public void windowClosing( WindowEvent e ) {
    connection.setUser( user );
  }

  @Override
  public void windowClosed( WindowEvent e ) {
  }

  @Override
  public void windowIconified( WindowEvent e ) {
  }

  @Override
  public void windowDeiconified( WindowEvent e ) {
  }

  @Override
  public void windowActivated( WindowEvent e ) {
  }

  @Override
  public void windowDeactivated( WindowEvent e ) {
  }
}

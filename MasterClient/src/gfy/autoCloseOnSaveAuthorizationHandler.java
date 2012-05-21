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
  private SQLManagement sqlm;
  private NavQueryOverview nqo;
  private ClientConnection connection;

  public autoCloseOnSaveAuthorizationHandler( ClientConnection connection, User user, AuthorizationManagement am ) {
    this.connection = connection;
    this.user = user;
    this.am = am;
  }
  
  public autoCloseOnSaveAuthorizationHandler(ClientConnection connection, NavQueryOverview nqo, SQLManagement sqlm) {
    this.connection = connection;
    this.nqo = nqo;
    this.sqlm = sqlm;
  }

  @Override
  public void windowOpened( WindowEvent e ) {
  }

  @Override
  public void windowClosing( WindowEvent e ) {
    if (user != null) {
      connection.setUser( user );
    }
    else if (nqo != null) {
      connection.setQueryOverview( nqo );
    }
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

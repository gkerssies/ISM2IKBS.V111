package gfy;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 *
 * @author Janssen-laptop
 */
public class autoReloadonWindowCloseHandler implements WindowListener {

  private AuthorizationManagement authman;
  private SQLManagement sqlman;

  public autoReloadonWindowCloseHandler( AuthorizationManagement authman ) {
    this.authman = authman;
  }

  public autoReloadonWindowCloseHandler( SQLManagement sqlman ) {
    this.sqlman = sqlman;
  }

  @Override
  public void windowOpened( WindowEvent e ) {
  }

  @Override
  public void windowClosing( WindowEvent e ) {
    if ( authman != null ) {
      authman.reload();
    } else if ( sqlman != null ) {
      sqlman.reload();
    }
  }

  @Override
  public void windowClosed( WindowEvent e ) {
    if ( authman != null ) {
      authman.reload();
    } else if ( sqlman != null ) {
      sqlman.reload();
    }
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

  /**
   * @return the authman
   */
  public AuthorizationManagement getAuthman() {
    return authman;
  }

  /**
   * @return the authman
   */
  public SQLManagement getSqlman() {
    return sqlman;
  }
}

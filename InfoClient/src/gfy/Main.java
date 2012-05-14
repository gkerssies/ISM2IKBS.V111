package gfy;

import javax.swing.JFrame;
import view.login.LoginFrame;

/**
 * De info client.
 *
 * @author Thomas Baart <m.thomasbaart@gmail.com>
 */
public class Main {

  public static ClientConnection clientConnection;

  public Main() {
    JFrame frame = new LoginFrame();
    frame.setVisible( true );
  }

  /**
   * @param args the command line arguments
   */
  public static void main( String[] args ) {
    new Main();
  }

  public static void setClientConnection( ClientConnection clientConnection ) {
    Main.clientConnection = clientConnection;
  }
}

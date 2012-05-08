package gfy;

/**
 * De info client.
 *
 * @author thomasbaart
 */
public class InfoClient {
  private static OverviewFrame overviewFrame;
  private static InlogFrame inlogFrame;

  /**
   * @param args the command line arguments
   */
  public static void main( String[] args ) {
    inlogFrame = new InlogFrame();
  }

  public static void openOverviewFrame() {
    inlogFrame.setVisible( false );
    overviewFrame = new OverviewFrame();
  }
}

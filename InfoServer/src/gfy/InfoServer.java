package gfy;

import UserInterface.*;
import com.sun.corba.se.impl.orb.ParserTable;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is the class from where the info server application is built. All
 * components from classes InformationPanel, LogPanel, PortPanel and StatusPanel
 * are loaded into this class and get a posoition in a BorderLayout.
 *
 * @author Ido Bosman (s1047979)
 */
public class InfoServer extends JFrame {

  private Server server;

  /**
   * Constructor for the InfoServer class.
   */
  public InfoServer() {
    // Set standard frame settings
    setTitle( "GFY - Server (v0.1)" );
    setLayout( new BorderLayout() );
    setDefaultCloseOperation( EXIT_ON_CLOSE );
    setResizable( false );

    // Run method which loads the settings and creates an instance of the server
    createServer();

    // Create the server status panel
    JPanel northPanel = new TitledBorderPanel( "Status", new int[] { 5, 5, 0, 5 } );
    StatusPanel statusPanel = new StatusPanel();
    northPanel.add( statusPanel );
    add( northPanel, BorderLayout.NORTH );

    // Create the log panel
    JPanel centerPanel = new TitledBorderPanel( "Logs", new int[] { 5, 5, 5, 4 } );
    LogPanel logPanel = new LogPanel();
    centerPanel.add( logPanel );
    add( centerPanel, BorderLayout.CENTER );

    // Create the port panel
    JPanel eastPanel = new TitledBorderPanel( "Poort", new int[] { 5, 5, 5, 5 } );
    PortPanel portPanel = new PortPanel( server.getConfig().getServerport() );
    eastPanel.add( portPanel );
    add( eastPanel, BorderLayout.EAST );

    // Create the information panel
    JPanel southPanel = new TitledBorderPanel( "Informatie", new int[] { 0, 5, 5, 5 } );
    InformationPanel informationPanel = new InformationPanel();
    southPanel.add( informationPanel );
    add( southPanel, BorderLayout.SOUTH );

    // Create object that processes all the user actions
    ActionHandler ah = new ActionHandler( this, server, statusPanel, logPanel, portPanel, informationPanel );
  }

  /**
   * Method where the server application begins when it is launched.
   *
   * @param args the command line arguments
   */
  public static void main( String[] args ) {
    Log.addItem( "Applicatie geladen", "", "", LogType.Event );
    InfoServer server = new InfoServer();
    server.pack();
    server.setLocationRelativeTo( server.getRootPane() ); // Center the frame
    server.setVisible( true );

  }

  /**
   * Creates the server. All necessery settings are set/loaded.
   */
  private void createServer() {

    NavQueryOverview navision = new NavQueryOverview();
    NavQuery navGebruikers = new NavQuery(0, "Overzicht gebruikersgroepen", "Overzicht van alle gebruikers", "Select * from [dbo].[User Role]");
    NavQuery navBedrijf = new NavQuery(1, "Overzicht bedrijven", "Overzicht van alle bedrijven", "Select * from [dbo].[Company]");
    navision.addNavQuery( navGebruikers );
    navision.addNavQuery( navBedrijf );
    
    
    int serverPort = 0;
    User users;
    Database database;

    if ( IOUtillty.portConfigExsist() ) {
      serverPort = IOUtillty.loadPortConfig();
      Log.addItem( "Poort configuratiebestand ingeladen", "", "", LogType.Event );
    } else {
      Log.addItem( "Geen poort configuratie bestand gevonden", "", "", LogType.Event );
    }

    if ( IOUtillty.databaseConfigExsist() ) {
      database = IOUtillty.loadDatabaseConfig();
      Log.addItem( "Database configuratie ingeladen", "", "", LogType.Event );
    } else {
      Log.addItem( "Geen database configuratie gevonden", "", "", LogType.Event );
      database = new Database( "Navision", "SQLSERVER", 11000, "Gebruikersnaam", "Password" );
    }

    if ( IOUtillty.userDatabaseExsist() ) {
      users = IOUtillty.loadUserDatabase();
      Log.addItem( "Gebruikers database ingeladen", "", "", LogType.Event );
    } else {
      Log.addItem( "Geen gebruikers database gevonden", "", "", LogType.Event );
      users = new User();
      users.addUser( "admin", "admin", UserType.beheerder );
    }


    Config config = new Config( serverPort, database, users ,navision);

    server = new Server( config );

    // Add test user
    users.addUser( "admin", "admin", UserType.gebruiker );
  }
}

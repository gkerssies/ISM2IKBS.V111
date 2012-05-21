package gfy;

import BackupRestore.BackupScreen;
import InfoScreen.InfoFrame;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Creates the HomeScreen JFrame. From this frame, other frames can be opened.
 *
 * @author Gerjan Kerssies
 * @version 0.1 - 26-04-2012
 */
public class HomeScreen extends JFrame implements ActionListener {

  private JMenuBar menuBar;
  private JMenu menuClient, menuServer, menuInfo;
  private JMenuItem itemClient, itemSettings, itemLog, itemBackup, itemInfo, itemServerStop;
  private JPanel panel;
  private JButton buttonAuth, buttonSQL,ButtonBackupRestore;
  private ClientConnection clientConnection;

  private JButton buttonAuth, buttonSQL;
  private ClientConnection clientConnection;

  /**
   * Constructor for the HomeScreen class. Add all components to the JFrame,
   * including panels.
   *
   * @param clientconnection the connection Object with the client.
   */
  public HomeScreen( ClientConnection clientconnection ) {
    this.clientConnection = clientconnection;

    if ( !clientconnection.isConnected() ) {
      JOptionPane.showMessageDialog( this, "Kan geen verbinding maken met server", "Verbindingsfout", JOptionPane.ERROR_MESSAGE );

      System.exit( 0 );
    }

    menuBar = new JMenuBar();
    menuClient = new JMenu( "Client" );
    itemClient = new JMenuItem( "Client" );
    itemClient.addActionListener( this );
    menuClient.add( itemClient );

    menuServer = new JMenu( "Server" );
    itemSettings = new JMenuItem( "Serverinstellingen" );
    itemLog = new JMenuItem( "Serverlog" );
    itemBackup = new JMenuItem( "Backup en herstel" );
    itemServerStop = new JMenuItem( "Stop Server" );
    itemSettings.addActionListener( this );
    itemLog.addActionListener( this );
    itemBackup.addActionListener( this );
    itemServerStop.addActionListener( this );
    menuServer.add( itemSettings );
    menuServer.add( itemLog );
    menuServer.add( itemBackup );
    menuServer.add( itemServerStop );

    menuInfo = new JMenu( "Info" );
    itemInfo = new JMenuItem( "Info" );
    itemInfo.addActionListener( this );
    menuInfo.add( itemInfo );

    menuBar.add( menuClient );
    menuBar.add( menuServer );
    menuBar.add( menuInfo );

    setJMenuBar( menuBar );

    panel = new JPanel( new BorderLayout() );
    panel.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

    buttonAuth = new JButton();
    buttonAuth.setText( "Autorisatiebeheer" );
    buttonAuth.setMargin( new Insets( 10, 45, 10, 45 ) );
    buttonAuth.setFocusPainted( false );
    buttonAuth.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
    buttonAuth.addActionListener( this );

    buttonSQL = new JButton();
    buttonSQL.setText( "SQL beheer" );
    buttonSQL.setMargin( new Insets( 10, 45, 10, 45 ) );
    buttonSQL.setFocusPainted( false );
    buttonSQL.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
    buttonSQL.addActionListener( this );
    
    ButtonBackupRestore = new JButton();
    ButtonBackupRestore.setText( "Backup / Herstel" );
    ButtonBackupRestore.setMargin( new Insets( 10, 45, 10, 45 ) );
    ButtonBackupRestore.setFocusPainted( false );
    ButtonBackupRestore.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
    ButtonBackupRestore.addActionListener( this );

    panel.add( buttonAuth, BorderLayout.NORTH );
    //panel.add( Box.createVerticalStrut( 5 ), BorderLayout.CENTER );
    panel.add( buttonSQL, BorderLayout.CENTER );
    panel.add(ButtonBackupRestore,BorderLayout.SOUTH);

    setLayout( new BorderLayout() );
    setContentPane( panel );
    setSize( 210, 400 );
    setResizable( false );
    setTitle( "Master Client" );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    pack();
    setLocationRelativeTo( getRootPane() );
    setVisible( true );
  }

  @Override
  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == itemClient ) {
      System.out.println( "itemClient" );
    } else if ( e.getSource() == itemServer ) {
      InfoFrame frame = new InfoFrame(clientConnection);
    } else if ( e.getSource() == itemSettings ) {
      JFrame frame = new ServerSettings( clientConnection );
    } else if ( e.getSource() == itemLog ) {
      System.out.println( "itemLog" );
    } else if ( e.getSource() == itemBackup ) {
      new BackupScreen( clientConnection );
    } else if ( e.getSource() == itemServerStop ) {
      closeServer();
    } else if ( e.getSource() == itemInfo ) {
      System.out.println( "itemInfo" );
    } else if ( e.getSource() == buttonAuth ) {
      JFrame frame = new AuthorizationManagement( clientConnection );
    } else if ( e.getSource() == buttonSQL ) {
      JFrame frame = new ServerSettings( clientConnection );
    } else if ( e.getSource() == ButtonBackupRestore ) {
     new BackupScreen(clientConnection);
      JFrame frame = new SQLManagement( clientConnection );
    }
  }

  /**
   * Closes the server. After the 'Yes' button is clicked, the server will be
   * stopped en closed.
   */
  public void closeServer() {
    int allowToStopServer = JOptionPane.showConfirmDialog(
            this,
            "Weet u zeker dat u de server op afstand wilt stoppen en afsluiten?\nAlle verbonden clients worden ook afgesloten.\nDe server kan niet weer worden gestart op afstand.",
            "U staat op het punt de server te stoppen",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE );

    // If the 'Yes' button is clicked in the confirm dialog the server will be stopped
    if ( allowToStopServer == 0 ) {
      clientConnection.sendCommand( "STOP" );
      System.exit( 0 );
    }
  }
}

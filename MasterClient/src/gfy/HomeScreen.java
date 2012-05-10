/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Gerjan Kerssies
 * @version 0.1 - 26-04-2012
 */
public class HomeScreen extends JFrame implements ActionListener {

  private JMenuBar menuBar;
  private JMenu menuClient, menuServer, menuInfo;
  private JMenuItem itemClient, itemServer, itemInfo, itemServerStop;
  private JPanel panel;
  private JButton buttonAuth, buttonSQL;
  private ClientConnection clientconnetion;

  public HomeScreen( ClientConnection clientconnection ) {
    this.clientconnetion = clientconnection;

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
    itemServer = new JMenuItem( "Server" );
    itemServerStop = new JMenuItem( "Stop Server" );
    itemServer.addActionListener( this );
    itemServerStop.addActionListener( this );
    menuServer.add( itemServer );
    menuServer.add( itemServerStop );

    menuInfo = new JMenu( "Info" );
    itemInfo = new JMenuItem( "Info" );
    itemInfo.addActionListener( this );
    menuInfo.add( itemInfo );

    menuBar.add( menuClient );
    menuBar.add( menuServer );
    menuBar.add( menuInfo );

    setJMenuBar( menuBar );

    panel = new JPanel();

    buttonAuth = new JButton();
    buttonAuth.setText( "Authorisatiebeheer" );
    buttonAuth.setPreferredSize( new Dimension( 160, 30 ) );
    buttonAuth.addActionListener( this );

    buttonSQL = new JButton();
    buttonSQL.setText( "SQL Beheer" );
    buttonSQL.setPreferredSize( new Dimension( 160, 30 ) );
    buttonSQL.addActionListener( this );

    panel.add( buttonAuth );
    panel.add( buttonSQL );

    setLayout( new BorderLayout() );
    setContentPane( panel );
    setSize( 210, 150 );
    setResizable( false );
    setTitle( "Master Client" );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setVisible( true );
  }

  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == itemClient ) {
      System.out.println( "itemClient" );
    } else if ( e.getSource() == itemServer ) {
      System.out.println( "itemServer" );
    } else if ( e.getSource() == itemServerStop ) {
      closeServer();
    } else if ( e.getSource() == itemInfo ) {
      System.out.println( "itemInfo" );
    } else if ( e.getSource() == buttonAuth ) {

      JFrame frame = new AuthorizationManagement( clientconnetion );
    } else if ( e.getSource() == buttonSQL ) {
      JFrame frame = new ServerSettings( clientconnetion );
    }
  }
  public void closeServer()
  {
    int allowToStopServer = JOptionPane.showConfirmDialog(
              this,
              "Weet u zeker dat u de server op afstand wilt stoppen en afsluiten?\nAlle verbonden clients worden ook afgesloten.\nDe server kan niet weer worden gestart op afstand.",
              "U staat op het punt de server te stoppen.",
              JOptionPane.YES_NO_OPTION,
              JOptionPane.WARNING_MESSAGE );

      // If the 'Yes' button is clicked in the confirm dialog the server will be stopped
      if ( allowToStopServer == 0 )
      {
        clientconnetion.sendCommand( "STOP" );
        System.exit(0);
      }
  }
  
}

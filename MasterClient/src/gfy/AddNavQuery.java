package gfy;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Creates a JFrame which a NavQuery can be added.
 *
 * @author Gerjan Kerssies
 */
public class AddNavQuery extends JFrame implements ActionListener {

  private SQLManagement sqlManagement;
  private NavQuerySettingsPanel panel;

  /**
   * Constructor for the AddNavQuery class.
   *
   * @param sqlManagement the SQLManagement object
   */
  public AddNavQuery( SQLManagement sqlManagement ) {
    this.sqlManagement = sqlManagement;
    panel = new NavQuerySettingsPanel( "addNavQuery", this, 0 );

    setLayout( new GridLayout( 4, 1 ) );
    setContentPane( panel );
    setSize( 310, 280 );
    setResizable( false );
    setTitle( "Navision query toevoegen" );
    setLocationRelativeTo( getRootPane() );
    setVisible( true );
  }

  /**
   * Save the new NavQuery.
   */
  public void save() {
  }

  @Override
  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == panel.getButtonCancel() ) {
      dispose();
    } else if ( e.getSource() == panel.getButtonSave() ) {
      save();
      dispose();
    }
  }
}

package gfy;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Creates a JFrame which a NavQuery can be edited.
 *
 * @author Gerjan Kerssies
 */
public class EditNavQuery extends JFrame implements ActionListener {

  private SQLManagement sqlManagement;
  private NavQuerySettingsPanel panel;

  /**
   * Constructor for the EditNavQuery class.
   *
   * @param sqlManagement the SQLManagement object
   */
  public EditNavQuery( SQLManagement sqlManagement ) {
    this.sqlManagement = sqlManagement;
    panel = new NavQuerySettingsPanel( "editNavQuery", this, 0 );

    setLayout( new GridLayout( 4, 1 ) );
    setContentPane( panel );
    setSize( 310, 280 );
    setResizable( false );
    setTitle( "Navision query wijzigen" );
    setLocationRelativeTo( getRootPane() );
    setVisible( true );
  }

  /**
   * Save the changed NavQuery.
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

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
  private NavQueryOverview nqo;

  /**
   * Constructor for the AddNavQuery class.
   *
   * @param sqlManagement the SQLManagement object
   * @param nqo           the NavQueryOverview object
   */
  public AddNavQuery( SQLManagement sqlManagement, NavQueryOverview nqo ) {
    this.sqlManagement = sqlManagement;
    this.nqo = nqo;

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
   *
   * @return boolean user object is saved
   */
  public boolean save() {
    if ( panel.getTitle().getText().equals( "" ) ) {
      JOptionPane.showMessageDialog( panel, "Titel veld kan niet leeg zijn", "Validatie fout", JOptionPane.INFORMATION_MESSAGE );
      return false;
    } else if ( panel.getDescription().getText().equals( "" ) ) {
      JOptionPane.showMessageDialog( panel, "Beschrijving veld kan niet leeg zijn", "Validatie fout", JOptionPane.INFORMATION_MESSAGE );
      return false;
    } else if ( panel.getQuery().getText().equals( "" ) ) {
      JOptionPane.showMessageDialog( panel, "Query veld kan niet leeg zijn", "Validatie fout", JOptionPane.INFORMATION_MESSAGE );
      return false;
    } else {
      int id = sqlManagement.getMaxId() + 1;
      NavQuery nq = new NavQuery( id, panel.getTitle().getText(), panel.getDescription().getText(), panel.getQuery().getText() );
      nqo.addNavQuery( nq );
      return true;
    }
  }

  @Override
  public void actionPerformed( ActionEvent e ) {
    if ( e.getSource() == panel.getButtonCancel() ) {
      dispose();
    } else if ( e.getSource() == panel.getButtonSave() ) {
      if ( save() ) {
        dispose();
      }
    }
  }
}

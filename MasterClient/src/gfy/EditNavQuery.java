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
  private NavQueryOverview nqo;
  private NavQuery query;

  /**
   * Constructor for the EditNavQuery class.
   *
   * @param sqlManagement the SQLManagement object
   * @param nqo           the NavQueryOverview object
   * @param query         the NavQuery to edit
   */
  public EditNavQuery( SQLManagement sqlManagement, NavQueryOverview nqo, NavQuery query ) {
    this.sqlManagement = sqlManagement;
    this.nqo = nqo;
    this.query = query;
    panel = new NavQuerySettingsPanel( "editNavQuery", this, query );

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
      nqo.editNavQuery( query.getId(), panel.getTitle().getText(), panel.getDescription().getText(), panel.getQuery().getText());
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

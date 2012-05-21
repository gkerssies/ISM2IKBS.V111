package gfy;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Creates a JPanel with all the input fields to add or edit a NavQuery. This
 * panel is used by JFrame AddNavQuery and EditNavQuery.
 *
 * @author Gerjan Kerssies
 */
public class NavQuerySettingsPanel extends JPanel {

  private JPanel panelLabels, panelInput, panelButtons;
  private JLabel label1, label2, label3;
  private JTextField title;
  private JTextArea description, query;
  private JButton buttonCancel, buttonSave;
  private JFrame frame;

  /**
   * Constructor for the NavQuerySettingsPanel class.
   *
   * @param action the action of the panel (can be addNavQuery or editNavQuery)
   * @param frame  the frame where this panel is inside
   * @param id     the id of the NavQuery to edit
   */
  public NavQuerySettingsPanel( String action, JFrame frame, int id ) {
    this.frame = frame;

    panelLabels = new JPanel();
    panelLabels.setPreferredSize( new Dimension( 100, 205 ) );
    panelInput = new JPanel();
    panelInput.setPreferredSize( new Dimension( 190, 205 ) );
    panelButtons = new JPanel();

    add( panelLabels );
    add( panelInput );
    add( panelButtons );

    label1 = new JLabel( "Titel" );
    label1.setPreferredSize( new Dimension( 90, 20 ) );
    label2 = new JLabel( "Beschrijving" );
    label2.setPreferredSize( new Dimension( 90, 20 ) );
    label3 = new JLabel( "Query" );
    label3.setPreferredSize( new Dimension( 90, 140 ) );

    title = new JTextField( 15 );
    description = new JTextArea( 5, 15 );
    description.setLineWrap( true );
    query = new JTextArea( 5, 15 );
    query.setLineWrap( true );

    if ( action.equals( "editNavQuery" ) ) {
    }

    buttonCancel = new JButton();
    buttonCancel.setText( "Annuleren" );
    buttonCancel.setPreferredSize( new Dimension( 100, 25 ) );
    buttonCancel.addActionListener( ( ActionListener ) frame );

    buttonSave = new JButton();
    buttonSave.setText( "Opslaan" );
    buttonSave.setPreferredSize( new Dimension( 100, 25 ) );
    buttonSave.addActionListener( ( ActionListener ) frame );

    panelLabels.add( label1 );
    panelLabels.add( label2 );
    panelLabels.add( label3 );

    panelInput.add( title );
    panelInput.add( description );
    panelInput.add( query );

    panelButtons.add( buttonCancel );
    panelButtons.add( buttonSave );
  }

  /**
   * @return the title (JTextField)
   */
  public JTextField getTitle() {
    return title;
  }

  /**
   * @return the description (JTextArea)
   */
  public JTextArea getDescription() {
    return description;
  }

  /**
   * @return the query (JTextArea)
   */
  public JTextArea getQuery() {
    return query;
  }

  /**
   * @return the buttonSave (JButton)
   */
  public JButton getButtonSave() {
    return buttonSave;
  }

  /**
   * @return the buttonCancel (JButton)
   */
  public JButton getButtonCancel() {
    return buttonCancel;
  }
}

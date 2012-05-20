package gfy;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Creates a JFrame which a NavQuery can be edited.
 *
 * @author Gerjan Kerssies
 */
public class EditNavQuery extends JFrame implements ActionListener {

  private JPanel panel;

  /**
   * Constructor for the EditNavQuery class.
   */
  public EditNavQuery() {
    panel = new JPanel();
    
    setLayout( new GridLayout( 4, 1 ) );
    setContentPane( panel );
    setSize( 350, 220 );
    setResizable( false );
    setTitle( "Navision query wijzigen" );
    setLocationRelativeTo( getRootPane() );
    setVisible( true );
  }

  @Override
  public void actionPerformed( ActionEvent e ) {
  }
}

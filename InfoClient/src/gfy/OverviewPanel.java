package gfy;

import UserInterface.ImgButton;
import UserInterface.InputPanel;
import UserInterface.TexturedPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author thomasbaart
 */
public class OverviewPanel extends TexturedPanel {

  private JPanel imagePanel, contentPanel, buttonPanel;
  private TexturedPanel mainPanel;
  private static final String buttonIcon = "resources/images/buttons/nextButton.png";

  public OverviewPanel() {
    super();
    setupImagePanel( "resources/images/icons/testIcon.png" );
    setupContentPanel();
    setupButtonPanel();
    setupOverviewPanel();
  }

  /**
   * Sets up the imagePanel with the appropriate image and styles.
   *
   * @param fileName
   */
  private void setupImagePanel( String fileName ) {
    imagePanel = new InputPanel();
    imagePanel.setLayout( new BorderLayout() );
    imagePanel.setBackground( new Color( 0, 0, 0, 0 ) );
    imagePanel.setBorder( new LineBorder( new Color( 0, 0, 0, 0 ), 3 ) );

    JLabel label = new JLabel( new ImageIcon( fileName ) );
    label.setBorder( new LineBorder( Color.GRAY, 1 ) );
    imagePanel.add( label, BorderLayout.NORTH );
  }

  private void setupContentPanel() {
    contentPanel = new InputPanel();
    contentPanel.setLayout( new BorderLayout() );
    contentPanel.setBorder( new LineBorder( new Color( 0, 0, 0, 0 ), 3 ) );

    JLabel description = new JLabel( "Testcontent" );
    description.setFont( new Font( Font.SANS_SERIF, Font.BOLD, 13 ) );
    description.setBorder( new MatteBorder( 0, 0, 1, 0, Color.GRAY ) );
    contentPanel.add( description, BorderLayout.NORTH );

    JTextArea content = new JTextArea( "Een iets langere omschrijving dan gewoonlijk, om te kijken hoe het werkt.", 2, 15 );
    content.setLineWrap( true );
    content.setWrapStyleWord( true );
    content.setEditable( false );
    content.setBackground( Color.white );
    contentPanel.add( content, BorderLayout.CENTER );
  }

  private void setupButtonPanel() {
    buttonPanel = new InputPanel();
    buttonPanel.setLayout( new GridLayout() );
    buttonPanel.setBorder( new LineBorder( new Color( 0, 0, 0, 0 ), 3 ) );

    ImgButton button = new ImgButton( buttonIcon );
    buttonPanel.add( button );
  }

  private void setupOverviewPanel() {
    setLayout( new BorderLayout() );
    setBackground( Color.WHITE );
    setBorder( new LineBorder( Color.GRAY, 1 ) );

    add( imagePanel, BorderLayout.WEST );
    add( contentPanel, BorderLayout.CENTER );
    add( buttonPanel, BorderLayout.EAST );
  }
}

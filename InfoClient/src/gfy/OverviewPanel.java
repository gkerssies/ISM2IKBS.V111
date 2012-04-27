package gfy;

import UserInterface.ImgButton;
import UserInterface.InputPanel;
import UserInterface.WrappableJLabel;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

/**
 *
 * @author thomasbaart
 */
public class OverviewPanel extends JPanel {
  /*
   * TODO: Kleur lichter maken van de lijn onder de contenttitel
   * TODO: Code dusdanig herschrijven dat er inputs zijn voor de foto, titel en
   * content
   * TODO: ActionListener toevoegen die goed onderscheid kan maken tussen de
   * twee knoppen, wellicht met een genummerd veld die je meegeeft in de
   * constructor
   * TODO: Velden logisch hernoemen
   */

  private JPanel imagePanel, contentPanel, buttonPanel, buttonPanelContainer;
  private static final String buttonIcon = "resources/images/buttons/nextButton.png";
  private static final Color transparant = new Color( 0, 0, 0, 0 );
  private static final Color transparantGray = new Color( 255, 255, 255, 150 );
  private static final EmptyBorder emptyBorder = new EmptyBorder( 3, 3, 3, 3 );
  private static final LineBorder grayBorder = new LineBorder( Color.GRAY, 1 );
  private final int preferredWidth = 350;

  /**
   * Constructor of OverviewPanel.
   * 
   * @param imageFilePath Path to the image file to display on the left of the panel.
   * @param title Title to display on the panel.
   * @param description Description to put on the panel.
   */
  public OverviewPanel( String imageFilePath, String title, String description) {
    super();
    setupImagePanel( imageFilePath );
    setupContentPanel( title, description );
    setupButtonPanel();
    setupOverviewPanel();
  }

  private void setupImagePanel( String fileName ) {
    imagePanel = new InputPanel();
    imagePanel.setLayout( new BorderLayout() );
    imagePanel.setBackground( transparantGray );
    imagePanel.setBorder( emptyBorder );

    JLabel label = new JLabel( new ImageIcon( fileName ) );
    label.setBorder( grayBorder );
    imagePanel.add( label, BorderLayout.NORTH );
  }

  private void setupContentPanel( String title, String description ) {
    JLabel titleLabel = new JLabel( title );
    titleLabel.setFont( new Font( Font.SANS_SERIF, Font.BOLD, 13 ) );
    titleLabel.setBackground( transparant );
    titleLabel.setBorder( new MatteBorder( 0, 0, 1, 0, Color.GRAY ) );

    WrappableJLabel descriptionLabel = new WrappableJLabel( "<html>" + description + "</html>", 250 );
    descriptionLabel.setFont( new Font( Font.SANS_SERIF, Font.PLAIN, 13 ) );
    descriptionLabel.setBackground( Color.white );
    descriptionLabel.setVerticalAlignment( SwingConstants.NORTH );

    contentPanel = new JPanel();
    contentPanel.setLayout( new BorderLayout() );
    contentPanel.setBackground( transparantGray );
    contentPanel.setBorder( emptyBorder );
    contentPanel.add( titleLabel, BorderLayout.NORTH );
    contentPanel.add( descriptionLabel, BorderLayout.CENTER );
  }

  private void setupButtonPanel() {
    ImgButton button = new ImgButton( buttonIcon );

    buttonPanel = new InputPanel();
    buttonPanel.setLayout( new GridLayout() );
    buttonPanel.setBorder( emptyBorder );
    buttonPanel.setBackground( transparant );
    buttonPanel.add( button );

    buttonPanelContainer = new JPanel();
    buttonPanelContainer.setBackground( transparantGray );
    buttonPanelContainer.add( buttonPanel );
  }

  private void setupOverviewPanel() {
    setLayout( new BorderLayout() );
    setBackground( transparant );
    CompoundBorder border = new CompoundBorder( emptyBorder, grayBorder );
    setBorder( border );

    add( imagePanel, BorderLayout.WEST );
    add( contentPanel, BorderLayout.CENTER );
    add( buttonPanelContainer, BorderLayout.EAST );
    setPreferredSize( new Dimension( 350, 65) );
  }
}

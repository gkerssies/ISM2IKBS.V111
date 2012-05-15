package view.overview;

import UserInterface.WrappableJLabel;
import gfy.ClientConnection;
import gfy.Main;
import gfy.NavQuery;
import gfy.NavQueryOverview;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import view.dataview.DataviewFrame;
import view.util.ViewBorders;

/**
 * The overviewFrame.
 *
 * @author Thomas Baart <m.thomasbaart@gmail.com>
 */
public class OverviewFrame extends JFrame {

  /**
   * The queryPanels inside the overviewFrame.
   */
  private static class QueryPanel extends JPanel implements ActionListener {

    private int id;
    private JLabel titleLabel;
    private WrappableJLabel descriptionLabel;
    private JButton button;
    private ClientConnection clientconnection;
    private NavQueryOverview nqo;
    /**
     * Default constructor.
     */
    public QueryPanel() {
      super();
    }

    /**
     * Constructor.
     *
     * @param id          The id to assign to this panel, used to distinguish
     *                    between the different panels.
     * @param title       The title to display on the panel.
     * @param description The description to display on the panel.
     */
    public QueryPanel( int id, String title, String description ) {
      super();
      clientconnection = Main.clientConnection;
      nqo = clientconnection.getNavisionQueryOverview();
      this.id = id;

      this.setBorder( new CompoundBorder(ViewBorders.LINE_GRAY_1PX_EMPTY_2PX, ViewBorders.EMPTY_2PX));

      titleLabel = new JLabel( title );
      titleLabel.setFont( new Font( Font.SANS_SERIF, Font.BOLD, 13 ) );

      descriptionLabel = new WrappableJLabel( "<html>" + description + "</html>", 250 );

      JPanel buttonPanel = new JPanel();
      button = new JButton( ">" );
      button.addActionListener( this );
      buttonPanel.add( button );

      setLayout( new BorderLayout() );
      add( titleLabel, BorderLayout.NORTH );
      add( descriptionLabel, BorderLayout.CENTER );
      add( buttonPanel, BorderLayout.EAST );
    }

    @Override
    public void actionPerformed( ActionEvent e ) {
      if ( e.getSource() == button ) {
       
     //   System.out.println( "button inside QueryPanel " + id + " was clicked." );
        String t = Integer.toString(id);
        NavQuery current = new NavQuery( id, "", "", "" );
        for(NavQuery nq : clientconnection.getNavisionQueryOverview().getNavQueries())
        {
          if (nq.getId() == id)
          {
            current = nq;
          }
        }
        
        new DataviewFrame(clientconnection.getNavisionQueryResultset(t),current).setVisible( true);
      }
    }
  }
  private JPanel contentPanel;
  private JScrollPane scrollPane;
  private NavQueryOverview navQueryOverview;
  private ArrayList<NavQuery> navQueries;
  private  ClientConnection clientconnection;
  
  /**
   * Default constructor. Generates a few panels for testing.
   */
  public OverviewFrame() {
    super();
    setup();
    this.clientconnection = Main.clientConnection; 
    
    int n= 0;
    for(NavQuery nq : clientconnection.getNavisionQueryOverview().getNavQueries())
    {
      contentPanel.add( new QueryPanel( n, nq.getTitle(), nq.getDescription() ) );
       n++;
    }
    
    //contentPanel.add( new QueryPanel( 1, "Nog een titel", "Nog een beschrijving, maar dan een iets langere." ) );
   // contentPanel.add( new QueryPanel( 2, "Weer een query",
   //  "Een beschrijving waarbij je toch begint te denken dat het wellicht handig is om een wrappable JLabel te hebben" ) );
    pack();
    setSize( getWidth() + 15, getHeight() );
  }

  /**
   * Configures the frame's shared settings between the constructors.
   */
  private void setup() {
    contentPanel = new JPanel();
    contentPanel.setLayout( new BoxLayout( contentPanel, BoxLayout.Y_AXIS ) );
    scrollPane = new JScrollPane( contentPanel );
    scrollPane.setHorizontalScrollBarPolicy( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
    add( scrollPane );

    setTitle( "Info client - Weergaven" );
    setDefaultCloseOperation( EXIT_ON_CLOSE );
  }

  /**
   * Generates the QueryPanels from the NavQueryOverview data.
   */
  private void queryPanels() {
    for ( NavQuery nq : navQueries ) {
      int id = nq.getId();
      String title = nq.getTitle();
      String description = nq.getDescription();
      JPanel panel = new QueryPanel( id, title, description );
      contentPanel.add( panel );
    }
  }
}

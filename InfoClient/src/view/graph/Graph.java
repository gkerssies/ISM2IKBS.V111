package view.graph;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;
import view.util.MyFonts;

/**
 * Used for constructing the base for a graph: side labels, horizontal and
 * vertical axis, and the title.
 *
 * @author Thomas Baart <m.thomasbaart@gmail.com>
 */
public class Graph extends Canvas {

  protected int top, bottom, left, right, titleHeight, labelWidth, padding = 4;
  protected double min, max;
  protected String title;
  protected FontMetrics fm;
  protected ArrayList<GraphItem> items;
  protected Dimension prefferedSizeDim;

  /**
   * Constructor of Graph.
   *
   * @param title The title to use for the graph.
   * @param al    The ArrayList of GraphItems to use for constructing the table.
   */
  public Graph( String title, ArrayList<GraphItem> al ) {
    this.title = title;
    for ( GraphItem gi : al ) {
      max = gi.value > max ? gi.value : max;
      min = gi.value < min ? gi.value : min;
    }
    max *= 1.1;
    items = new ArrayList<>( al );
  }

  public Graph( String title, ArrayList<GraphItem> al, Dimension dim ) {
  }

  @Override
  public void setBounds( int x, int y, int width, int height ) {
    super.setBounds( x, y, width, height );
    fm = getFontMetrics( getFont() );
    titleHeight = fm.getHeight();
    labelWidth = Math.max( fm.stringWidth( new Integer( ( int ) min ).toString() ),
                           fm.stringWidth( new Integer( ( int ) max ).toString() ) ) + 2;
    top = padding + titleHeight;
    bottom = getSize().height - padding;
    left = padding + labelWidth;
    right = getSize().width - padding;
  }

  @Override
  public void paint( Graphics g ) {
    // draw the title
    g.setFont( MyFonts.ROBOTO_REGULAR.get( 24 ) );
    fm = getFontMetrics( MyFonts.ROBOTO_REGULAR.get( 24 ) );
    g.drawString( title, ( getSize().width - fm.stringWidth( title ) ) / 2, top );

    // draw the max and min values
    g.setFont( MyFonts.SANSATION_REGULAR.get() );
    g.drawString( new Integer( ( int ) min ).toString(), padding, bottom );
    g.drawString( new Integer( ( int ) max ).toString(), padding, top + titleHeight );

    // draw the middle value
    g.drawString( new Integer( ( ( int ) min + ( int ) max ) / 2 ).toString(),
                  padding,
                  ( ( bottom - top + titleHeight ) / 2 ) + titleHeight );

    // draw the vertical and horizontal lines
    g.drawLine( left, top, left, bottom );
    g.drawLine( left, bottom, right, bottom );
  }

  @Override
  public Dimension getPreferredSize() {
    return ( new Dimension( 300, 300 ) );
  }

  /**
   * Getter for items.
   *
   * @return This graphs list of items.
   */
  public ArrayList<GraphItem> getItems() {
    return items;
  }
}

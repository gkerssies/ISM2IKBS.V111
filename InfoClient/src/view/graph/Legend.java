package view.graph;

import java.awt.*;
import java.util.ArrayList;
import view.util.MyFonts;

/**
 * Used for making a legend alongside the graphs. Makes a list of the titles and
 * colors used in the graphs.
 *
 * @author Thomas Baart <m.thomasbaart@gmail.com>
 */
public class Legend extends Canvas {

  private FontMetrics fm;
  private int padding = 4;
  private int textHeight;
  protected ArrayList<GraphItem> items;
  private int titleHeight;
  private int top, bottom, left, right;
  private int panelWidth;

  /**
   * Constructor.
   *
   * @param items The ArrayList to construct the legend from.
   */
  public Legend( ArrayList<GraphItem> items ) {
    this.items = items;
    for ( GraphItem gi : items ) {
      fm = getFontMetrics( MyFonts.SANSATION_REGULAR.get( 13 ) );
      panelWidth = fm.stringWidth( gi.title ) > panelWidth ? fm.stringWidth( gi.title ) : panelWidth;
    }
    fm = getFontMetrics( MyFonts.SANSATION_REGULAR.get( 13 ) );
    textHeight = fm.getHeight();
    panelWidth += textHeight + ( 3 * padding );
  }

  @Override
  public void paint( Graphics g ) {
    super.paint( g );
    paintLegend( g );
  }

  /**
   * Paints the legend.
   *
   * @param g The graphics object.
   */
  private void paintLegend( Graphics g ) {
    g.setFont( MyFonts.ROBOTO_REGULAR.get( 16 ) );
    fm = getFontMetrics( MyFonts.ROBOTO_REGULAR.get( 16 ) );
    g.drawString( "Legenda", padding, fm.getHeight() );
    g.setFont( MyFonts.SANSATION_REGULAR.get( 13 ) );
    fm = getFontMetrics( MyFonts.SANSATION_REGULAR.get( 13 ) );
    textHeight = fm.getHeight();
    int y = ( 2 * padding ) + titleHeight;
    int x = ( 2 * padding ) + textHeight;
    for ( GraphItem gi : items ) {
      paintColorBox( padding, y, gi.color, g );
      g.drawString( gi.title, x, y + textHeight - 2 );
      y += textHeight + padding;
    }
  }

  /**
   * Draws a single colored box.
   *
   * @param x     The new boxes x-coordinate.
   * @param y     The new boxes y-coordinate.
   * @param color The color used for the boxes fill.
   * @param g     The graphics object.
   */
  private void paintColorBox( int x, int y, Color color, Graphics g ) {
    Color temp = g.getColor();
    g.setColor( color );
    g.fillRect( x, y, textHeight, textHeight );
    g.setColor( temp );
    g.drawRect( x, y, textHeight, textHeight );
  }

  @Override
  public void setBounds( int x, int y, int width, int height ) {
    super.setBounds( x, y, width, height );
    fm = getFontMetrics( getFont() );
    titleHeight = fm.getHeight();
    top = padding + titleHeight;
    bottom = getSize().height - padding;
    left = padding;
    right = panelWidth - padding;
  }

  @Override
  public Dimension getPreferredSize() {
    return ( new Dimension( panelWidth, 300 ) );
  }
}

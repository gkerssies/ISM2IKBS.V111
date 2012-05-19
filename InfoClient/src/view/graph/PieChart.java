package view.graph;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import view.util.MyFonts;

/**
 * Used for turning data into a pie chart. Makes a Canvas with a fully resizable
 * pie chart and title.
 *
 * @author Thomas Baart <m.thomasbaart@gmail.com>
 */
public class PieChart extends Graph {

  private double total = 0;
  private double x = padding;
  private double y = padding;
  private double w;
  private double h;
  private double start = 90;
  private double extent;

  /**
   * Constructor of PieChart.
   *
   * @param title The title to use for this chart.
   * @param al    The ArrayList of GraphItems to construct the chart with.
   */
  public PieChart( String title, ArrayList<GraphItem> al ) {
    super( title, al );
    Collections.reverse( items );
    getTotal();
  }

  /**
   * Sets this objects total field.
   */
  public final void getTotal() {
    total = 0;
    for ( GraphItem i : items ) {
      total += i.value;
    }
  }

  @Override
  public void setBounds( int x, int y, int width, int height ) {
    super.setBounds( x, y, width, height );
    fm = getFontMetrics( MyFonts.ROBOTO_REGULAR.get( 24 ) );
    titleHeight = fm.getHeight();
    top = padding + titleHeight;
    bottom = getSize().height - padding;
    left = padding;
    right = getSize().width - padding;
  }

  @Override
  public void paint( Graphics g ) {
    g.setFont( MyFonts.ROBOTO_REGULAR.get( 24 ) );
    fm = getFontMetrics( MyFonts.ROBOTO_REGULAR.get( 24 ) );
    g.drawString( title, ( getSize().width - fm.stringWidth( title ) ) / 2, top - 7 );

    Graphics2D g2 = ( Graphics2D ) g;
    g2.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
                         RenderingHints.VALUE_ANTIALIAS_ON );

    w = ( right - left ) < ( bottom - top ) ? ( right - left ) : ( bottom - top );
    h = w;

    x = ( ( right + left ) / 2 ) - ( 0.5 * h );
    y = top;

    start = 90;
    extent = 0;
    int type = Arc2D.PIE;

    for ( GraphItem gi : items ) {
      // Create and draw the slice body
      g2.setColor( gi.color );
      extent = ( gi.value / total ) * 360;  // The slice of pie to bake
      g2.fill( new Arc2D.Double( x, y, w, h, start, extent, type ) );

      // Create and draw the slice outline
      g2.setColor( Color.BLACK ); // The color to use for the outline
      g2.setStroke( new BasicStroke( 2 ) );
      Arc2D.Double slice = new Arc2D.Double( x, y, w, h, start, extent, Arc2D.OPEN );
      g2.draw( slice );

      // Makes the next slice start at the end of the current slice
      start += extent;
    }
    drawLines( g );
  }

  /**
   * Used to draw the outlines of the pie chart.
   *
   * @param g The graphics object.
   */
  private void drawLines( Graphics g ) {
    Graphics2D g2 = ( Graphics2D ) g;

    for ( GraphItem gi : items ) {
      extent = ( gi.value / total ) * 360;  // The slice of pie to bake

      g2.setColor( Color.BLACK ); // The color to use for the outline
      Arc2D.Double slice = new Arc2D.Double( x, y, w, h, start, extent, Arc2D.OPEN );
      start += extent; // Makes the next slice start at the end of the current slice

      Point2D p = slice.getEndPoint();
      Rectangle b = slice.getBounds();
      Line2D l = new Line2D.Double( ( b.width / 2 ) + b.x,
                                    ( b.height / 2 ) + b.y,
                                    p.getX(),
                                    p.getY() );

      g2.setStroke( new BasicStroke( 1 ) );

      g2.draw( l );
    }
  }
}
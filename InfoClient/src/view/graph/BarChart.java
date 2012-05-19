package view.graph;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import view.util.MyFonts;

/**
 *
 * @author Thomas Baart <m.thomasbaart@gmail.com>
 */
public class BarChart extends Graph {

  int position, increment;

  public BarChart( String title, ArrayList<GraphItem> al ) {
    super( title, al );
  }

  @Override
  public void paint( Graphics g ) {
    super.paint( g );
    g.setFont( MyFonts.SANSATION_REGULAR.get() );
    fm = getFontMetrics( MyFonts.SANSATION_REGULAR.get() );
    padding = 10;
    increment = ( right - left - ( items.size() * padding ) ) / ( items.size() );
    position = left + padding;
    Color temp = g.getColor();
    for ( GraphItem gi : items ) {
      int adjustedValue = ( int ) ( bottom - ( ( ( gi.value - min ) * ( bottom - top ) )
                                               / ( max - min ) ) );
      g.drawString( Double.toString( gi.value ),
                    position + ( increment - fm.stringWidth( Double.toString( gi.value ) ) ) / 2,
                    adjustedValue - 2 );
      g.setColor( gi.color );
      g.fillRect( position, adjustedValue, increment,
                  bottom - adjustedValue );
      g.setColor( temp );
      g.drawRect( position, adjustedValue, increment, bottom - adjustedValue );
      position += increment + padding;
    }
  }
}
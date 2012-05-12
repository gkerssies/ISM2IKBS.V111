package view.util;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author Thomas Baart <m.thomasbaart@gmail.com>
 */
public class ViewBorders {

  public static final Border LINE_GRAY_1PX = BorderFactory.createLineBorder( Color.GRAY, 1 );
  public static final Border EMPTY_2PX = BorderFactory.createEmptyBorder( 2, 2, 2, 2 );
  public static final Border LINE_GRAY_1PX_EMPTY_2PX = new CompoundBorder( EMPTY_2PX, LINE_GRAY_1PX);
}

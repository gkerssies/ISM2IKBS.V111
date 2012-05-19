package view.util;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Enumeration containing often used fonts. Usage: MyFonts.FONTNAME.get(int
 * fontSize);
 *
 * @author Thomas Baart <m.thomasbaart@gmail.com>
 */
public enum MyFonts {

  SANSATION_BOLD_ITALIC( "Sansation_Bold_Italic.ttf" ),
  SANSATION_BOLD( "Sansation_Bold.ttf" ),
  SANSATION_ITALIC( "Sansation_Italic.ttf" ),
  SANSATION_LIGHT_ITALIC( "Sansation_Light_Italic.ttf" ),
  SANSATION_LIGHT( "Sansation_Light.ttf" ),
  SANSATION_REGULAR( "Sansation_Regular.ttf" ),
  GREYSCALE_BASIC_BOLD_ITALIC( "Greyscale_Basic_Bold_Italic.ttf" ),
  GREYSCALE_BASIC_BOLD( "Greyscale_Basic_Bold.ttf" ),
  GREYSCALE_BASIC_REGULAR_ITALIC( "Greyscale_Basic_Regular_Italic.ttf" ),
  GREYSCALE_BASIC_REGULAR( "Greyscale_Basic_Regular.ttf" ),
  ROBOTO_REGULAR( "Roboto_Regular.ttf" );
  private static final String fontsdirectory = "resources/fonts";
  private String fontFileName;
  private Font font;
  private Font defaultFont = new Font( Font.SANS_SERIF, Font.PLAIN, 12 );

  /**
   * Constructor of MyFonts. Generates a new Font object from the given file and
   * assigns it to this class font field. Use the
   * <code>get(int fontSize)</code> and
   * <code>get()</code> methods to access the font.
   *
   * @param fontFileName The filename of the .ttf file.
   */
  private MyFonts( String fontFileName ) {
    InputStream in = null;
    try {
      this.fontFileName = fontFileName;
      File f = new File( fontsdirectory, this.fontFileName );
      in = new FileInputStream( f );
      font = Font.createFont( Font.TRUETYPE_FONT, in );
    } catch ( FontFormatException ex ) {
      font = defaultFont;
      System.out.println( "FontFormatException in MyFonts.java. "
                          + "Custom font set to the default font."
                          + "\n" + ex.getMessage() );
    } catch ( IOException ex ) {
      font = defaultFont;
      System.out.println( "IOException in MyFonts.java. "
                          + "Custom font set to the default font."
                          + "\n" + ex.getMessage() );
    } finally {
      try {
        in.close();
      } catch ( IOException ex ) {
        font = defaultFont;
        System.out.println( "IOException in MyFonts.java. "
                            + "Custom font set to the default font." + "\n"
                            + ex.getMessage() );
      }
    }
  }

  /**
   * Gets the font in the specified size.
   *
   * @param fontSize The size for the new Font object, in points.
   *
   * @return The Font object for the specified size.
   */
  public Font get( int fontSize ) {
    Font derivenFont = this.font.deriveFont( Font.PLAIN, fontSize );
    return derivenFont;
  }

  /**
   * Gets the font in a 12 point size.
   *
   * @return The font object, 12 points.
   */
  public Font get() {
    Font derivenFont = this.font.deriveFont( Font.PLAIN, 12 );
    return derivenFont;
  }
}

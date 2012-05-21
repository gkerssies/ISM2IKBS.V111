package view.graph;

import java.awt.Color;

/**
 *
 * @author Thomas Baart <m.thomasbaart@gmail.com>
 */
public class GraphItem {

  protected String title;
  protected double value;
  protected Color color;

  public GraphItem( String title, double value, Color color ) {
    this.title = title;
    this.value = value;
    this.color = color;
  }
  @Override
  public String toString()
  {
    return this.title + " " + this.value +  " " + this.color;
  }
}
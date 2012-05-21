package view.dataview;

import com.sun.org.apache.bcel.internal.generic.IREM;
import gfy.NavQuery;
import gfy.NavQueryResultSet;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.text.html.parser.DTD;
import view.graph.BarChart;
import view.graph.GraphItem;
import view.graph.Legend;
import view.graph.PieChart;

/**
 *
 * @author Janssen-laptop
 */
public class GraphPanel extends JPanel {

  private NavQueryResultSet nqrs;
  private NavQuery nvq;

  public GraphPanel( NavQueryResultSet nqrs, NavQuery nvq,int t,int m ) {
    this.nqrs = nqrs;
    this.nvq = nvq;
    if (t == 1 && m == 1)
    {
    PaintBarQuery1();
    }
    if (t == 1 && m == 2)
    {
    paintPieQuery1();
    }
    
    if (t == 2 && m == 1)
    {
    PaintBarQuery2();
    }
    if (t == 2 && m == 2)
    {
    //paintPieQuery2();
    }
    
  }

  public void PaintBarQuery1() {
    setLayout( new BorderLayout() );
    ArrayList<ArrayList<String>> data = new ArrayList<>();
    Iterator itr = nqrs.getRow().listIterator();
    nqrs.getRow().size();
    ArrayList<GraphItem> graphItem = new ArrayList<>();
    for ( int i = 0; i < nqrs.getRow().size(); i++ ) {

      Vector<String> t = nqrs.getRow().get( i );

      for ( int y = 0; y < t.size(); y++ ) {
        String salesman = "";
        Double sales = 0.00;
        if ( y == 0 ) {
          salesman = t.get( y );
        }
        if ( y == 1 ) {
          sales = Double.parseDouble( t.get( y ) );
          GraphItem gi = new GraphItem( salesman, sales, getRandomColor() );
          graphItem.add( gi );
          System.out.println( "here " + sales );
        }


      }

    }

    BarChart bc = new BarChart( "Aantal klanten per verkoper", graphItem );
    Legend lg = new Legend( graphItem );
    
    this.add( lg, BorderLayout.SOUTH );
    this.add( bc, BorderLayout.CENTER );

  }
  
   public void PaintBarQuery2() {
    setLayout( new BorderLayout() );
    ArrayList<ArrayList<String>> data = new ArrayList<>();
    Iterator itr = nqrs.getRow().listIterator();
    nqrs.getRow().size();
    ArrayList<GraphItem> graphItem = new ArrayList<>();
    for ( int i = 0; i < nqrs.getRow().size(); i++ ) {

      Vector<String> t = nqrs.getRow().get( i );

      for ( int y = 0; y < t.size(); y++ ) {
        String title = "";
        Double value = 150.00;
        if ( y == 1 ) {
          title = t.get( y );
        }
        if ( y == 2 ) {
          value = Double.parseDouble( t.get( y ) );
          GraphItem gi = new GraphItem( title, value, getRandomColor() );
          graphItem.add( gi );
          System.out.println(value);
        }


      }

    }
    
    BarChart bc = new BarChart(nvq.getTitle(), graphItem );
     System.out.println(graphItem);
    Legend lg = new Legend( graphItem );
    this.add( lg, BorderLayout.SOUTH );
    this.add( bc, BorderLayout.CENTER );
    

  }
  
  
  public void paintPieQuery1()
  {
     setLayout( new BorderLayout() );
    ArrayList<ArrayList<String>> data = new ArrayList<>();
    Iterator itr = nqrs.getRow().listIterator();
    nqrs.getRow().size();
    ArrayList<GraphItem> graphItem = new ArrayList<>();
    for ( int i = 0; i < nqrs.getRow().size(); i++ ) {

      Vector<String> t = nqrs.getRow().get( i );

      for ( int y = 0; y < t.size(); y++ ) {
        String salesman = "";
        Double sales = 0.00;
        if ( y == 0 ) {
          salesman = t.get( y );
        }
        if ( y == 1 ) {
          sales = Double.parseDouble( t.get( y ) );
          GraphItem gi = new GraphItem( salesman, sales, getRandomColor() );
          graphItem.add( gi );
        }


      }

    }

    PieChart pc = new PieChart(nvq.getTitle(), graphItem);
    Legend lg = new Legend( graphItem );
    
    this.add( lg, BorderLayout.SOUTH );
    this.add( pc, BorderLayout.CENTER );
  }

  public Color getRandomColor() {
    Random randomGenerator = new Random();
    int red = randomGenerator.nextInt( 255 );
    int green = randomGenerator.nextInt( 255 );
    int blue = randomGenerator.nextInt( 255 );

    return new Color( red, green, blue );

  }
}

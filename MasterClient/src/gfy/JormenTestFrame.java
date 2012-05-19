/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gfy;

import InfoScreen.InfoFrame;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Janssen-laptop
 */
public class JormenTestFrame extends JFrame{
  
   public static void main( String[] args ) {
     //InfoFrame frame = new InfoFrame();
   }

  public JormenTestFrame()
   {
     setLayout(new FlowLayout());
     setVisible(true);
     FunctionPanel fp = new FunctionPanel();
     setContentPane(fp);
     setDefaultCloseOperation(3);
     
   }
   
  
  
}

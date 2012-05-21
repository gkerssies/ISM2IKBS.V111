/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;

/**
 *
 * @author Janssen-laptop
 */
public class StopScrollingHandler implements MouseListener{
  
  private Timer timer;
  public StopScrollingHandler(Timer timer)
  {
    this.timer = timer;
  }

  @Override
  public void mouseClicked( MouseEvent e ) {
    timer.stop();
  }

  @Override
  public void mousePressed( MouseEvent e ) {
    timer.stop();
  }

  @Override
  public void mouseReleased( MouseEvent e ) {
    
  }

  @Override
  public void mouseEntered( MouseEvent e ) {
    timer.stop();
  }

  @Override
  public void mouseExited( MouseEvent e ) {
    timer.start();
  }
  
}

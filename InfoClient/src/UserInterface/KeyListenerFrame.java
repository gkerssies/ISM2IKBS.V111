package UserInterface;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

/**
 * Custom JFrame that listens to pressed keys. Useful for making application
 * wide shortcuts.
 *
 * @author thomasbaart
 */
public class KeyListenerFrame extends JFrame {

  private class MyDispatcher implements KeyEventDispatcher {

    @Override
    public boolean dispatchKeyEvent( KeyEvent e ) {
      if ( e.getID() == KeyEvent.KEY_PRESSED ) {
      } else if ( e.getID() == KeyEvent.KEY_RELEASED ) {
      } else if ( e.getID() == KeyEvent.KEY_TYPED ) {
      }
      return false;
    }
  }

  public KeyListenerFrame() {
    KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
    manager.addKeyEventDispatcher( new UserInterface.KeyListenerFrame.MyDispatcher() );
  }
}

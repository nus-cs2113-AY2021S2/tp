package seedu.duke.editor;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ShortcutListener implements KeyListener {

    JFrame frame;
    
    public ShortcutListener(JFrame frame) {
        this.frame = frame;
    }    
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            //Close text editor
            frame.dispose();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

package seedu.duke.editor;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ShortcutListener implements KeyListener {

    JFrame frame;
    boolean isCtrlPressed = false;
    boolean isSPressed = false;
    
    public ShortcutListener(JFrame frame) {
        this.frame = frame;
    }    
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_ESCAPE: {
            //Close text editor
            frame.dispose();
            break;
        }
        case KeyEvent.VK_CONTROL: {
            isCtrlPressed = true;
            checkSaveShortcut();
            break;
        }
        case 83: {
            isSPressed = true;
            checkSaveShortcut();
            break;
        }
        default:
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_CONTROL: {
            isCtrlPressed = false;
            break;
        }
        case 83: {
            isSPressed = false;
            break;
        }
        default:
        }
    }

    /**
     * Checks if keys for save shortcut are pressed.
     * Calls save file method if true.
     */
    void checkSaveShortcut() {
        if (isSPressed && isCtrlPressed) {
            isCtrlPressed = false;
            isSPressed = false;
            //Save
            
        }
    }
}

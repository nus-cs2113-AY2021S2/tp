package seedu.duke.editor;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static seedu.duke.common.Constants.KEYCODE_S;

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
        case KEYCODE_S: {
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
        case KEYCODE_S: {
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

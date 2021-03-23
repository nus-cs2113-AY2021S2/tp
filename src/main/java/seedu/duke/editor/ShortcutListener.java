package seedu.duke.editor;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static seedu.duke.common.Constants.KEYCODE_DOWN;
import static seedu.duke.common.Constants.KEYCODE_UP;
import static seedu.duke.common.Constants.KEYCODE_S;

public class ShortcutListener implements KeyListener {

    JFrame frame;
    TextEditor textEditor;
    boolean isCtrlPressed = false;
    boolean isSPressed = false;
    boolean isPlusPressed = false;
    boolean isMinusPressed = false;

    public ShortcutListener(JFrame frame, TextEditor editor) {
        this.frame = frame;
        this.textEditor = editor;
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
        case KEYCODE_UP: {
            isPlusPressed = true;
            checkZoomShortcut();
            break;
        }
        case KEYCODE_DOWN: {
            isMinusPressed = true;
            checkZoomShortcut();
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
        case KEYCODE_UP: {
            isPlusPressed = false;
            break;
        }
        case KEYCODE_DOWN: {
            isMinusPressed = false;
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
            isSPressed = false;
            //Save
            textEditor.saveTextToFile();
        }
    }

    /**
     * Check if keys for zoom shortcut are pressed.
     * Calls save file method if true.
     */
    void checkZoomShortcut() {
        if (!isCtrlPressed) {
            return;
        }
        if (isMinusPressed && isPlusPressed) {
            return;
        }
        if (isPlusPressed) {
            isPlusPressed = false;
            //Increase font size
            textEditor.increaseFontSize();
        } else if (isMinusPressed) {
            isMinusPressed = false;
            //Decrease font size
            textEditor.decreaseFontSize();
        }
    }
}

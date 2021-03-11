package seedu.duke;

import ManagerClasses.InputManager;
import ManagerClasses.UIManager;

public class NUSMaze {
    public static void main(String[] args) {
        UIManager.showLogo();
        UIManager.showGreetMessage();

        InputManager inputManager = new InputManager();
        inputManager.inputLoop();
    }
}

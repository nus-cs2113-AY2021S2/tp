package seedu.duke;

import ManagerClasses.InputManager;
import ManagerClasses.UIManager;

import java.util.Scanner;


public class NUSMaze {
    public static void main(String[] args) {
        UIManager.showLogo();
        UIManager.showGreetMessage();

        InputManager inputManager = new InputManager();
        inputManager.inputLoop();
    }








}

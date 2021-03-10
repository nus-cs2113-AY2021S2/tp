package ManagerClasses;

import java.util.Scanner;

public class InputManager {
    private String getUserInput() {
        System.out.print("> ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        UIManager.printDivider();
        return input;
    }

    public void inputLoop() {
        while(true) {
            String input = getUserInput();
            CommandManager commandManager = new CommandManager(input);

            switch (commandManager.getCommandType()) {
            case GO:
                break;
            case HISTORY:
                break;
            case CLEARHISTORY:
                break;
            case ADDNOTE:
                break;
            case DELETENOTE:
                break;
            case DISPLAYNOTES:
                break;
            case BYE:
                UIManager.showByeMessage();
                return;
            default:
                UIManager.showInvalidMessage();
            }
            UIManager.printDivider();
        }
    }
}

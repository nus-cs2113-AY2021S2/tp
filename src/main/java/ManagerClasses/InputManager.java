package ManagerClasses;

import seedu.duke.Record;
import seedu.duke.Routing;

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
            Routing map = new Routing();
            Record history = new Record();

            switch (commandManager.getCommandType()) {
            case GO:
                map.executeRouting();
                // todo: add records
                break;
            case HISTORY:
                history.displayRecords();
                break;
            case CLEARHISTORY:
                history.emptyRecords();
                break;
            case ADDNOTE:
                System.out.println("Add note to the selected location");
                break;
            case DELETENOTE:
                System.out.println("Delete note from selected location");
                break;
            case DISPLAYNOTES:
                System.out.println("Display notes of selected location");
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

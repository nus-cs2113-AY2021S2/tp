package ManagerClasses;

import seedu.duke.Record;
import seedu.duke.Router;

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
            Router map = new Router();
            Record history = new Record();

            switch (commandManager.getCommandType()) {
            case GoCommand:
                map.execute(history);
                // todo: add records
                break;
            case ShowHistoryCommand:
                history.displayRecords();
                break;
            case ClearHistoryCommand:
                history.emptyRecords();
                break;
            case AddNoteCommand:
                System.out.println("Add note to the selected location");
                break;
            case DeleteNoteCommand:
                System.out.println("Delete note from selected location");
                break;
            case DisplayNotesCommand:
                System.out.println("Display notes of selected location");
                break;
            case ByeCommand:
                UIManager.showByeMessage();
                return;
            default:
                UIManager.showInvalidMessage();
            }
            UIManager.printDivider();
        }
    }
}

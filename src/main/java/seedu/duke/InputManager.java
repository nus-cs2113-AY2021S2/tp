package seedu.duke;

import java.util.Scanner;

public class InputManager {

    NotesManager notesManager = new NotesManager();

    private String getUserInput() {
        System.out.print("> ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        UiManager.printDivider();
        return input;
    }

    public void inputLoop() {
        while (true) {
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
                notesManager.parseAddNotesCommandAndAddNotes(input);
                break;
            case DeleteNoteCommand:
                notesManager.parseDeleteNotesCommandAndDeleteNotes(input);
                break;
            case DisplayNotesCommand:
                notesManager.parseListNotesCommandAndListNotes(input);
                break;
            case ByeCommand:
                UiManager.showByeMessage();
                return;
            default:
                UiManager.showInvalidMessage();
            }
            UiManager.printDivider();
        }
    }
}

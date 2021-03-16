package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.routing.Router;

public class Duke {

    private Router router;
    private UiManager ui;
    private History history;
    private NotesManager notesManager;


    public static void main(String[] args) {
        new Duke().run();
    }

    private void run() {
        this.router = new Router();
        this.ui = new UiManager();
        this.history = new History();
        this.notesManager = new NotesManager();
        ui.showGreetMessage();
        runCommandLoopUntilByeCommand();
    }

    public void runCommandLoopUntilByeCommand() {
        boolean isExit = false;
        while (!isExit) {
            try {
                String input = ui.getUserInput();
                Command command = Parser.prepareForCommandExecution(input);
                command.execute(router, ui, history, notesManager);
                isExit = command.isExit();
            } catch (InvalidCommandException e) {
                ui.showToUser(e.getMessage());
            }
        }
    }
}

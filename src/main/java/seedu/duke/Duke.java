package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.routing.Map;

public class Duke {

    private Map nusMap;
    private UiManager ui;
    private History history;
    private NotesManager notesManager;
    private DailyRoute dailyroute;

    public static void main(String[] args) {
        new Duke().run();
    }

    private void run() {
        initializeDuke();
        ui.showLogo();
        ui.showGreetMessage();
        runCommandLoopUntilByeCommand();
    }

    private void initializeDuke() {
        this.nusMap = new Map();
        this.ui = new UiManager();
        this.history = new History();
        this.notesManager = new NotesManager();
        this.dailyroute = new DailyRoute();
    }

    public void runCommandLoopUntilByeCommand() {
        boolean isExit = false;
        while (!isExit) {
            try {
                String input = ui.getUserInput();
                Command command = Parser.prepareForCommandExecution(input);
                command.execute(nusMap, ui, history, notesManager, dailyroute);
                isExit = command.isExit();
            } catch (InvalidCommandException e) {
                ui.showToUser(e.getMessage());
            }
        }
    }
}

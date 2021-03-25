package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.exception.InvalidCommandException;

public class Duke {

    private Map nusMap;
    private UiManager ui;
    private History history;
    private DailyRoute dailyroute;
    private FavouriteLocation favouriteLocation;
    private BlockAlias blockAlias;

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
        this.dailyroute = new DailyRoute();
        this.blockAlias = new BlockAlias();
        this.favouriteLocation = new FavouriteLocation();
    }

    public void runCommandLoopUntilByeCommand() {
        boolean isExit = false;
        while (!isExit) {
            try {
                String input = ui.getUserInput();
                Command command = Parser.prepareForCommandExecution(input);
                command.execute(nusMap, ui, history, dailyroute, blockAlias, favouriteLocation);
                isExit = command.isExit();
            } catch (InvalidCommandException e) {
                ui.showToUser(e.getMessage());
            }
        }
    }
}

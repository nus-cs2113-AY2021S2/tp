package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.storage.DailyRouteStorage;
import seedu.duke.storage.AliasStorage;
import seedu.duke.storage.FavouriteLocationsStorage;
import seedu.duke.storage.NotesStorage;
import seedu.duke.storage.HistoryRouteStorage;
import seedu.duke.storage.Storage;
import seedu.duke.ui.UiManager;

import java.io.IOException;

public class Duke {

    private Map nusMap;
    private UiManager ui;
    private History history;
    private DailyRoute dailyroute;
    private FavouriteLocation favouriteLocation;
    private BlockAlias blockAlias;
    private Storage notesStorage;
    private Storage favLocationStorage;
    private Storage historyStorage;
    private Storage aliasStorage;
    private Storage dailyRouteStorage;

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
        try {
            this.nusMap = new Map();
            this.ui = new UiManager();
            this.history = new History();
            this.dailyroute = new DailyRoute();
            this.blockAlias = new BlockAlias();
            this.favouriteLocation = new FavouriteLocation();


            dailyRouteStorage = new DailyRouteStorage("data/dailyRouteList.txt");
            dailyRouteStorage.loadDailyRoute(dailyroute); //load all history
            notesStorage = new NotesStorage("data/notesList.txt");
            notesStorage.loadNotes(nusMap); //load notes into new notesList for each location
            favLocationStorage = new FavouriteLocationsStorage("data/favouritesList.txt");
            favLocationStorage.loadFavourites(favouriteLocation); //load all favourite locations
            historyStorage = new HistoryRouteStorage("data/historyList.txt");
            historyStorage.loadHistory(history); //load all history
            aliasStorage = new AliasStorage("data/aliasList.txt");
            aliasStorage.loadAlias(blockAlias); //load all alias
        } catch (IOException e) {
            ui.showToUser(e.getMessage());
        }
    }

    public void runCommandLoopUntilByeCommand() {
        boolean isExit = false;
        while (!isExit) {
            try {
                String input = ui.getUserCommandInput();
                Command command = Parser.prepareForCommandExecution(input);
                command.execute(nusMap, ui, history, dailyroute, blockAlias, favouriteLocation);
                isExit = command.isExit();
                notesStorage.overwriteNotesListFile(nusMap);
                favLocationStorage.overwriteFavouritesListFile(favouriteLocation);
                dailyRouteStorage.overwriteDailyRouteFile(dailyroute);
                historyStorage.overwriteHistoryListFile(history);
                aliasStorage.overwriteAliasListFile(blockAlias);
            } catch (InvalidCommandException e) {
                ui.showToUser(e.getMessage());
            }
        }
    }

}

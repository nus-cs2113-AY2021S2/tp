package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.data.*;
import seedu.duke.exception.NusMazeException;
import seedu.duke.storage.DailyRouteStorage;
import seedu.duke.storage.AliasStorage;
import seedu.duke.storage.FavouriteLocationsStorage;
import seedu.duke.storage.NotesStorage;
import seedu.duke.storage.HistoryRouteStorage;
import seedu.duke.storage.Storage;
import seedu.duke.ui.UiManager;

import java.io.IOException;

public class NusMaze {

    private NusMap nusMap;
    private UiManager ui;
    private BlockAlias blockAlias;
    private History history;
    private Favourite favourite;
    private DailyRoute dailyroute;

    private Storage aliasStorage;
    private Storage historyStorage;
    private Storage favLocationStorage;
    private Storage dailyRouteStorage;
    private Storage notesStorage;

    public static void main(String[] args) {
        new NusMaze().run();
    }

    private void run() {
        initializeDuke();
        ui.showLogo();
        ui.showGreetMessage();
        runCommandLoopUntilByeCommand();
    }

    private void initializeDuke() {
        try {
            this.nusMap = new NusMap();
            this.ui = new UiManager();
            this.blockAlias = new BlockAlias();
            this.history = new History();
            this.favourite = new Favourite();
            this.dailyroute = new DailyRoute();

            dailyRouteStorage = new DailyRouteStorage("data/dailyRouteList.txt");
            dailyRouteStorage.loadDailyRoute(dailyroute); //load all history
            notesStorage = new NotesStorage("data/notesList.txt");
            notesStorage.loadNotes(nusMap); //load notes into new notesList for each location
            favLocationStorage = new FavouriteLocationsStorage("data/favouritesList.txt");
            favLocationStorage.loadFavourites(favourite); //load all favourite locations
            historyStorage = new HistoryRouteStorage("data/historyList.txt");
            historyStorage.loadHistory(history); //load all history
            aliasStorage = new AliasStorage("data/aliasList.txt");
            aliasStorage.loadAlias(blockAlias); //load all alias
        } catch (IOException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }

    private void runCommandLoopUntilByeCommand() {
        boolean isExit = false;
        while (!isExit) {
            try {
                String input = ui.getUserCommandInput();
                Command command = Parser.prepareForCommandExecution(input);
                command.setData(nusMap, blockAlias, history, favourite, dailyroute);
                command.execute();
                notesStorage.overwriteNotesListFile(nusMap);
                favLocationStorage.overwriteFavouritesListFile(favourite);
                dailyRouteStorage.overwriteDailyRouteFile(dailyroute);
                historyStorage.overwriteHistoryListFile(history);
                aliasStorage.overwriteAliasListFile(blockAlias);
                isExit = command.isExit();
            } catch (NusMazeException e) {
                ui.showMessageWithDivider(e.getMessage());
            }
        }
    }
}

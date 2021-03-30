package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.data.BlockAlias;
import seedu.duke.data.DailyRoute;
import seedu.duke.data.Favourite;
import seedu.duke.data.History;
import seedu.duke.data.NusMap;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.parser.Parser;
import seedu.duke.storage.DailyRouteStorage;
import seedu.duke.storage.AliasStorage;
import seedu.duke.storage.FavouriteStorage;
import seedu.duke.storage.NotesStorage;
import seedu.duke.storage.HistoryStorage;
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
    private Storage favouriteStorage;
    private Storage dailyRouteStorage;
    private Storage notesStorage;

    public static void main(String[] args) {
        new NusMaze().run();
    }

    private void run() {
        initializeNusMaze();
        ui.showLogo();
        ui.showGreetMessage();
        runCommandLoopUntilByeCommand();
    }

    private void initializeNusMaze() {
        try {
            initializeData();
            initializeStorage();
            loadPreviousData();
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
                saveCurrentData();
                isExit = command.isExit();
            } catch (InvalidCommandException e) {
                ui.showMessageWithDivider(e.getMessage());
            }
        }
    }

    private void initializeData() {
        nusMap = new NusMap();
        ui = new UiManager();
        blockAlias = new BlockAlias();
        history = new History();
        favourite = new Favourite();
        dailyroute = new DailyRoute();
    }

    private void initializeStorage() {
        aliasStorage = new AliasStorage("data/aliasList.txt");
        historyStorage = new HistoryStorage("data/historyList.txt");
        favouriteStorage = new FavouriteStorage("data/favouritesList.txt");
        dailyRouteStorage = new DailyRouteStorage("data/dailyRouteList.txt");
        notesStorage = new NotesStorage("data/notesList.txt");
    }

    private void loadPreviousData() throws IOException {
        aliasStorage.loadAlias(blockAlias); //load all alias
        historyStorage.loadHistory(history); //load all history
        favouriteStorage.loadFavourites(favourite); //load all favourite locations
        dailyRouteStorage.loadDailyRoute(dailyroute); //load all history
        notesStorage.loadNotes(nusMap); //load notes into new notesList for each location
    }

    private void saveCurrentData() {
        aliasStorage.overwriteAliasListFile(blockAlias);
        historyStorage.overwriteHistoryListFile(history);
        favouriteStorage.overwriteFavouritesListFile(favourite);
        dailyRouteStorage.overwriteDailyRouteFile(dailyroute);
        notesStorage.overwriteNotesListFile(nusMap);
    }
}

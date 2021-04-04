package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.data.BlockAlias;
import seedu.duke.data.DailyRoute;
import seedu.duke.data.Favourite;
import seedu.duke.data.History;
import seedu.duke.data.NusMap;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.exception.InvalidFilePathException;
import seedu.duke.exception.LoadDataException;
import seedu.duke.exception.SaveDataException;
import seedu.duke.exception.StorageOperationException;
import seedu.duke.parser.Parser;
import seedu.duke.storage.datastorage.DailyRouteStorage;
import seedu.duke.storage.datastorage.AliasStorage;
import seedu.duke.storage.datastorage.FavouriteStorage;
import seedu.duke.storage.datastorage.NotesStorage;
import seedu.duke.storage.datastorage.HistoryStorage;
import seedu.duke.storage.Storage;
import seedu.duke.ui.CommonMessage;
import seedu.duke.ui.UiManager;

public class NusMaze {

    private NusMap nusMap;
    private UiManager ui;
    private BlockAlias blockAlias;
    private History history;
    private Favourite favourite;
    private DailyRoute dailyRoute;
    private Storage[] storages;

    public static void main(String[] args) {
        new NusMaze().run();
    }

    private void run() {
        initializeNusMaze();
        runCommandLoopUntilByeCommand();
    }

    private void initializeNusMaze() {
        try {
            initializeData();
            initializeStorage();
            setStorageData();
            ui.showLogo();
            loadPreviousData();
            ui.showGreetMessage();
        } catch (StorageOperationException e) {
            ui.showMessageWithDivider(e.getMessage());
        }
    }

    private void runCommandLoopUntilByeCommand() {
        boolean isExit = false;
        while (!isExit) {
            try {
                String input = ui.getUserCommandInput();
                Command command = Parser.prepareForCommandExecution(input);
                command.setData(nusMap, blockAlias, history, favourite, dailyRoute);
                command.execute();
                saveCurrentData();
                isExit = command.isExit();
            } catch (InvalidCommandException | SaveDataException e) {
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
        dailyRoute = new DailyRoute();
    }

    private void initializeStorage() throws InvalidFilePathException {
        Storage aliasStorage = new AliasStorage("data/aliasList.txt");
        Storage historyStorage = new HistoryStorage("data/history.txt");
        Storage favouriteStorage = new FavouriteStorage("data/favouriteList.txt");
        Storage dailyRouteStorage = new DailyRouteStorage("data/dailyRouteList.txt");
        Storage notesStorage = new NotesStorage("data/noteList.txt");
        storages = new Storage[]{aliasStorage, historyStorage, favouriteStorage, dailyRouteStorage, notesStorage};
    }

    private void setStorageData() {
        for (Storage storage : storages) {
            storage.setData(nusMap, blockAlias, history, favourite, dailyRoute);
        }
    }

    private void loadPreviousData() throws SaveDataException {
        for (Storage storage : storages) {
            try {
                storage.loadData();
                ui.showLoadSuccessMessage(storage.getStorageName());
            } catch (LoadDataException e) {
                ui.showMessage(String.format(e.getMessage(), storage.getStorageName()));
                storage.saveData();
            }
        }
        ui.showMessage(CommonMessage.DIVIDER);
    }

    private void saveCurrentData() throws SaveDataException {
        for (Storage storage : storages) {
            storage.saveData();
        }
    }
}

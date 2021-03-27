package seedu.duke;

import seedu.duke.command.Command;
import seedu.duke.exception.InvalidCommandException;
import seedu.duke.storage.FavouriteLocationsStorage;
import seedu.duke.storage.NotesStorage;
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

    public static void main(String[] args) {
        new Duke().run();
    }

    private void run() {
        initializeDuke("data/notesList.txt", "data/favouritesList.txt");
        ui.showLogo();
        ui.showGreetMessage();
        runCommandLoopUntilByeCommand();
    }

    private void initializeDuke(String notesFilepath, String favouritesFilepath) {
        try {
            this.nusMap = new Map();
            this.ui = new UiManager();
            this.history = new History();
            this.dailyroute = new DailyRoute();
            this.blockAlias = new BlockAlias();
            this.favouriteLocation = new FavouriteLocation();

            notesStorage = new NotesStorage(notesFilepath);
            notesStorage.loadNotes(nusMap); //load notes into new notesList for each location
            favLocationStorage = new FavouriteLocationsStorage(favouritesFilepath);
            favLocationStorage.loadFavourites(favouriteLocation); //load all favourite locations

            //can add 2 lines related to each class here - 4 lines total
            //can remove these 2 comments after seen
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
                //add overwrite call for 2 classes here - 2 lines total
                //can remove after seen
            } catch (InvalidCommandException e) {
                ui.showToUser(e.getMessage());
            }
        }
    }

}

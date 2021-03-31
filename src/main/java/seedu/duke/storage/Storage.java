package seedu.duke.storage;

import seedu.duke.data.BlockAlias;
import seedu.duke.data.DailyRoute;
import seedu.duke.data.Favourite;
import seedu.duke.data.History;
import seedu.duke.data.NusMap;

import java.io.IOException;

public abstract class Storage {

    public String filepath;

    public Storage(String filepath) {
        this.filepath = filepath;
    }

    public void loadNotes(NusMap nusMap) throws IOException {
    }

    public void overwriteNotesListFile(NusMap nusMap) {

    }

    public void loadFavourites(Favourite favourite) throws IOException  {

    }

    public void overwriteFavouritesListFile(Favourite favourite) {

    }

    public void loadHistory(History history) throws IOException {

    }

    public void overwriteHistoryListFile(History history) {

    }

    public void loadAlias(BlockAlias blockAlias) throws IOException  {

    }

    public void overwriteAliasListFile(BlockAlias blockAlias) {

    }

    public void loadDailyRoute(DailyRoute dailyRoute) throws IOException  {

    }

    public void overwriteDailyRouteFile(DailyRoute dailyRoute) {
    }
}

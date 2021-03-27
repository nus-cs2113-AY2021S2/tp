package seedu.duke.storage;

import seedu.duke.BlockAlias;
import seedu.duke.DailyRoute;
import seedu.duke.FavouriteLocation;
import seedu.duke.History;
import seedu.duke.Map;

import java.io.IOException;

public abstract class Storage {

    public String filepath;

    public Storage(String filepath) {
        this.filepath = filepath;
    }

    public void loadNotes(Map nusMap) throws IOException {
    }

    public void overwriteNotesListFile(Map nusMap) {

    }

    public void loadFavourites(FavouriteLocation favouriteLocation) throws IOException  {

    }

    public void overwriteFavouritesListFile(FavouriteLocation favouriteLocation) {

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

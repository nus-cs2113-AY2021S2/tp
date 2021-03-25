package seedu.duke.storage;

import seedu.duke.FavouriteLocation;
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

    //Step 1.
    // can add 2 classes like NotesStorage Class under 'Storage' folder
    // containing functions like 'loadHistory, overwriteHistoryListFile'
    // suggested names: `RoutesHistoryStorage` and `FavouriteLocationsStorage`

    //Step 2.
    //can add total of 4 methods here for the other 2 classes - alias and history (storage classes)
    //can remove all the above comments after seen

    //Step 3.
    //Edit duke - can follow my comments :)) thanks!! :))

    //can remove all the above comments

}

//@@author KimIdeas8

package seedu.duke.storage.datastorage;

import seedu.duke.exception.InvalidFilePathException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.exception.LoadDataException;
import seedu.duke.exception.SaveDataException;
import seedu.duke.storage.Storage;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a storage location for a given file path.
 * A <code>HistoryStorage</code> object corresponds to an instance of a location which
 * Saves to 'history' list from History Class.
 * Loads from History text file.
 */
public class HistoryStorage extends Storage {
    public HistoryStorage(String filepath) throws InvalidFilePathException {
        super(filepath);
        storageName = "History";
    }

    /**
     * Saves the data from the 'history' list from 'History'.
     * into the location with the filepath associated with the object.
     * @throws SaveDataException - if there is error with saving file into location with filepath
     */
    @Override
    public void saveData() throws SaveDataException {
        try {
            ArrayList<String> encodedData = encodeHistory(history);
            Files.write(filepath, encodedData);
        } catch (IOException | InvalidIndexException e) {
            throw new SaveDataException();
        }
    }

    /**
     * Loads the data from the location with the filepath associated with the object
     * into the 'history' list from 'History'.
     * @throws LoadDataException - if there is error with saving file into location with filepath
     */
    @Override
    public void loadData() throws LoadDataException {
        try {
            Scanner s = new Scanner(filepath);
            while (s.hasNext()) {
                String encodedData = s.nextLine();
                String[] decodedData = decodeHistoryAndFavouriteData(encodedData, nusMap);
                history.addHistory(decodedData[0], decodedData[1]);
            }
        } catch (IOException e) {
            throw new LoadDataException();
        }
    }
}

//@@author SimBowen

package seedu.duke.storage.datastorage;

import seedu.duke.exception.InvalidFilePathException;
import seedu.duke.exception.LoadDataException;
import seedu.duke.exception.SaveDataException;
import seedu.duke.storage.Storage;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a storage location for a given file path.
 * A <code>DailyRouteStorageStorage</code> object corresponds to an instance of a location which
 * Saves to 'days' list from Daily Route.
 * Loads from DailyRouteList text file.
 */
public class DailyRouteStorage extends Storage {

    public DailyRouteStorage(String filepath) throws InvalidFilePathException {
        super(filepath);
        storageName = "Daily Route";
    }

    /**
     * Saves the data from the 'day' list from Daily Route
     * into the location with the filepath associated with the object.
     * @throws SaveDataException - if there is error with saving file into location with filepath
     */
    @Override
    public void saveData() throws SaveDataException {
        try {
            ArrayList<String> encodedData = encodeDailyRoute(dailyRoute);
            Files.write(filepath, encodedData);
        } catch (IOException e) {
            throw new SaveDataException();
        }
    }

    /**
     * Loads the data from the location with the filepath associated with the object
     * into the 'days' list from Daily Route.
     * @throws LoadDataException - if there is error with saving file into location with filepath
     */
    @Override
    public void loadData() throws LoadDataException {
        try {
            Scanner s = new Scanner(filepath);
            while (s.hasNext()) {
                String encodedData = s.nextLine();
                String[] decodedData = decodeDailyRouteData(encodedData, nusMap, dailyRoute);
                ArrayList<String> schedule = new ArrayList<>();
                for (int i = 1; i < decodedData.length; i++) {
                    schedule.add(decodedData[i]);
                }
                dailyRoute.addDailyRoute(decodedData[0], schedule);
            }
        } catch (IOException e) {
            throw new LoadDataException();
        }
    }
}

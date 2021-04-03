//@@author SimBowen

package seedu.duke.storage.datastorage;

import seedu.duke.exception.InvalidFilePathException;
import seedu.duke.exception.LoadDataException;
import seedu.duke.exception.SaveDataException;
import seedu.duke.storage.DataDecoder;
import seedu.duke.storage.DataEncoder;
import seedu.duke.storage.Storage;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class DailyRouteStorage extends Storage {

    public DailyRouteStorage(String filepath) throws InvalidFilePathException {
        super(filepath);
    }

    @Override
    public void saveData() throws SaveDataException {
        try {
            ArrayList<String> encodedData = encodeDailyRoute(dailyRoute);
            Files.write(filepath, encodedData);
        } catch (IOException e) {
            throw new SaveDataException();
        }
    }

    @Override
    public void loadData() throws LoadDataException {
        try {
            Scanner s = new Scanner(filepath);
            while (s.hasNext()) {
                String encodedData = s.nextLine();
                String[] decodedData = decodeData(encodedData);
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

//@@author KimIdeas8

package seedu.duke.storage.datastorage;

import seedu.duke.exception.InvalidFilePathException;
import seedu.duke.exception.InvalidIndexException;
import seedu.duke.exception.LoadDataException;
import seedu.duke.exception.SaveDataException;
import seedu.duke.storage.DataDecoder;
import seedu.duke.storage.DataEncoder;
import seedu.duke.storage.Storage;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class HistoryStorage extends Storage {
    public HistoryStorage(String filepath) throws InvalidFilePathException {
        super(filepath);
    }

    @Override
    public void saveData() throws SaveDataException {
        try {
            ArrayList<String> encodedData = new DataEncoder().encodeHistory(history);
            Files.write(filepath, encodedData);
        } catch (IOException | InvalidIndexException e) {
            throw new SaveDataException();
        }
    }

    @Override
    public void loadData() throws LoadDataException {
        try {
            Scanner s = new Scanner(filepath);
            while (s.hasNext()) {
                String encodedData = s.nextLine();
                String[] decodedData = new DataDecoder().decodeData(encodedData);
                history.addHistory(decodedData[0], decodedData[1]);
            }
        } catch (IOException e) {
            throw new LoadDataException();
        }
    }
}

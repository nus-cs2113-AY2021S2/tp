//@@author Rizavur

package seedu.duke.storage.datastorage;

import seedu.duke.exception.InvalidAliasException;
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

public class AliasStorage extends Storage {

    public AliasStorage(String filepath) throws InvalidFilePathException {
        super(filepath);
    }

    @Override
    public void saveData() throws SaveDataException {
        try {
            ArrayList<String> encodedData = new DataEncoder().encodeAlias(blockAlias);
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
                String[] decodedData = new DataDecoder().decodeData(encodedData);
                blockAlias.addAlias(decodedData[1], decodedData[0]);
            }
        } catch (IOException | InvalidAliasException e) {
            throw new LoadDataException();
        }
    }
}

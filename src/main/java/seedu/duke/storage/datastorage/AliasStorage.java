//@@author Rizavur

package seedu.duke.storage.datastorage;

import seedu.duke.exception.InvalidAliasException;
import seedu.duke.exception.InvalidFilePathException;
import seedu.duke.exception.LoadDataException;
import seedu.duke.exception.SaveDataException;
import seedu.duke.storage.Storage;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

public class AliasStorage extends Storage {

    public AliasStorage(String filepath) throws InvalidFilePathException {
        super(filepath);
        storageName = "Alias";
    }

    @Override
    public void saveData() throws SaveDataException {
        try {
            ArrayList<String> encodedData = encodeAlias(blockAlias);
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
                String[] decodedData = decodeAliasAndNoteData(encodedData, nusMap);
                blockAlias.addAlias(decodedData[0], decodedData[1]);
            }
        } catch (IOException | InvalidAliasException e) {
            throw new LoadDataException();
        }
    }
}

//@@author KimIdeas8

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

public class NotesStorage extends Storage {

    public NotesStorage(String filepath) throws InvalidFilePathException {
        super(filepath);
    }

    @Override
    public void saveData() throws SaveDataException {
        try {
            ArrayList<String> encodedData = new DataEncoder().encodeNotes(nusMap);
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
                nusMap.getBlock(decodedData[0]).addNote(decodedData[1]);
            }
        } catch (IOException e) {
            throw new LoadDataException();
        }
    }
}

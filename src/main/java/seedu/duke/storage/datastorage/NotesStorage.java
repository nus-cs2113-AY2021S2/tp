//@@author KimIdeas8

package seedu.duke.storage.datastorage;

import seedu.duke.exception.InvalidFilePathException;
import seedu.duke.exception.InvalidNoteException;
import seedu.duke.exception.LoadDataException;
import seedu.duke.exception.SaveDataException;

import seedu.duke.storage.Storage;

import java.io.IOException;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a storage location for a given file path.
 * A <code>NotesStorage</code> object corresponds to an instance of a location which
 * Saves to 'notes' list from History Class.
 * Loads from NotesList text file.
 */
public class NotesStorage extends Storage {

    public NotesStorage(String filepath) throws InvalidFilePathException {
        super(filepath);
        storageName = "Note";
    }

    /**
     * Saves the data from the 'notes' list from 'Block'.
     * into the location with the filepath associated with the object.
     * @throws SaveDataException - if there is error with saving file into location with filepath
     */
    @Override
    public void saveData() throws SaveDataException {
        try {
            ArrayList<String> encodedData = encodeNotes(nusMap);
            Files.write(filepath, encodedData);
        } catch (IOException e) {
            throw new SaveDataException();
        }
    }

    /**
     * Loads the data from the location with the filepath associated with the object
     * into the 'notes' list from 'Block'.
     * @throws LoadDataException - if there is error with saving file into location with filepath
     */
    @Override
    public void loadData() throws LoadDataException {
        try {
            Scanner s = new Scanner(filepath);
            while (s.hasNext()) {
                String encodedData = s.nextLine();
                String[] decodedData = decodeAliasAndNoteData(encodedData, nusMap);
                nusMap.getBlock(decodedData[0]).addNote(decodedData[1]);
            }
        } catch (IOException | InvalidNoteException e) {
            throw new LoadDataException();
        }
    }
}

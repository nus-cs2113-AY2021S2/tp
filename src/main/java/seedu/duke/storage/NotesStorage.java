package seedu.duke.storage;

import seedu.duke.data.Block;
import seedu.duke.data.NusMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.Map;
import java.util.Scanner;

public class NotesStorage extends Storage {

    public NotesStorage(String path) {
        super(path);
    }

    /**
     * If file with given filepath (by user) exists, it loads older data from that file into the 'tasks' list.
     * Else, creates a new file (in a new directory) with the given filepath.
     * In both cases, the file which exists or may have been created
     * is used to store the tasks, including older tasks.
     *
     * @throws IOException if the creation of new non-existent file was not successful.
     */
    public void loadNotes(NusMap nusMap) throws IOException {
        try {
            Scanner s = new Scanner(new File(this.filepath)); // create a Scanner using the File as the source
            // add note for all locations:
            while (s.hasNext()) {
                String[] prevListEntryWord = s.nextLine().split("/");
                nusMap.getBlock(prevListEntryWord[0]).addNote(prevListEntryWord[1]);
                //add note from previous list to new list
            }
        } catch (FileNotFoundException e) {
            //Split given filepath by "/":
            String[] storagePathArray = this.filepath.split("/");
            //For the first time, create a new file for the user:
            File dataDirectory = new File(storagePathArray[0]);
            dataDirectory.mkdir();
            File dukeFile = new File(storagePathArray[0], storagePathArray[1]); //File(parent, child)
            dukeFile.createNewFile();
        }
    }

    /**
     * Clears the file in the given filepath and
     * re-assigns all the tasks in the updated 'tasks' list to the given filepath.
     */
    public void overwriteNotesListFile(NusMap nusMap) {
        //write to file:
        try {
            PrintWriter writer = new PrintWriter(this.filepath);
            writer.print("");
            writer.close();
            for (Block block : nusMap.getValues()) {
                for (int i = 0; i < block.getNotes().size(); i++) {
                    appendToNotesListFile(block.getName() + "/" + block.getNotes().get(i));
                    appendToNotesListFile(System.lineSeparator());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Write: File not found");
        } catch (IOException e) {
            System.out.print("Unable to write to file");
        }
    }

    /**
     * For complementing overwriteNotesListFile() function, it adds to the file in the given filepath.
     *
     * @param textToAdd text that is formatted and contains information about a task in the task list
     * @throws IOException - exception thrown
     */

    public void appendToNotesListFile(String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(this.filepath, true);
        fw.write(textToAdd);
        fw.close();
    }
}

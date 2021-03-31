package seedu.duke.storage;

import seedu.duke.data.History;
import seedu.duke.exception.InvalidIndexException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HistoryStorage extends Storage {
    public HistoryStorage(String path) {
        super(path);
    }

    public void loadHistory(History history) throws IOException {
        try {
            Scanner s = new Scanner(new File(this.filepath)); // create a Scanner using the File as the source
            while (s.hasNext()) {
                String[] routeInfo = s.nextLine().split(" ");
                history.addHistory(routeInfo[0], routeInfo[1]);
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

    public void overwriteHistoryListFile(History history) {
        //write to file:
        try {
            PrintWriter writer = new PrintWriter(this.filepath);
            writer.print("");
            writer.close();
            for (int i = 0; i < history.getHistorySize(); i++) {
                String[] currentHistory = history.getSpecificEntry(i);
                appendToHistoryListFile(currentHistory[0], " ",currentHistory[1]);
                appendToHistoryListFile(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Write: File not found");
        } catch (IOException e) {
            System.out.print("Unable to write to file");
        } catch (InvalidIndexException e) {
            System.out.print("An Error occurred while saving history!");
        }
    }

    public void appendToHistoryListFile(String... textToAdd) throws IOException {
        FileWriter fw = new FileWriter(this.filepath, true);
        for (String m : textToAdd) {
            fw.write(m);
        }
        fw.close();
    }
}

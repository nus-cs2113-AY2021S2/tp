package seedu.duke.storage;

import seedu.duke.FavouriteLocation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FavouriteLocationsStorage extends Storage {

    public FavouriteLocationsStorage(String path) {
        super(path);
    }

    public void loadFavourites(FavouriteLocation favLocation) throws IOException {
        try {
            Scanner s = new Scanner(new File(this.filepath)); // create a Scanner using the File as the source
            // add note for all locations:
            while (s.hasNext()) {
                favLocation.favouriteLocations.add(s.nextLine());
                //add favourite location from previous list to new list
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

    public void overwriteFavouritesListFile(FavouriteLocation favLocation) {
        //write to file:
        try {
            PrintWriter writer = new PrintWriter(this.filepath);
            writer.print("");
            writer.close();
            for (int i = 0; i < favLocation.favouriteLocations.size(); i++) {
                String currentLocation = favLocation.favouriteLocations.get(i);
                appendToNotesListFile(currentLocation);
                appendToNotesListFile(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Write: File not found");
        } catch (IOException e) {
            System.out.print("Unable to write to file");
        }
    }

    public void appendToNotesListFile(String textToAdd) throws IOException {
        FileWriter fw = new FileWriter(this.filepath, true);
        fw.write(textToAdd);
        fw.close();
    }
}

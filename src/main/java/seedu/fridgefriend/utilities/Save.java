package seedu.fridgefriend.utilities;

import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.exception.NoSaveException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Save {
    public static String filePath = "save/savefile.txt";
    public static String directory = "save";

    /**
     * Creates a textfile if it does not already exist.
     */
    public static void checkSave() {
        Path path = Paths.get(filePath); //creates Path instance
        File file = new File(filePath);

        try {
            Files.createDirectories(Paths.get(directory));
            Path p = Files.createFile(path);     //creates file at specified location
        } catch (IOException e) {
            loadSave();
        }
    }

    /**
     * Reads the data from the textfile.
     * @return a Fridge object constructed from the data in the savefile.
     */
    public static void loadSave() {
        File file = new File(filePath);
        try {
            Scanner s = new Scanner(file); // create a Scanner using the File as the source

            while (s.hasNext()) {
                String line = s.nextLine();
                String[] parameters = line.split(":");

                String name = parameters[1].substring(1, parameters[1].indexOf((",")));

                String categoryStr = parameters[2].substring(1, parameters[2].indexOf((",")));
                FoodCategory category = FoodCategory.convertStringToFoodCategory(categoryStr);

                String expiry = parameters[3].substring(1, parameters[3].indexOf((",")));

                String storageStr = parameters[4];
                FoodStorageLocation storage = FoodStorageLocation.convertStringToLocation(storageStr);
                Fridge.add(new Food(category, name, expiry, storage));
            }
        } catch (FileNotFoundException e) {
            Ui.printExceptionMessage(new NoSaveException());
        } catch (InvalidDateException e) {
            Ui.printExceptionMessage(e);
        }
    }

    /**
     * Overwrites the current textfile with data from the current session.
     */
    public static void save() {
        try {
            FileWriter fw = new FileWriter(filePath);
            fw.write("");//clear file
            fw.close();
            FileWriter f = new FileWriter(filePath, true); // create a FileWriter in append mode
            for (int i = 0; i < Fridge.getSize(); i++) {
                f.write(Fridge.getFood(i).toString() + "\n");
            }
            f.close();
        } catch (IOException e) {
            System.out.println("cannot write to file");
        }
    }
}
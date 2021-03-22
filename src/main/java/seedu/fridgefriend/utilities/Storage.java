package seedu.fridgefriend.utilities;

import seedu.fridgefriend.command.AddCommand;
import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.exception.StorageLoadingException;
import seedu.fridgefriend.exception.StorageSavingException;
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

public class Storage {
    private static String filePath = "data/data.txt";
    private static String directory = "data";
    private static Fridge fridge;

    /**
     * Loads the saved data into a fridge.
     * 
     * @param fridgeInput fridge to be populated
     */
    public static void load(Fridge fridgeInput) {
        fridge = fridgeInput;
        try {
            checkDirectory();
        } catch (Exception e) {
            StorageLoadingException exception = new StorageLoadingException(e);
            Ui.printExceptionMessage(exception);
        }
    }

    /**
     * Creates a textfile and the folder directory if it does not already exist.
     * 
     * @throws InvalidDateException if the date cannot be parsed
     * @throws FileNotFoundException if file does not exist
     */
    private static void checkDirectory() throws FileNotFoundException, InvalidDateException {
        Path path = Paths.get(filePath); //creates Path instance
        try {
            Files.createDirectories(Paths.get(directory));
            Files.createFile(path); //creates file at specified location
        } catch (IOException e) {
            loadData();
        }
    }

    /**
     * Reads the data from the textfile.
     * 
     * @throws FileNotFoundException if file does not exist
     * @throws InvalidDateException if the date cannot be parsed
     */
    private static void loadData() throws FileNotFoundException, InvalidDateException {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file); // create a Scanner using the File as the source
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            readData(line);
        }
        scanner.close();
    }

    /**
     * Adds a food item to a fridge based on saved data.
     * 
     * @param line string in data file to be read
     * @throws InvalidDateException if date in data file cannot be parsed
     */
    private static void readData(String line) throws InvalidDateException {
        String[] parameters = line.split(":");

        String name = parameters[1].substring(1, parameters[1].indexOf((",")));
        String categoryStr = parameters[2].substring(1, parameters[2].indexOf((",")));
        FoodCategory category = FoodCategory.convertStringToFoodCategory(categoryStr);
        String expiry = parameters[3].substring(1, parameters[3].indexOf((",")));
        String storageStr = parameters[4];
        FoodStorageLocation storage = FoodStorageLocation.convertStringToLocation(storageStr);

        Food food = AddCommand.categoriseAndGenerateFood(name, category, expiry, storage);
        fridge.add(food);
    }

    /**
     * Overwrites the current textfile with data from the current session.
     * 
     * @param fridgeInput fridge to be populated
     */
    public static void save(Fridge fridgeInput) {
        fridge = fridgeInput;
        try {
            clearFile();
            populateData();
        } catch (Exception e) {
            StorageSavingException exception = new StorageSavingException(e);
            Ui.printExceptionMessage(exception);
        }
    }

    private static void clearFile() throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(""); //clear file
        fileWriter.close();
    }

    private static void populateData() throws IOException {
        FileWriter fileWriter = new FileWriter(filePath, true); // create a FileWriter in append mode
        for (int i = 0; i < fridge.getSize(); i++) {
            fileWriter.write(fridge.getFood(i).toString() + "\n");
        }
        fileWriter.close();
    }
}
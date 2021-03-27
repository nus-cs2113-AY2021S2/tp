package seedu.fridgefriend.utilities;

import seedu.fridgefriend.command.AddCommand;
import seedu.fridgefriend.exception.EmptyDescriptionException;
import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.exception.InvalidFoodCategoryException;
import seedu.fridgefriend.exception.InvalidQuantityException;
import seedu.fridgefriend.exception.RepetitiveFoodIdentifierException;
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
    private static final String DATA_FILE_PATH = "data/fridgeData.txt";
    private static final String HISTORY_FILE_PATH = "data/historyData.txt";
    private static final String LIMITS_FILE_PATH = "data/limitsData.txt";
    private static final String DIRECTORY = "data";
    private static Fridge fridge;
    private static String history;

    /**
     * Entry point for loading of all data.
     * 
     * @param fridgeInput fridge to be populated
     */
    public static void load(Fridge fridgeInput) {
        loadFridgeData(fridgeInput);
        loadLimitsData();
    }

    /**
     * Entry point for saving of all data.
     * 
     * @param fridgeInput fridge to be saved
     */
    public static void save(Fridge fridgeInput) {
        saveFridgeData(fridgeInput);
        saveLimitsData();
    }

    /**
     * Loads the saved data into a fridge.
     * 
     * @param fridgeInput fridge to be populated
     */
    private static void loadFridgeData(Fridge fridgeInput) {
        fridge = fridgeInput;
        try {
            checkFridgeDataDirectory();
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
    private static void checkFridgeDataDirectory() throws FileNotFoundException, InvalidDateException,
            InvalidQuantityException, EmptyDescriptionException, RepetitiveFoodIdentifierException {
        Path path = Paths.get(DATA_FILE_PATH); //creates Path instance
        try {
            Files.createDirectories(Paths.get(DIRECTORY));
            Files.createFile(path); //creates file at specified location
        } catch (IOException e) {
            readFridgeData();
        }
    }

    /**
     * Reads the data from the textfile.
     * 
     * @throws FileNotFoundException if file does not exist
     * @throws InvalidDateException if the date cannot be parsed
     */
    private static void readFridgeData() throws FileNotFoundException, InvalidDateException,
            InvalidQuantityException, EmptyDescriptionException, RepetitiveFoodIdentifierException {
        File file = new File(DATA_FILE_PATH);
        Scanner scanner = new Scanner(file); // create a Scanner using the File as the source
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            populateFridge(line);
        }
        scanner.close();
    }

    /**
     * Adds a food item to a fridge based on saved data.
     * 
     * @param line string in data file to be read
     * @throws InvalidDateException if date in data file cannot be parsed
     * @throws InvalidQuantityException if quantity in data file cannot be parsed
     * @throws InvalidFoodCategoryException if category in data file cannot be parsed
     */
    private static void populateFridge(String line) throws InvalidDateException,
            InvalidQuantityException, EmptyDescriptionException, RepetitiveFoodIdentifierException {
        String[] parameters = line.split(":");

        String name = parameters[1].substring(1, parameters[1].indexOf((",")));
        String categoryStr = parameters[2].substring(1, parameters[2].indexOf((",")));
        FoodCategory category = FoodCategory.convertStringToFoodCategory(categoryStr);
        String expiry = parameters[3].substring(1, parameters[3].indexOf((",")));
        String storageStr = parameters[4].substring(1, parameters[4].indexOf((",")));
        int quantity = Parser.parseIntegerQuantity(parameters[5].trim());

        FoodStorageLocation storage = FoodStorageLocation.convertStringToLocation(storageStr);
        Food food = AddCommand.categoriseAndGenerateFood(name, category, expiry, storage, quantity);
        fridge.add(food);
    }

    /**
     * Saves food in the fridge into the datafile.
     * 
     * @param fridgeInput fridge to be saved
     */
    private static void saveFridgeData(Fridge fridgeInput) {
        fridge = fridgeInput;
        try {
            clearFile(DATA_FILE_PATH);
            populateFridgeDataFile(DATA_FILE_PATH);
        } catch (Exception e) {
            StorageSavingException exception = new StorageSavingException(e);
            Ui.printExceptionMessage(exception);
        }
    }

    private static void clearFile(String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(""); //clear file
        fileWriter.close();
    }

    private static void populateFridgeDataFile(String filePath) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath, true); // create a FileWriter in append mode
        for (int i = 0; i < fridge.getSize(); i++) {
            fileWriter.write(fridge.getFood(i).toString() + "\n");
        }
        fileWriter.close();
    }

    /**
     * Loads the saved limits data into the FoodCategory class.
     */
    private static void loadLimitsData() {
        try {
            checkLimitsDirectory();
        } catch (Exception e) {
            StorageLoadingException exception = new StorageLoadingException(e);
            Ui.printExceptionMessage(exception);
        }
    }

    /**
     * Creates a limits data textfile and the folder directory if it does not already exist.
     * 
     * @throws FileNotFoundException if file does not exist
     * @throws EmptyDescriptionException if quantity in data file is empty
     * @throws InvalidQuantityException if quantity in data file cannot be parsed
     */
    private static void checkLimitsDirectory()
            throws FileNotFoundException, EmptyDescriptionException, InvalidQuantityException {
        Path path = Paths.get(LIMITS_FILE_PATH); //creates Path instance
        try {
            Files.createDirectories(Paths.get(DIRECTORY));
            Files.createFile(path); //creates file at specified location
        } catch (IOException e) {
            readLimitsData();
        }
    }

    /**
     * Reads the limits data from the textfile.
     * 
     * @throws FileNotFoundException if file does not exist
     * @throws EmptyDescriptionException if quantity in data file is empty
     * @throws InvalidQuantityException if quantity in data file cannot be parsed
     */
    private static void readLimitsData()
            throws FileNotFoundException, EmptyDescriptionException, InvalidQuantityException {
        File file = new File(LIMITS_FILE_PATH);
        Scanner scanner = new Scanner(file); // create a Scanner using the File as the source
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            populateFoodCategory(line);
        }
        scanner.close();
    }

    /**
     * Sets minimum quantity of a FoodCategory based on saved limits data.
     * 
     * @param line string in data file to be processed
     * @throws EmptyDescriptionException if quantity in data file is empty
     * @throws InvalidQuantityException if quantity in data file cannot be parsed
     */
    private static void populateFoodCategory(String line) 
            throws EmptyDescriptionException, InvalidQuantityException {
        String[] parameters = line.split(":");
        FoodCategory foodCategory = FoodCategory.convertStringToFoodCategory(parameters[0]);
        int quantity = Parser.parseIntegerQuantity(parameters[1]);
        FoodCategory.setMinimumQuantity(foodCategory, quantity);
    }

    /**
     * Overwrites the current textfile with data from the current session.
     */
    public static void saveLimitsData() {
        try {
            clearFile(LIMITS_FILE_PATH);
            populateLimitsDataFile();
        } catch (Exception e) {
            StorageSavingException exception = new StorageSavingException(e);
            Ui.printExceptionMessage(exception);
        }
    }

    /**
     * Writes the minimum quantities in FoodCategory into the limits datafile.
     * 
     * @throws IOException if file does not exist
     */
    private static void populateLimitsDataFile() throws IOException {
        FileWriter fileWriter = new FileWriter(LIMITS_FILE_PATH, true); // create a FileWriter in append mode
        for (FoodCategory foodCategory : FoodCategory.values()) {
            int quantity = FoodCategory.getMinimumQuantity(foodCategory);
            String line = foodCategory.toString() + ":" + quantity;
            fileWriter.write(line + "\n");
        }
        fileWriter.close();
    }

    //@@author leeyp
    /**
     * Loads the saved data into a fridge that represents the history of items added.
     *
     * @return
     */
    public static String loadHistoryData() {
        try {
            checkHistoryDirectory();
            return history;
        } catch (Exception e) {
            StorageLoadingException exception = new StorageLoadingException(e);
            Ui.printExceptionMessage(exception);
        }
        return null;
    }

    /**
     * Creates a history data textfile and the folder directory if it does not already exist.
     *
     * @throws FileNotFoundException if file does not exist
     * @throws EmptyDescriptionException if quantity in data file is empty
     * @throws InvalidQuantityException if quantity in data file cannot be parsed
     */
    private static void checkHistoryDirectory()
            throws FileNotFoundException {
        Path path = Paths.get(HISTORY_FILE_PATH); //creates Path instance
        try {
            Files.createDirectories(Paths.get(DIRECTORY));
            Files.createFile(path); //creates file at specified location
        } catch (IOException e) {
            readHistoryData();
        }
    }

    /**
     * Reads the history data from the textfile.
     *
     * @throws FileNotFoundException if file does not exist
     */
    private static void readHistoryData()
            throws FileNotFoundException {
        File file = new File(HISTORY_FILE_PATH);
        Scanner scanner = new Scanner(file); // create a Scanner using the File as the source
        StringBuilder message = new StringBuilder();
        int index = 1;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            message.append("\n\t" + index + ". " + line);
            index++;
        }
        scanner.close();

        history = message.toString();
    }



    /**
     * Appends food item to history data file
     *
     */
    public static void saveHistoryData(Food foodInput) {
        try {
            addFoodToHistoryFile(HISTORY_FILE_PATH, foodInput);
        } catch (Exception e) {
            StorageSavingException exception = new StorageSavingException(e);
            Ui.printExceptionMessage(exception);
        }
    }

    private static void addFoodToHistoryFile(String filePath, Food foodInput) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath, true); // create a FileWriter in append mode
        fileWriter.write(foodInput.toString() + "\n");
        fileWriter.close();
    }

    /**
     * Clears history data file
     *
     */
    public static void clearHistoryData() {
        try {
            clearFile(HISTORY_FILE_PATH);
        } catch (Exception e) {
            StorageSavingException exception = new StorageSavingException(e);
            Ui.printExceptionMessage(exception);
        }
    }

}
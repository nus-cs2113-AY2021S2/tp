package seedu.fridgefriend.utilities;

import seedu.fridgefriend.command.AddCommand;
import seedu.fridgefriend.exception.EmptyDescriptionException;
import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.exception.InvalidFoodCategoryException;
import seedu.fridgefriend.exception.InvalidFoodLocationException;
import seedu.fridgefriend.exception.InvalidQuantityException;
import seedu.fridgefriend.exception.InvalidSetLimitQuantityException;
import seedu.fridgefriend.exception.RepetitiveFoodIdentifierException;
import seedu.fridgefriend.exception.StorageLoadingException;
import seedu.fridgefriend.exception.StorageSavingException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;
import seedu.fridgefriend.food.MinimumQuantity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Reads data from, and writes data to, the local disk.
 *
 */
public class Storage {
    private static final String DATA_FILE_PATH = "data/fridgeData.txt";
    private static final String HISTORY_FILE_PATH = "data/historyData.txt";
    private static final String LIMITS_FILE_PATH = "data/limitsData.txt";
    private static final String DIRECTORY = "data";
    private static Fridge fridge;
    private static String history = "";

    //@@author kwokyto
    /**
     * Entry point for loading of all data.
     * 
     * @param fridgeInput fridge to be populated
     */
    public static void load(Fridge fridgeInput) {
        loadFridgeData(fridgeInput);
        loadLimitsData();
    }

    //@@author kwokyto
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
     * @throws FileNotFoundException if file does not exist
     * @throws InvalidDateException if the date in data file cannot be parsed
     * @throws InvalidQuantityException if the quantity in data file cannot be parsed
     * @throws EmptyDescriptionException if the description in data file is empty
     * @throws RepetitiveFoodIdentifierException if the foodName in data file is not unique
     * @throws InvalidFoodCategoryException if the category in data file cannot be parsed
     * @throws InvalidFoodLocationException if the location in data file cannot be parsed
     */
    private static void checkFridgeDataDirectory() throws FileNotFoundException, InvalidDateException,
            InvalidQuantityException, EmptyDescriptionException,
            RepetitiveFoodIdentifierException, InvalidFoodCategoryException, InvalidFoodLocationException {
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
     * @throws InvalidDateException if the date in data file cannot be parsed
     * @throws InvalidQuantityException if the quantity in data file cannot be parsed
     * @throws EmptyDescriptionException if the description in data file is empty
     * @throws RepetitiveFoodIdentifierException if the foodName in data file is not unique
     * @throws InvalidFoodCategoryException if the category in data file cannot be parsed
     * @throws InvalidFoodLocationException if the location in data file cannot be parsed
     */
    private static void readFridgeData() throws FileNotFoundException, InvalidDateException,
            InvalidQuantityException, EmptyDescriptionException,
            RepetitiveFoodIdentifierException, InvalidFoodCategoryException, InvalidFoodLocationException {
        File file = new File(DATA_FILE_PATH);
        Scanner scanner = new Scanner(file); // create a Scanner using the File as the source
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            populateFridge(line);
        }
        scanner.close();
    }


    //@@author leeyp
    /**
     * Adds a food item to a fridge based on saved data.
     *
     * @param line string in data file to be read
     * @throws InvalidDateException if the date in data file be parsed
     * @throws InvalidQuantityException if the quantity in data file be parsed
     * @throws EmptyDescriptionException if the description in data file is empty
     * @throws RepetitiveFoodIdentifierException if the foodName in data file is not unique
     * @throws InvalidFoodCategoryException if category in data file cannot be parsed
     * @throws InvalidFoodLocationException if the location in data file cannot be parsed
     */
    private static void populateFridge(String line) throws InvalidDateException,
            InvalidQuantityException, EmptyDescriptionException,
            RepetitiveFoodIdentifierException, InvalidFoodCategoryException, InvalidFoodLocationException {

        String foodNameDelimiter = "Food name: ";
        String categoryDelimiter = ", category: ";
        String expiryDelimiter = ", expiry: ";
        String storageDelimiter = ", stored in: ";
        String quantityDelimiter = ", quantity: ";

        String name = loadFoodNameFromLine(line, foodNameDelimiter, categoryDelimiter);

        String categoryStr = loadFoodDataFromLine(line, categoryDelimiter, expiryDelimiter);
        FoodCategory category = FoodCategory.convertStringToFoodCategory(categoryStr);

        String expiry = loadFoodDataFromLine(line, expiryDelimiter, storageDelimiter);

        String storageStr = loadFoodDataFromLine(line, storageDelimiter, quantityDelimiter);
        FoodStorageLocation storage = FoodStorageLocation.convertStringToLocation(storageStr);

        int quantity = Parser.parseIntegerQuantity(getQuantityFromLine(line, quantityDelimiter));


        Food food = AddCommand.categoriseAndGenerateFood(name, category, expiry, storage, quantity);
        fridge.add(food);
    }

    private static String getQuantityFromLine(String line, String quantityDelimiter) {
        String quantity = line.substring(line.lastIndexOf(quantityDelimiter) + quantityDelimiter.length());
        return quantity.trim();
    }

    private static String loadFoodNameFromLine(String line, String startIndex, String endIndex) {
        return line.substring(line.indexOf(startIndex) + startIndex.length(), line.lastIndexOf((endIndex)));
    }

    private static String loadFoodDataFromLine(String line, String startIndex, String endIndex) {
        return line.substring(line.lastIndexOf(startIndex) + startIndex.length(), line.lastIndexOf((endIndex)));
    }
    

    //@@author kwokyto
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

    //@@author kwokyto
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

    //@@author kwokyto
    /**
     * Creates a limits data textfile and the folder directory if it does not already exist.
     *
     * @throws FileNotFoundException if file does not exist
     * @throws EmptyDescriptionException if quantity in data file is empty
     * @throws InvalidSetLimitQuantityException if set limit quantity in data file cannot be parsed
     * @throws InvalidFoodCategoryException if category in data file cannot be parsed
     */
    private static void checkLimitsDirectory()
            throws FileNotFoundException, EmptyDescriptionException,
            InvalidSetLimitQuantityException, InvalidFoodCategoryException {
        Path path = Paths.get(LIMITS_FILE_PATH); //creates Path instance
        try {
            Files.createDirectories(Paths.get(DIRECTORY));
            Files.createFile(path); //creates file at specified location
        } catch (IOException e) {
            readLimitsData();
        }
    }

    //@@author kwokyto
    /**
     * Reads the limits data from the textfile.
     *
     * @throws FileNotFoundException if file does not exist
     * @throws EmptyDescriptionException if quantity in data file is empty
     * @throws InvalidSetLimitQuantityException if set limit quantity in data file cannot be parsed
     * @throws InvalidFoodCategoryException if category in data file cannot be parsed
     */
    private static void readLimitsData()
            throws FileNotFoundException, EmptyDescriptionException,
            InvalidSetLimitQuantityException, InvalidFoodCategoryException {
        File file = new File(LIMITS_FILE_PATH);
        Scanner scanner = new Scanner(file); // create a Scanner using the File as the source
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            populateFoodCategory(line);
        }
        scanner.close();
    }

    //@@author kwokyto
    /**
     * Sets minimum quantity of a FoodCategory based on saved limits data.
     *
     * @param line string in data file to be processed
     * @throws EmptyDescriptionException if quantity in data file is empty
     * @throws InvalidSetLimitQuantityException if quantity in data file cannot be parsed
     * @throws InvalidFoodCategoryException if category in data file cannot be parsed
     */
    private static void populateFoodCategory(String line)
            throws EmptyDescriptionException, InvalidSetLimitQuantityException, InvalidFoodCategoryException {
        String[] parameters = line.split(":");
        FoodCategory foodCategory = FoodCategory.convertStringToFoodCategory(parameters[0]);
        int quantity = Parser.parseSetLimitIntegerQuantity(parameters[1]);
        MinimumQuantity.setMinimumQuantity(foodCategory, quantity);
    }

    //@@author kwokyto
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

    //@@author kwokyto
    /**
     * Writes the minimum quantities in FoodCategory into the limits datafile.
     * 
     * @throws IOException if file does not exist
     */
    private static void populateLimitsDataFile() throws IOException {
        FileWriter fileWriter = new FileWriter(LIMITS_FILE_PATH, true); // create a FileWriter in append mode
        for (FoodCategory foodCategory : FoodCategory.values()) {
            int quantity = MinimumQuantity.getMinimumQuantity(foodCategory);
            String line = foodCategory.toString() + ":" + quantity;
            fileWriter.write(line + "\n");
        }
        fileWriter.close();
    }

    //@@author leeyp
    /**
     * Loads the saved data into a fridge that represents the history of items added.
     *
     * @return String that contains the list of data in history textfile.
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
     * Appends food item to history data textfile.
     * Is called after every AddCommand.
     *
     * @param foodInput the food added into fridge
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
     * Clears history data textfile.
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

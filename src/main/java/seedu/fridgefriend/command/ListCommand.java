package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.InvalidFoodCategoryException;
import seedu.fridgefriend.exception.InvalidFoodLocationException;
import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.utilities.Ui;
import seedu.fridgefriend.utilities.LoggingHandler;

//@@author SimJJ96
/**
 * Represents a command to list the items in the fridge to the user.
 * When calling constructor, description is a necessary field
 * to specify whether to list everything,
 * list by category, or list by location.
 */
public class ListCommand extends Command {

    private static final int EXTRA_INDEX = 1;
    private static final int START_INDEX_SHOWN_TO_USER = 1;
    private final String description;
    private int indexShownToUser;

    public ListCommand(String description) {
        LoggingHandler.logInfo("List command initialized with parameter: " + description);
        this.description = description.toUpperCase();
        this.indexShownToUser = START_INDEX_SHOWN_TO_USER;
    }

    @Override
    public void execute() throws InvalidInputException,
            InvalidFoodCategoryException, InvalidFoodLocationException {
        if (description.equals("")) {
            LoggingHandler.logInfo("Listing all food.");
            listAll();
        } else if ((description).equalsIgnoreCase("other")) {
            LoggingHandler.logInfo("Listing by 'Others' Category and Storage Location");
            listByOthers();
        } else if (checkIsValidCategory()) {
            LoggingHandler.logInfo("Listing by category.");
            listByCategory();
        } else if (checkIsValidStorageLocation()) {
            LoggingHandler.logInfo("Listing by storage location.");
            listByStorageLocation();
        } else {
            LoggingHandler.logInfo("Cannot list, because invalid parameter inputted.");
            invalidInputError();
        }
    }

    private void invalidInputError() throws InvalidInputException {
        String errorMessage = "Sorry my friend, please enter a valid food category or storage location.";
        throw new InvalidInputException(errorMessage);
    }

    private String getFoodDescription(int index) {
        int indexShownToUser = index + EXTRA_INDEX;
        Food food = fridge.getFood(index);
        String foodDescription =
                "\n\t" + indexShownToUser + ". "
                        + food.toString();
        return foodDescription;
    }

    private void listAll() {
        Ui.printMessage(getListAllMessage());
    }

    /**
     * Returns all the food in the fridge.
     *
     * @return string of the food names that are in the fridge
     */
    public String getListAllMessage() {
        LoggingHandler.logInfo("No input detected, printing all items.");
        StringBuilder message = new StringBuilder("Here are the items in your fridge:");
        for (int i = 0; i < fridge.getSize(); i++) {
            message.append(getFoodDescription(i));
        }
        return message.toString();
    }

    private void listByCategory() throws InvalidFoodCategoryException {
        String message = getListByCategoryMessage();
        Ui.printMessage(message);
    }

    /**
     * Returns the food that match the category that was specified.
     *
     * @return string of food that match the category in the fridge
     * @throws InvalidFoodCategoryException if the string of food input does not match any category in the fridge
     */
    public String getListByCategoryMessage() throws InvalidFoodCategoryException {
        LoggingHandler.logInfo("Category detected:" + description);
        StringBuilder message = new StringBuilder("These are the " + description + " in your fridge:");
        for (int i = 0; i < fridge.getSize(); i++) {
            message.append(getMatchCategoryFoodDescription(i));
        }

        assert message != null : "message string should not be null";
        return message.toString();
    }

    private boolean checkIsValidCategory() {
        return FoodCategory.contains(description);
    }

    private String getMatchCategoryFoodDescription(int index) throws InvalidFoodCategoryException {
        String foodDescription = "";
        FoodCategory categoryToFind = FoodCategory.convertStringToFoodCategory(description);
        Food food = fridge.getFood(index);
        FoodCategory category = food.getCategory();
        if (category.equals(categoryToFind)) {
            foodDescription = "\n\t" + indexShownToUser + ". " + food.toString();
            ++indexShownToUser;
        }
        return foodDescription;
    }
    //@author

    //@@author leeyp
    private void listByStorageLocation() throws InvalidFoodLocationException {
        String message = getListByStorageLocationMessage();
        Ui.printMessage(message);
    }

    /**
     * Returns the food that match the storage location that was specified.
     *
     * @return string of food that match the storage location in the fridge
     * @throws InvalidFoodLocationException if string of food input does not match any storage location in the fridge
     */
    public String getListByStorageLocationMessage() throws InvalidFoodLocationException {
        LoggingHandler.logInfo("Storage Location detected:" + description);
        StringBuilder message = new StringBuilder("These are the food stored in " + description + ":");
        for (int i = 0; i < fridge.getSize(); i++) {
            message.append(getMatchStorageFoodDescription(i));
        }

        assert message != null : "message string should not be null";
        return message.toString();
    }

    private boolean checkIsValidStorageLocation() {
        return FoodStorageLocation.contains(description);
    }

    private String getMatchStorageFoodDescription(int index) throws InvalidFoodLocationException {
        String foodDescription = "";
        FoodStorageLocation locationToFind = FoodStorageLocation.convertStringToLocation(description);
        Food food = fridge.getFood(index);
        FoodStorageLocation storageLocation = food.getStorageLocation();
        if (storageLocation.equals(locationToFind)) {
            foodDescription = "\n\t" + indexShownToUser + ". " + food.toString();
            ++indexShownToUser;
        }
        return foodDescription;
    }

    /**
     * Returns the food that match either the category and storage location "others" or both.
     * Special method needed because it is an edge case in List Command.
     *
     * @return string of food that match "others" category or storage location in the fridge
     */
    public String getListByOthersMessage() {
        LoggingHandler.logInfo("Searching for 'Others'.");
        StringBuilder message = new StringBuilder("These are the food that belong to OTHER:");
        for (int i = 0; i < fridge.getSize(); i++) {
            message.append(getMatchOthersFoodDescription(i));
        }

        assert message != null : "message string should not be null";
        return message.toString();
    }

    private String getMatchOthersFoodDescription(int index) {
        String foodDescription = "";
        Food food = fridge.getFood(index);
        FoodStorageLocation storageLocation = food.getStorageLocation();
        FoodCategory category = food.getCategory();
        if (isOthersStorageLocation(storageLocation) || isOthersCategory(category)) {
            foodDescription = "\n\t" + indexShownToUser + ". " + food.toString();
            ++indexShownToUser;
        }
        return foodDescription;
    }

    private void listByOthers() {
        String message = getListByOthersMessage();
        Ui.printMessage(message);
    }

    private boolean isOthersCategory(FoodCategory category) {
        return category.equals((FoodCategory.OTHER));
    }

    private boolean isOthersStorageLocation(FoodStorageLocation storageLocation) {
        return storageLocation.equals((FoodStorageLocation.OTHER));
    }

}

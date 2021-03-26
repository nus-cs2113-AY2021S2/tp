package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.exception.RepetitiveFoodIdentifierException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.categories.Beverage;
import seedu.fridgefriend.food.categories.CookedDish;
import seedu.fridgefriend.food.categories.Dairy;
import seedu.fridgefriend.food.categories.Egg;
import seedu.fridgefriend.food.categories.Frozen;
import seedu.fridgefriend.food.categories.Fruit;
import seedu.fridgefriend.food.categories.Meat;
import seedu.fridgefriend.food.categories.Other;
import seedu.fridgefriend.food.categories.ReadyToEat;
import seedu.fridgefriend.food.categories.Seafood;
import seedu.fridgefriend.food.categories.Vegetable;
import seedu.fridgefriend.utilities.Ui;
import seedu.fridgefriend.utilities.LoggingHandler;

/**
 * Represents a command to add a food item into the Fridge.
 * When calling constructor, foodName, category, expiryDate, location
 * and quantity are necessary fields
 */
public class AddCommand extends Command {

    private final Food foodToAdd;

    public AddCommand(String foodName, FoodCategory category, String expiryString,
                      FoodStorageLocation location, int quantity)
            throws InvalidDateException {

        assert category != null : "category should not be null";
        LoggingHandler.logInfo("Adding food: " + foodName + " with parameters: ");
        LoggingHandler.logInfo("Category: " + category);
        LoggingHandler.logInfo("Expiry: " + expiryString);
        LoggingHandler.logInfo("Storage Location: " + location);
        foodToAdd = categoriseAndGenerateFood(foodName, category, expiryString, location, quantity);
        LoggingHandler.logInfo("Food " + foodName + " successfully added!");
    }

    @Override
    public void execute() throws RepetitiveFoodIdentifierException {
        addFood();
        showResults();
    }

    private void addFood() throws RepetitiveFoodIdentifierException {
        assert foodToAdd != null : "Unable to add a null food";
        fridge.add(foodToAdd);
    }

    private void showResults() {
        Ui.printMessage(getMessagePrintedToUser());
    }

    /**
     * Returns the results of add command.
     *
     * @return the message shown to the user
     */
    public String getMessagePrintedToUser() {
        String message = "Great! I have added "
                + foodToAdd.getFoodName()
                + " into your fridge.\n"
                + "Details: "
                + foodToAdd.toString();
        return message;
    }

    public static Food categoriseAndGenerateFood(String foodName, FoodCategory category,
                                                 String expiryString, FoodStorageLocation location,
                                                 int quantity) throws InvalidDateException {
        Food newFood;
        switch (category) {
        case VEGETABLE:
            newFood = new Vegetable(foodName, category, expiryString, location, quantity);
            LoggingHandler.logInfo("New Vegetable: " + foodName + " created.");
            break;
        case FRUIT:
            newFood = new Fruit(foodName, category, expiryString, location, quantity);
            LoggingHandler.logInfo("New Fruit: " + foodName + " created.");
            break;
        case MEAT:
            newFood = new Meat(foodName, category, expiryString, location, quantity);
            LoggingHandler.logInfo("New Meat: " + foodName + " created.");
            break;
        case SEAFOOD:
            newFood = new Seafood(foodName, category, expiryString, location, quantity);
            LoggingHandler.logInfo("New Seafood: " + foodName + " created.");
            break;
        case EGG:
            newFood = new Egg(foodName, category, expiryString, location, quantity);
            LoggingHandler.logInfo("New Egg: " + foodName + " created.");
            break;
        case DAIRY:
            newFood = new Dairy(foodName, category, expiryString, location, quantity);
            LoggingHandler.logInfo("New Dairy: " + foodName + " created.");
            break;
        case BEVERAGE:
            newFood = new Beverage(foodName, category, expiryString, location, quantity);
            LoggingHandler.logInfo("New Beverage: " + foodName + " created.");
            break;
        case COOKED_DISH:
            newFood = new CookedDish(foodName, category, expiryString, location, quantity);
            LoggingHandler.logInfo("New Cooked Dish: " + foodName + " created.");
            break;
        case READY_TO_EAT:
            newFood = new ReadyToEat(foodName, category, expiryString, location, quantity);
            LoggingHandler.logInfo("New Ready-To-Eat: " + foodName + " created.");
            break;
        case FROZEN:
            newFood = new Frozen(foodName, category, expiryString, location, quantity);
            LoggingHandler.logInfo("New Frozen Food: " + foodName + " created.");
            break;
        case OTHER:
            newFood = new Other(foodName, category, expiryString, location, quantity);
            LoggingHandler.logInfo("New Unknown Category Food: " + foodName + " created.");
            break;
        default:
            throw new IllegalStateException("Unexpected category value: " + category);
        }
        return newFood;
    }

}

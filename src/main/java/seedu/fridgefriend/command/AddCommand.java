package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.categories.*;
import seedu.fridgefriend.utilities.Ui;

/**
 * Represents a command to add a food item into the Fridge.
 * When calling constructor, foodName, category, expiryDate, and location are necessary fields
 */
public class AddCommand extends Command {

    private final Food foodToAdd;

    public AddCommand(String foodName, FoodCategory category, String expiryString,
            FoodStorageLocation location) throws InvalidDateException {
        assert category != null : "category should not be null";
        foodToAdd = categoriseAndGenerateFood(foodName, category, expiryString, location);

    }

    @Override
    public void execute() {
        addFood();
        showResults();
    }

    private void addFood() {
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

    public static Food categoriseAndGenerateFood(String foodName, FoodCategory category, String expiryString, FoodStorageLocation location) throws InvalidDateException {
        Food newFood;
        switch (category){
        case VEGETABLE:
            newFood = new Vegetable(foodName, category, expiryString, location);
            break;
        case FRUIT:
            newFood = new Fruit(foodName, category, expiryString, location);
            break;
        case MEAT:
            newFood = new Meat(foodName, category, expiryString, location);
            break;
        case SEAFOOD:
            newFood = new Seafood(foodName, category, expiryString, location);
            break;
        case EGG:
            newFood = new Egg(foodName, category, expiryString, location);
            break;
        case DAIRY:
            newFood = new Dairy(foodName, category, expiryString, location);
            break;
        case BEVERAGE:
            newFood = new Beverage(foodName, category, expiryString, location);
            break;
        case COOKED_DISH:
            newFood = new CookedDish(foodName, category, expiryString, location);
            break;
        case READY_TO_EAT:
            newFood = new ReadyToEat(foodName, category, expiryString, location);
            break;
        case FROZEN:
            newFood = new Frozen(foodName, category, expiryString, location);
            break;
        case OTHER:
            newFood = new Other(foodName, category, expiryString, location);
            break;
        default:
            throw new IllegalStateException("Unexpected value: " + category);
        }
        return newFood;
    }

}

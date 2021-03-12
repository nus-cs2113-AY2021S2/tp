package seedu.fridgefriend.command;

import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.utilities.Ui;

import java.util.List;

/**
 * Represents a command to add a food item into the Fridge.
 * When calling constructor, foodName, category, expiryDate, and location are necessary fields
 */
public class AddCommand extends Command {

    private final Food foodToAdd;

    public AddCommand(String foodName,
                      FoodCategory category,
                      String expiryDate,
                      FoodStorageLocation location) {
        this.foodToAdd = new Food(category, foodName, expiryDate, location);
    }

    @Override
    public void execute(List<Food> fridge) {
        addFood(fridge);
        showResults();
    }

    private void addFood(List<Food> fridge) {
        fridge.add(foodToAdd);
    }

    private void showResults() {
        String message = "Great! I have added "
                + foodToAdd.getFoodName()
                + " into your fridge.\n"
                + "Details: "
                + foodToAdd.toString();
        Ui.printMessage(message);
    }

}

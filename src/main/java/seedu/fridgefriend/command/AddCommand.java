package seedu.fridgefriend.command;

import java.util.List;

import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;

/**
 * Add a food item into the Fridge.
 */
public class AddCommand extends Command {

    private final Food foodToAdd;

    public AddCommand(String foodName, FoodCategory category, String expiryString,
            FoodStorageLocation location) throws InvalidDateException {
        this.foodToAdd = new Food(category, foodName, expiryString, location);
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
        System.out.println("Great! I have added " + foodToAdd.getFoodName() + " into your fridge.");
        System.out.println("Details: " + foodToAdd.toString() + "\n");
    }

}

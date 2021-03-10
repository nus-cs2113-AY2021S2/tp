package seedu.fridgefriend.command;

import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;

import java.util.List;

/**
 * Add a food item into the Fridge.
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
        System.out.println("Great! I have added " + foodToAdd.getFoodName() + " into your fridge.");
        System.out.println("Details: " + foodToAdd.toString() + "\n");
    }

}

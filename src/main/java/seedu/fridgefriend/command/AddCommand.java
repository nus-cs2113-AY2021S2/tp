package seedu.fridgefriend.command;

import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;

import java.util.List;

/**
 * Add a food item into the Fridge.
 */
public class AddCommand extends Command {

    private static final int FOOD_NAME_INDEX = 0;
    private static final int FOOD_CATEGORY_INDEX = 1;

    private final Food food;

    public AddCommand(String[] foodDescription) {
        String category = foodDescription[FOOD_CATEGORY_INDEX].trim().toUpperCase();
        String foodName = foodDescription[FOOD_NAME_INDEX].trim();
        FoodCategory foodCategory = FoodCategory.convertStringToFoodCategory(category);
        this.food = new Food(foodCategory, foodName);
    }

    @Override
    public void execute(List<Food> fridge) {
        addFood(fridge);
        showResults();
    }

    private void addFood(List<Food> fridge) {
        fridge.add(food);
    }

    private void showResults() {
        System.out.println("Great! I have added " + food.getFoodName()
                + " [" + food.getCategory() + "] into your fridge.\n");
    }

}

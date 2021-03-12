package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.Fridge;
import seedu.fridgefriend.utilities.Ui;

/**
 * Represents a command to list the items in the fridge to the user.
 * When calling constructor, description is a necessary field
 * to specify whether to list everything or list by category.
 */
public class ListCommand extends Command {

    private static final int EXTRA_INDEX = 1;
    private final FoodCategory foodCategory;
    private final String category;

    public ListCommand(String description) {
        this.category = description.toUpperCase();
        this.foodCategory = FoodCategory.convertStringToFoodCategory(category);
    }

    @Override
    public void execute() throws InvalidInputException {
        if (category.equals("")) {
            listEverythingInFridge();
        } else {
            listByCategory();
        }
    }

    private void listByCategory() throws InvalidInputException {
        checkIsValidCategory();
        String message = "These are the " + foodCategory + " in your fridge:\n";
        for (int i = 0; i < Fridge.getSize(); i++) {
            message += matchCategory(i);
        }
        Ui.printMessage(message);
    }

    private void listEverythingInFridge() {
        String message = "Here are the items in your fridge:";
        for (int i = 0; i < Fridge.getSize(); i++) {
            message += getFoodDescription(i);
        }
        Ui.printMessage(message);
    }

    private String getFoodDescription(int i) {
        int indexShownToUser = i + EXTRA_INDEX;
        Food food = Fridge.getFood(i);
        String foodDescription = 
                "\n\t" + indexShownToUser +  ". "
                + food.getFoodName() + " ["
                + food.getCategory() + "]";
        return foodDescription;
    }

    private void checkIsValidCategory() throws InvalidInputException {
        if (!FoodCategory.contains(category)) {
            String errorMessage = "Sorry my friend, please enter a valid food category.";
            throw new InvalidInputException(errorMessage);
        }
    }

    private String matchCategory(int index) {
        String foodAndCategory = "";
        Food food = Fridge.getFood(index);
        FoodCategory category = food.getCategory();
        if (category.equals(foodCategory)) {
            int indexShownToUser = index + EXTRA_INDEX;
            foodAndCategory = "\t" + indexShownToUser + ". " + food.getFoodName();
        }
        return foodAndCategory;
    }

}

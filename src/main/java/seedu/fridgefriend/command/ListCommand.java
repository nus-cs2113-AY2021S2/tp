package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.utilities.Ui;

import java.util.List;

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
    public void execute(List<Food> fridge) throws InvalidInputException {
        if (category.equals("")) {
            listEverythingInFridge(fridge);
        } else {
            listByCategory(fridge);
        }
    }

    private void listByCategory(List<Food> fridge) throws InvalidInputException {
        checkIsValidCategory();
        String message = "These are the " + foodCategory + " in your fridge:\n";
        for (int i = 0; i < fridge.size(); i++) {
            message += matchCategory(i, fridge);
        }
        Ui.printMessage(message);
    }

    private void listEverythingInFridge(List<Food> fridge) {
        String message = "Here are the items in your fridge:";
        for (int i = 0; i < fridge.size(); i++) {
            message += getFoodDescription(i, fridge);
        }
        Ui.printMessage(message);
    }

    private String getFoodDescription(int i, List<Food> fridge) {
        int indexShownToUser = i + EXTRA_INDEX;
        String foodDescription = 
                "\n\t" + indexShownToUser +  ". "
                + fridge.get(i).getFoodName() + " ["
                + fridge.get(i).getCategory() + "]";
        return foodDescription;
    }

    private void checkIsValidCategory() throws InvalidInputException {
        if (!FoodCategory.contains(category)) {
            String errorMessage = "Sorry my friend, please enter a valid food category.";
            throw new InvalidInputException(errorMessage);
        }
    }

    private String matchCategory(int index, List<Food> fridge) {
        String foodAndCategory = "";
        if (fridge.get(index).getCategory().equals(foodCategory)) {
            int indexShownToUser = index + EXTRA_INDEX;
            foodAndCategory = "\t" + indexShownToUser + ". " + fridge.get(index).getFoodName();
        }
        return foodAndCategory;
    }

}

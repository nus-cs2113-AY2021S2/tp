package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.EmptyDescriptionException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.utilities.Ui;

import java.util.List;

/**
 * Represents a command to search for a specific food item in the fridge.
 */
public class SearchCommand extends Command {

    private String foodName;

    public SearchCommand(String foodName) throws EmptyDescriptionException {
        if (foodName.isEmpty()) {
            throw new EmptyDescriptionException();
        }

        this.foodName = foodName;
    }

    @Override
    public void execute(List<Food> fridge) {
        showResults(isFound(fridge));
    }

    private boolean isFound(List<Food> fridge) {
        for (Food food: fridge) {
            if (food.getFoodName().equals(foodName)) {
                return true;
            }
        }
        return false;
    }

    private void showResults(Boolean isFound) {
        String message;
        if (isFound == true) {
            message = "You have " + foodName + " in your fridge.";
        } else {
            message = "You do not have " + foodName + " in your fridge.";
        }
        Ui.printMessage(message);
    }
}

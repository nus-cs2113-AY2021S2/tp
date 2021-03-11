package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.EmptyDescriptionException;
import seedu.fridgefriend.food.Food;

import java.util.List;

/**
 * Search for a specific food in the fridge.
 */
public class SearchCommand extends Command {

    private String foodName;
    private static int START_COUNTER = 1;

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
        if (isFound == true) {
            System.out.println("You have " + foodName
                    + " in your fridge.\n");
        } else {
            System.out.println("You do not have " + foodName
                    + " in your fridge.\n");
        }
    }
}

package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.EmptyDescriptionException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.Fridge;
import seedu.fridgefriend.utilities.Ui;

/**
 * Represents a command to search for a specific food item in the fridge.
 */
public class SearchCommand extends Command {

    public static final int NOT_FOUND = -1;
    private String foodName;

    public SearchCommand(String foodName) throws EmptyDescriptionException {
        if (foodName.isEmpty()) {
            throw new EmptyDescriptionException();
        }

        this.foodName = foodName;
    }

    @Override
    public void execute() {
        showResults();
    }

    private void showResults() {
        Ui.printMessage(getMessagePrintedToUser());
    }

    /**
     * Returns the result of the command.
     *
     * @return the message shown to the user
     */
    public String getMessagePrintedToUser() {
        int indexOfFoodStored = getIndexOfFoodStored();
        String message;
        if (indexOfFoodStored >= 0) {
            message = "You have " + foodName + " stored in "
                    + Fridge.getFood(indexOfFoodStored).getStorageLocation()
                    + " of your fridge.";
        } else {
            message = "You do not have " + foodName + " in your fridge.";
        }
        return message;
    }

    private int getIndexOfFoodStored() {
        for (int i = 0; i < Fridge.getSize(); i += 1) {
            Food food = Fridge.getFood(i);
            if (food.getFoodName().equals(foodName)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

}

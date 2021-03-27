package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.EmptyDescriptionException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.utilities.Ui;
import seedu.fridgefriend.utilities.LoggingHandler;

//@@author leeyp
/**
 * Represents a command to search for a specific food item in the fridge.
 */
public class SearchCommand extends Command {

    private final String foodName;
    private boolean isContain;

    public SearchCommand(String foodName) throws EmptyDescriptionException {
        if (foodName.isEmpty()) {
            throw new EmptyDescriptionException();
        }
        this.foodName = foodName;
        this.isContain = false;
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
        assert !foodName.equals(null) : "Unable to search a null food name";
        StringBuilder message = new StringBuilder("These are the "
                + foodName + " in your fridge:");
        int indexShownToUser = 1;
        for (int i = 0; i < fridge.getSize(); i += 1) {
            Food food = fridge.getFood(i);
            if (food.getFoodName().contains(foodName)) {
                isContain = true;
                message.append("\n\t").append(indexShownToUser)
                        .append(". ").append(food.toString());
                ++indexShownToUser;
            }
        }

        if (!isContain) {
            LoggingHandler.logInfo("Search for food unsuccessful: No " + foodName + " found.");
            return "You do not have " + foodName + " in your fridge.";
        }

        LoggingHandler.logInfo("Search for food successful: " + foodName + " found.");
        return message.toString();
    }

}

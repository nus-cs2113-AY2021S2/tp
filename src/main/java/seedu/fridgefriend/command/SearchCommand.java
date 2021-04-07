package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.EmptyDescriptionException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.utilities.Ui;
import seedu.fridgefriend.utilities.LoggingHandler;

//@@author SimJJ96
/**
 * Represents a command to search for specific food items in the fridge.
 */
public class SearchCommand extends Command {

    private final String foodName;
    private boolean isFound;
    private int index = 1;

    public SearchCommand(String foodName) throws EmptyDescriptionException {
        if (foodName.isEmpty()) {
            throw new EmptyDescriptionException();
        }
        this.foodName = foodName;
        this.isFound = false;
    }

    @Override
    public void execute() {
        showResults();
    }

    private void showResults() {
        Ui.printMessage(getMessagePrintedToUser());
    }

    /**
     * Returns the results after searching for food items in the
     * fridge that contains the specified food name.
     * If unable to find, display unsuccessful message.
     *
     * @return the message shown to the user
     */
    public String getMessagePrintedToUser() {
        assert !foodName.equals(null) : "Unable to search a null food name";
        StringBuilder message = getSearchByNameMessage();
        if (isFound) {
            LoggingHandler.logInfo("Search for food successful: " + foodName + " found.");
            return message.toString();
        } else {
            LoggingHandler.logInfo("Search for food unsuccessful: No " + foodName + " found.");
            return "You do not have " + foodName + " in your fridge.";
        }
    }

    /**
     * Returns the list of foods that contain the foodName.
     *
     * @return the string of food that contains the foodName in the fridge
     */
    private StringBuilder getSearchByNameMessage() {
        StringBuilder message = new StringBuilder("These are the "
                + foodName + " in your fridge:");
        for (int i = 0; i < fridge.getSize(); i += 1) {
            Food food = fridge.getFood(i);
            isContain(message, food);
        }
        return message;
    }

    /**
     * Check if the food contain the foodName entered by the user.
     *
     * @param message that is shown to user
     * @param food item in the fridge
     */
    private void isContain(StringBuilder message, Food food) {
        if (food.getFoodName().contains(foodName)) {
            updateMessage(message, food);
        }
    }

    /**
     * Updates the message to be shown to the user based on food containing the foodName.
     *
     * @param message that is shown to user
     * @param food item in fridge that contain the foodName
     */
    private void updateMessage(StringBuilder message, Food food) {
        isFound = true;
        message.append("\n\t").append(index)
                .append(". ").append(food.toString());
        ++index;
    }
    //@author
}

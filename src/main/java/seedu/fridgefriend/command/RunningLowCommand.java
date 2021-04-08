package seedu.fridgefriend.command;

//@@author kwokyto
import seedu.fridgefriend.exception.InvalidQuantityException;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.MinimumQuantity;
import seedu.fridgefriend.utilities.Ui;

public class RunningLowCommand extends Command {

    private static final int DISABLED = 0;
    private static final int MAX_NUMBER_OF_CATEGORY_TYPE = 11;

    private String message = "You are running low on food in these categories:";
    private String stockedUpMessage = "Congrats! You are all stocked up on food! :D";
    private String disabledMessage = "All of your limits has been set to 0.\n"
            + "Please use setlimit command to set at least one food category quantity "
            + "limit to a positive integer.";
    private boolean isStockedUp = true;
    private int numberOfCategoryDisabled = 0;
    private int index = 1;

    public RunningLowCommand() {
        super();
    }

    @Override
    public void execute() throws InvalidQuantityException {
        for (FoodCategory foodCategory : FoodCategory.values()) {
            if (MinimumQuantity.getMinimumQuantity(foodCategory) == DISABLED) {
                numberOfCategoryDisabled++;
                continue;
            }
            updateMessage(foodCategory);
        }
        if (isDisabled()) {
            message = disabledMessage;
        } else if (isStockedUp) {
            message = stockedUpMessage;
        }

        Ui.printMessage(message);
    }

    private void updateMessage(FoodCategory foodCategory) throws InvalidQuantityException {
        if (fridge.isRunningOut(foodCategory)) {
            isStockedUp = false;
            int totalQuantity = fridge.getTotalQuantity(foodCategory);
            String entry = "\n" + index + ". " + foodCategory.toString() + " quantity: " + totalQuantity
                    + " out of " + MinimumQuantity.getMinimumQuantity(foodCategory);
            message += entry;
            index += 1;
        }
    }

    public String getMessage() {
        return message;
    }

    //@@author SimJJ96
    private boolean isDisabled() {
        if (numberOfCategoryDisabled == MAX_NUMBER_OF_CATEGORY_TYPE) {
            return true;
        }
        return false;
    }

}

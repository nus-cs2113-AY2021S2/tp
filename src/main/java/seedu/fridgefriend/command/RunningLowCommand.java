package seedu.fridgefriend.command;

//@@author kwokyto
import seedu.fridgefriend.exception.InvalidQuantityException;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.utilities.Ui;

public class RunningLowCommand extends Command {

    private String message = "You are running low on food in these categories:";
    private String stockedUpMessage = "Congrats! You are all stocked up on food! :D";
    private String turnOffMessage = "Running low command is turn off.\n"
            + "Please set at least one food category limit to a positive integer.";
    private boolean isStockedUp = true;
    private static final int TURN_OFF = -1;
    private int numberOfCategoryTurnOff = 0;
    private int index = 1;
    
    public RunningLowCommand() {
        super();
    }

    @Override
    public void execute() throws InvalidQuantityException {
        for (FoodCategory foodCategory : FoodCategory.values()) {
            if (FoodCategory.getMinimumQuantity(foodCategory) == TURN_OFF) {
                numberOfCategoryTurnOff++;
                continue;
            }
            updateMessage(foodCategory);
        }
        if (isStockedUp) {
            message = stockedUpMessage;
        }
        if (isTurnOff()) {
            message = turnOffMessage;
        }
        Ui.printMessage(message);
    }

    private void updateMessage(FoodCategory foodCategory) throws InvalidQuantityException {
        if (fridge.isRunningOut(foodCategory)) {
            isStockedUp = false;
            int totalQuantity = fridge.getTotalQuantity(foodCategory);
            String entry = "\n" + index + ". " + foodCategory.toString() + " quantity: " + totalQuantity
                    + " out of " + FoodCategory.getMinimumQuantity(foodCategory);
            message += entry;
            index += 1;
        }
    }

    public String getMessage() {
        return message;
    }

    private boolean isTurnOff () {
        if (numberOfCategoryTurnOff == 11) {
            return true;
        }
        return false;
    }
}

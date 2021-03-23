package seedu.fridgefriend.command;

import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.utilities.Ui;

public class RunningLowCommand extends Command {

    private String message = "You are running low on food in these categories:";
    private String stockedUpMessage = "Congrats! You are all stocked up on food! :D";
    private boolean isStockedUp = true;
    private int index = 1;
    
    public RunningLowCommand() {
        super();
    }

    @Override
    public void execute() {
        for (FoodCategory foodCategory : FoodCategory.values()) {
            updateMessage(foodCategory);
        }
        if (isStockedUp) {
            message = stockedUpMessage;
        }
        Ui.printMessage(message);
    }

    private void updateMessage(FoodCategory foodCategory) {
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
}

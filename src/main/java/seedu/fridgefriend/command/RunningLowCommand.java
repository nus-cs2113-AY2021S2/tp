package seedu.fridgefriend.command;

import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.utilities.Ui;

public class RunningLowCommand extends Command {

    private String message = "You are running low on food in these categories:";
    private int index = 1;
    
    public RunningLowCommand() {
        super();
    }

    @Override
    public void execute() {
        for (FoodCategory foodCategory : FoodCategory.values()) {
            updateMessage(foodCategory);
        }
        Ui.printMessage(message);
    }

    private void updateMessage(FoodCategory foodCategory) {
        if (fridge.isRunningOut(foodCategory)) {
            int totalQuantity = fridge.getTotalQuantity(foodCategory);
            String entry = "\n" + index + ". " + foodCategory.toString() + " quantity: " + totalQuantity
                    + " out of " + FoodCategory.getMinimumQuantity(foodCategory);
            message += entry;
            index += 1;
        }
    }
}

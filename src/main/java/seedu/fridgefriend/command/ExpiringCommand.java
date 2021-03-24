package seedu.fridgefriend.command;

import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.utilities.Ui;

/**
 * Represents a command to find food items that are expiring within a week.
 */
public class ExpiringCommand extends Command {

    private String message = "These are the food expiring in the next week:";
    private int index = 1;

    public ExpiringCommand() {
        super();
    }

    @Override
    public void execute() {
        for (int i = 0; i < fridge.getSize(); i += 1) {
            updateMessage(fridge.getFood(i));
        }
        Ui.printMessage(message);
    }

    /**
     * Updates the message to be shown to the user based on the food's expiry date.
     * 
     * @param food food item in the fridge
     */
    private void updateMessage(Food food) {
        if (food.isExpiring()) {
            addToMessage(food);
        }
    }

    /**
     * Adds food description and list index to the return message.
     * 
     * @param food food item that is expiring in a week
     */
    private void addToMessage(Food food) {
        String entry = "\n" + index + ". " + food.toString();
        message += entry;
        index += 1;
    }
}

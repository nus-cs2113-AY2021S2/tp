package seedu.fridgefriend.command;

//@@author kwokyto
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.utilities.Ui;

/**
 * Represents a command to find food items that are expiring within a week.
 */
public class ExpiringCommand extends Command {

    private String message_expiring = "These are the food expiring in the next week:";
    private String message_expired = "These are the food that has aready expired:";
    private String message_no_expiring = "These are no food expiring in the next week!";
    private String message_no_expired = "No food has expired! Congratulations!";
    private int index = 1;
    private boolean hasExpiring;
    private boolean hasExpired;

    public ExpiringCommand() {
        super();
    }

    @Override
    public void execute() {
        for (int i = 0; i < fridge.getSize(); i += 1) {
            updateMessage(fridge.getFood(i));
        }
        if (hasExpired) {
            Ui.printMessage(message_expired);
        } else {
            Ui.printMessage(message_no_expired);
        }
        if (hasExpiring) {
            Ui.printMessage(message_expiring);
        } else {
            Ui.printMessage(message_no_expiring);
        }
    }

    //@@author Vinci-Hu
    /**
     * Updates the message to be shown to the user based on the food's expiry date.
     * 
     * @param food food item in the fridge
     */
    private void updateMessage(Food food) {
        if (food.hasExpired()) {
            addToExpiredMessage(food);
            hasExpired = true;
        }
        if (food.isExpiring()) {
            addToExpiringMessage(food);
            hasExpiring = true;
        }
    }

    /**
     * Adds food description and list index to the return message.
     * 
     * @param food food item that is expiring in a week
     */
    private void addToExpiringMessage(Food food) {
        String entry = "\n" + index + ". " + food.toString();
        message_expiring += entry;
        index += 1;
    }

    private void addToExpiredMessage(Food food) {
        String entry = "\n" + index + ". " + food.toString();
        message_expired += entry;
        index += 1;
    }
}

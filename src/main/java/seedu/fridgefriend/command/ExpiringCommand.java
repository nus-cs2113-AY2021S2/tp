package seedu.fridgefriend.command;

//@@author Vinci-Hu
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.utilities.Ui;

/**
 * Represents a command to find food items that are expiring within a week.
 */
public class ExpiringCommand extends Command {

    private String messageExpiring = "These are the food expiring in the following week:";
    private String messageExpired = "\n\nThese are the food that has already expired, please consider removing them:";
    private String messageNoExpiring = "There are no food expiring in 7 days time!";
    private String fullMessage = "";
    private int indexExpiring = 0;
    private int indexExpired = 0;

    public ExpiringCommand() {
        super();
    }

    @Override
    public void execute() {
        for (int i = 0; i < fridge.getSize(); i += 1) {
            updateExpiringMessage(fridge.getFood(i));
        }
        for (int i = 0; i < fridge.getSize(); i += 1) {
            updateExpiredMessage(fridge.getFood(i));
        }
        if (indexExpiring > 0) {
            fullMessage += messageExpiring;
        } else {
            fullMessage += messageNoExpiring;
        }
        if (indexExpired > 0) {
            fullMessage += messageExpired;
        }
        Ui.printMessage(fullMessage);
    }

    /**
     * This getter must be called after .execute() .
     * @return the fullMessage string.
     */
    public String getMessage() {
        return fullMessage;
    }

    private void updateExpiringMessage(Food food) {
        if (food.isExpiring()) {
            addToExpiringMessage(food);
        }
    }

    private void updateExpiredMessage(Food food) {
        if (food.hasExpired()) {
            addToExpiredMessage(food);
        }
    }

    /**
     * Adds food description and list index to the return message.
     * 
     * @param food food item that is expiring in a week
     */
    private void addToExpiringMessage(Food food) {
        indexExpiring++;
        String entry = "\n" + indexExpiring + ". " + food.toString();
        messageExpiring += entry;
    }

    private void addToExpiredMessage(Food food) {
        indexExpired++;
        String entry = "\n" + indexExpired + ". " + food.toString();
        messageExpired += entry;
    }

}

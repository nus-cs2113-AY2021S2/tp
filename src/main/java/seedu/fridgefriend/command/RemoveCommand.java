package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.InvalidIndexException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.Fridge;
import seedu.fridgefriend.utilities.Ui;

/**
 * Represents a command to remove a food item from the fridge by index specify by user.
 */
public class RemoveCommand extends Command {

    private static final int EXTRA_INDEX = 1;

    private final int indexToRemove;
    private Food foodToBeRemoved;

    /**
     * Constructor creates a RemoveCommand object.
     * 
     * @param indexToRemove integer index given by user
     * @throws InvalidIndexException if provided index is out of bounds
     */
    public RemoveCommand(int indexToRemove) throws InvalidIndexException {
        int actualIndexToRemoved = indexToRemove - EXTRA_INDEX;
        this.indexToRemove = actualIndexToRemoved;
        try {
            this.foodToBeRemoved = Fridge.getFood(actualIndexToRemoved);
        } catch (Exception e) {
            throw new InvalidIndexException(e);
        }
    }

    @Override
    public void execute() {
        removeFood();
        showMessage();
    }

    public void removeFood() {
        Fridge.removeByIndex(indexToRemove);
    }

    private void showMessage() {
        String message = "Noted! I've removed " + foodToBeRemoved.getFoodName()
                + " from your fridge.\n"
                + "Now you have " + Fridge.getSize()
                + " food in the fridge.";
        Ui.printMessage(message);
    }

    /**
     * Return the actual message shown to user for JUnit-test.
     *
     * @return the actual message after remove food from fridge to the user
     */
    public String actualMessage() {
        String message = "Noted! I've removed " + foodToBeRemoved.getFoodName()
                + " from your fridge.\n"
                + "Now you have " + Fridge.getSize()
                + " food in the fridge.";
        return message;
    }
}

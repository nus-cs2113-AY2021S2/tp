package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.InvalidIndexException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.utilities.Ui;

import java.util.List;

/**
 * Represents a command to remove a food item from the fridge by index specify by user.
 */
public class RemoveCommand extends Command {

    private static final int EXTRA_INDEX = 1;

    private final int indexToRemove;
    private Food foodToBeRemove;

    /**
     * Constructor creates a RemoveCommand object.
     * 
     * @param indexToRemove integer index given by user
     * @param fridge fridge data structure
     * @throws InvalidIndexException if provided index is out of bounds
     */
    public RemoveCommand(int indexToRemove, List<Food> fridge) throws InvalidIndexException {
        int actualIndexToRemove = indexToRemove - EXTRA_INDEX;
        this.indexToRemove = actualIndexToRemove;
        try {
            this.foodToBeRemove = fridge.get(actualIndexToRemove);
        } catch (Exception e) {
            throw new InvalidIndexException(e);
        }
    }

    @Override
    public void execute(List<Food> fridge) {
        removeFood(fridge);
        showMessage(fridge);
    }

    public void removeFood(List<Food> fridge) {
        if (indexToRemove > fridge.size()) {
            throw new IndexOutOfBoundsException();
        }
        fridge.remove(indexToRemove);
    }

    private void showMessage(List<Food> fridge) {
        String message = "Noted! I've removed " + foodToBeRemove.getFoodName()
                + " from your fridge.\n"
                + "Now you have " + fridge.size()
                + " food in the fridge.";
        Ui.printMessage(message);
    }
}

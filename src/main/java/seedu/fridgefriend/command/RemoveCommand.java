package seedu.fridgefriend.command;

import seedu.fridgefriend.food.Food;

import java.util.List;

/**
 * Remove the food from the fridge by index specify by user.
 */
public class RemoveCommand extends Command {

    private static final int EXTRA_INDEX = 1;

    private final int indexToRemove;
    private Food foodToBeRemove;

    public RemoveCommand(int indexToRemove, List<Food> fridge) {
        int actualIndexToRemove = indexToRemove - EXTRA_INDEX;
        this.indexToRemove = actualIndexToRemove;
        this.foodToBeRemove = fridge.get(actualIndexToRemove);
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
        System.out.println("Noted! I've removed " + foodToBeRemove.getFoodName()
                + " from your fridge.\n"
                + "Now you have " + fridge.size()
                + " food in the fridge.\n");
    }
}

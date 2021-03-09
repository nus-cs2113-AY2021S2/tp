package seedu.fridgefriend.command;

import seedu.fridgefriend.food.Food;

import java.util.List;


/**
 * Remove the food from the fridge by index specify by user.
 */
public class RemoveCommand extends Command {

    private static final int EXTRA_INDEX = 1;

    private final int indexToRemove;

    public RemoveCommand(int indexToRemove) {
        this.indexToRemove = indexToRemove - EXTRA_INDEX;
    }

    @Override
    public void execute(List<Food> fridge) {
        showMessageBeforeRemove(fridge);
        removeFood(fridge);
        showMessageAfterRemove(fridge);
    }

    private void showMessageBeforeRemove(List<Food> fridge) {
        System.out.println("Noted! I've removed " + fridge.get(indexToRemove).getFoodName()
                + " from your fridge.");
    }

    private void removeFood(List<Food> fridge) {
        fridge.remove(indexToRemove);
    }

    private void showMessageAfterRemove(List<Food> fridge) {
        System.out.println("Now you have " + fridge.size()
                + " food in the fridge.\n");
    }
}

package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.FoodNameNotFoundException;
import seedu.fridgefriend.exception.InvalidIndexException;
import seedu.fridgefriend.exception.InvalidQuantityException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.utilities.Ui;

/**
 * Represents a command to remove a food item from the fridge by index specify by user.
 */
public class RemoveCommand extends Command {

    //variables used in remove by index
    private static final int EXTRA_INDEX = 1;
    private String foodNameToEdit;
    private int indexToRemove;
    private Food foodToBeRemoved;
    private String runningOutMessage = "";

    //variables used in remove by name and qty
    private Food foodToBeEditted;
    private int editQuantity;
    private boolean isRemoveObject = false;

    /**
     * Constructor creates a RemoveCommand object.
     * Not used currently
     * @param indexToRemove integer index given by user
     */
    public RemoveCommand(int indexToRemove) {
        int actualIndexToRemoved = indexToRemove - EXTRA_INDEX;
        this.indexToRemove = actualIndexToRemoved;
    }

    /**
     * Constructor which takes in foodname and quantity to remove.
     * @param foodnameToEdit food name is identifier
     * @param quantity integer value.
     */
    public RemoveCommand(String foodnameToEdit, int quantity) {
        this.foodNameToEdit = foodnameToEdit;
        this.editQuantity = quantity;
    }

    private Food findFoodByName(String foodnameToEdit) throws FoodNameNotFoundException {
        for (Food food : fridge.getFridge()) {
            if (food.getFoodName().equals(foodnameToEdit)) {
                return food;
            }
        }
        throw new FoodNameNotFoundException();
    }

    @Override
    public void execute() throws InvalidQuantityException, FoodNameNotFoundException {
        foodToBeEditted = findFoodByName(foodNameToEdit);
        removePortion();
        checkRunningOut();
        showResults();
    }

    private void removeFood() throws InvalidIndexException {
        //currently not using, may change to delete command
        try {
            this.foodToBeRemoved = fridge.getFood(indexToRemove);
        } catch (Exception e) {
            throw new InvalidIndexException(e);
        }
        fridge.removeByIndex(indexToRemove);
    }

    private void removePortion() throws InvalidQuantityException {
        int originalQty = foodToBeEditted.getQuantity();
        int newQty = originalQty - editQuantity;
        if (newQty < 0) {
            throw new InvalidQuantityException("Not enough in fridge to remove!");
        } else if (newQty == 0) {
            this.isRemoveObject = true;
            foodToBeRemoved = foodToBeEditted;
            fridge.getFridge().remove(foodToBeEditted);
        } else {
            foodToBeEditted.setQuantity(newQty);
        }
    }

    private void showResults() {
        String message = getMessagePrintedToUser();
        message += runningOutMessage;
        Ui.printMessage(message);
    }

    /**
     * Return the results after remove the item from the fridge.
     * If there is some quantity left, display new quantity.
     * @return the message shown to user
     */
    public String getMessagePrintedToUser() {
        String message;
        if (isRemoveObject) {
            message = "Noted! I've removed " + foodToBeRemoved.getFoodName()
                    + " from your fridge.\n"
                    + "Now you have " + fridge.getSize()
                    + " food in the fridge.";
        } else {
            message = "Noted! I've removed " + editQuantity
                    + " of the food " + foodToBeEditted.getFoodName()
                    + " from your fridge.\n"
                    + "New quantity: " + foodToBeEditted.getQuantity();
        }

        return message;
    }
    
    /**
     * Checks if the amount of food left for that category is insufficient.
     * Appends a warning message to the user if true.
     */
    private void checkRunningOut() {
        FoodCategory foodCategory = foodToBeRemoved.getCategory();
        if (fridge.isRunningOut(foodCategory)) {
            int totalQuantity = fridge.getTotalQuantity(foodCategory);
            runningOutMessage = "WARNING! " + foodCategory.toString() + " is running low on food!\n"
                    + foodCategory.toString() + " quantity: " + totalQuantity;
        }
    }

}

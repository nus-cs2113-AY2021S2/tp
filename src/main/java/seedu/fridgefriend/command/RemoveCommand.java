package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.FoodNameNotFoundException;
import seedu.fridgefriend.exception.InvalidQuantityException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.utilities.Ui;

/**
 * Represents a command to remove a food item from the fridge by index specify by user.
 */
public class RemoveCommand extends Command {

    //variables used in remove by index
    private String foodNameToEdit;
    private Food foodToBeRemoved;

    //variables used in remove by name and qty
    private Food foodToBeEditted;
    private int editQuantity;
    private boolean isRemoveObject = false;
    private String runningOutMessage = "";

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
        message += this.runningOutMessage;
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
        FoodCategory foodCategory = foodToBeEditted.getCategory();
        if (fridge.isRunningOut(foodCategory)) {
            int totalQuantity = fridge.getTotalQuantity(foodCategory);
            this.runningOutMessage = "\nWARNING! You are running low on " + foodCategory.toString()
                    + "\nTotal " + foodCategory.toString() + " quantity: " + totalQuantity;
        }
    }

}

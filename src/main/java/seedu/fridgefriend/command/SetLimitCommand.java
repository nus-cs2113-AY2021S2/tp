package seedu.fridgefriend.command;

import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.utilities.Ui;

public class SetLimitCommand extends Command {

    private FoodCategory foodCategory;
    private int quantity;

    public SetLimitCommand(FoodCategory foodCategory, int quantity) {
        this.foodCategory = foodCategory;
        this.quantity = quantity;
    }

    @Override
    public void execute() {
        FoodCategory.setMinimumQuantity(foodCategory, quantity);
        String message = getSetLimitMessage();
        Ui.printMessage(message);
    }

    public String getSetLimitMessage() {
        String message = "Okie dokie! The new minimum quantity for category '" 
                + foodCategory.toString() + "' is " + quantity;
        return message;
    }
}

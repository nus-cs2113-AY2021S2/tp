package seedu.fridgefriend.command;

//@@author kwokyto
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.MinimumQuantity;
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
        MinimumQuantity.setMinimumQuantity(foodCategory, quantity);
        String message = getSetLimitMessage();
        Ui.printMessage(message);
    }

    public String getSetLimitMessage() {
        String message = "Okie dokie! The new minimum quantity for category '" 
                + foodCategory.toString() + "' is " + quantity;
        return message;
    }
}

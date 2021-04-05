package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.FoodNameNotFoundException;
import seedu.fridgefriend.exception.InvalidFoodCategoryException;
import seedu.fridgefriend.exception.InvalidFoodLocationException;
import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.exception.InvalidQuantityException;
import seedu.fridgefriend.exception.RepetitiveFoodIdentifierException;
import seedu.fridgefriend.food.Fridge;

/**
 * Represent an executable command.
 */
public abstract class Command {

    protected Fridge fridge;
    protected boolean isExit;

    //@@author kwokyto
    public Command() {
        isExit = false;
    }
    
    //@@author kwokyto
    public boolean isExit() {
        return isExit;
    }

    //@@author SimJJ96
    public abstract void execute() throws InvalidInputException, RepetitiveFoodIdentifierException,
            InvalidQuantityException, FoodNameNotFoundException,
            InvalidFoodCategoryException, InvalidFoodLocationException;

    //@@author Vinci-Hu
    public void setData(Fridge fridge) {
        this.fridge = fridge;
    }

}

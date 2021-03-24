package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.FoodNameNotFoundException;
import seedu.fridgefriend.exception.InvalidIndexException;
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

    public Command() {
        isExit = false;
    }
    
    public boolean isExit() {
        return isExit;
    }

    public abstract void execute() throws InvalidInputException,
            InvalidIndexException, RepetitiveFoodIdentifierException,
            InvalidQuantityException, FoodNameNotFoundException;

    public void setData(Fridge fridge) {
        this.fridge = fridge;
    }

}

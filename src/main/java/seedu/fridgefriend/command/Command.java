package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.*;
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
            InvalidQuantityException, FoodNameNotFoundException, InvalidFoodCategoryException;

    //@@author Vinci-Hu
    public void setData(Fridge fridge) {
        this.fridge = fridge;
    }

}

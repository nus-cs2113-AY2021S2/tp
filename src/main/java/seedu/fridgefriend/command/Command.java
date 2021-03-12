package seedu.fridgefriend.command;

import java.util.List;

import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.food.Food;

/**
 * Represent an executable command.
 */
public abstract class Command {

    protected boolean isExit;

    public Command() {
        isExit = false;
    }
    
    public boolean isExit() {
        return isExit;
    }

    public abstract void execute(List<Food> fridge) throws InvalidInputException;

}

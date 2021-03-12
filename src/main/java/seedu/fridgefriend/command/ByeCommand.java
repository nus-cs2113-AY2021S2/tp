package seedu.fridgefriend.command;

import java.util.List;

import seedu.fridgefriend.food.Food;

/**
 * Represents a command to exit the application.
 */
public class ByeCommand extends Command {

    public ByeCommand() {
        super();
    }

    public boolean isExit() {
        return isExit;
    }

    public void setExit(boolean isExit) {
        this.isExit = isExit;
    }

    @Override
    public void execute(List<Food> fridge) {
        setExit(true);
    }
    
}

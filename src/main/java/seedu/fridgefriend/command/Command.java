package seedu.fridgefriend.command;

import seedu.fridgefriend.food.Food;

import java.util.List;

/**
 * Represent an executable command.
 */
public abstract class Command {

    public abstract void execute(List<Food> fridge);

}

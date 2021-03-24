package seedu.fridgefriend.command;

import java.util.EnumSet;

import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.utilities.Ui;

/**
 * Represents a command to show help instructions.
 */
public class HelpCommand extends Command {

    private static final String COMMANDS = "These are the list of available commands:\n"
            + "\tadd foodName /cat categoryName /exp dd-mm-yyyy /loc storageLocation /qty foodQuantity\n"
            + "\tlist\n"
            + "\tlist categoryName\n"
            + "\tremove foodName /qty removeQuantity\n"
            + "\tsearch searchString\n"
            + "\texpiring\n"
            + "\trunninglow\n"
            + "\tsetlimit foodCategory /qty newLimit\n"
            + "\tclear\n"
            + "\thelp\n"
            + "\tbye";
    
    private static final String CATEGORIES = "This is the list of food categories:\n\t"
            + EnumSet.allOf(FoodCategory.class).toString();

    private static final String LOCATIONS = "This is the list of storage locations:\n\t"
            + EnumSet.allOf(FoodStorageLocation.class).toString();

    public HelpCommand() {
        super();
    }

    @Override
    public void execute() {
        String helpMessage = COMMANDS + "\n\n" + CATEGORIES + "\n\n" + LOCATIONS;
        Ui.printMessage(helpMessage);
    }
    
}

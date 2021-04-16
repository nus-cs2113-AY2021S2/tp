package seedu.duke.command.generalcommand;

import seedu.duke.command.Command;
import seedu.duke.ui.UiManager;

/**
 * Shows all the possible commands that the user can use.
 */
public class HelpCommand extends Command {
    protected UiManager ui;
    private static final String MESSAGE_SUCCESS = "1.  go:\n"
            + "\t" + "* finds the route to go from one block to another block or eatery\n"
            + "2.  history:\n"
            + "\t" + "* lists past 10 route searches\n"
            + "3.  clear history:\n"
            + "\t" + "* deletes all past route searches from history\n"
            + "4.  repeat history:\n"
            + "\t" + "* repeats the past route search of your choice\n"
            + "5.  add alias:\n"
            + "\t" + "* creates an alias for an existing block\n"
            + "6.  show alias:\n"
            + "\t" + "* lists all aliases that are currently active\n"
            + "7.  delete alias:\n"
            + "\t" + "* deletes an alias that was previously created\n"
            + "8.  add daily route:\n"
            + "\t" + "* adds a schedule for the selected day\n"
            + "9.  show daily route:\n"
            + "\t" + "* shows the generated route for the schedule of the selected day\n"
            + "10. delete daily route:\n"
            + "\t" + "* deletes the stored schedule based on the index number tagged to the day\n"
            + "11. add note:\n"
            + "\t" + "* adds and tags a note to a particular location\n"
            + "12. show notes:\n"
            + "\t" + "* list notes tagged to the given location\n"
            + "13. delete note:\n"
            + "\t" + "* deletes notes based on index number tagged to the given location\n"
            + "14. add favourite:\n"
            + "\t" + "* adds a favourite route\n"
            + "15. show favourite:\n"
            + "\t" + "* lists all favourite routes that were previously created\n"
            + "16. delete favourite:\n"
            + "\t" + "* deletes a favourite route based on index number tagged to the route\n"
            + "17. show venues:\n"
            + "\t" + "* lists all possible venues that can be used in the application (excluding user's alias)\n"
            + "18. bye:\n"
            + "\t" + "* exits the application";

    public HelpCommand() {
        this.ui = new UiManager();
    }

    /** Prints out the help message. */
    public void execute() {
        ui.showMessageWithDivider(MESSAGE_SUCCESS);
    }
}

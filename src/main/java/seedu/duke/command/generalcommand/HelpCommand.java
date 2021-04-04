package seedu.duke.command.generalcommand;

import seedu.duke.command.Command;
import seedu.duke.ui.UiManager;

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
            + "10. add note:\n"
            + "\t" + "* adds and tags a note to a particular location\n"
            + "11. show notes:\n"
            + "\t" + "* list notes tagged to the given location\n"
            + "12. delete note:\n"
            + "\t" + "* deletes notes based on index number tagged to the given location\n"
            + "13. add favourite:\n"
            + "\t" + "* adds a favourite route\n"
            + "14. show favourite:\n"
            + "\t" + "* lists all favourite routes that were previously created\n"
            + "15. delete favourite:\n"
            + "\t" + "* deletes a favourite route based on index number tagged to the route\n"
            + "16. bye:\n"
            + "\t" + "* exits the application";

    public HelpCommand() {
        this.ui = new UiManager();
    }

    public void execute() {
        ui.showMessageWithDivider(MESSAGE_SUCCESS);
    }
}

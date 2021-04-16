package seedu.easylog.commands;

public class HelpCommand extends Command {

    /**
     * Prints out the list of available commands in the program.
     */
    public void execute() {
        ui.showHelp();
    }
}

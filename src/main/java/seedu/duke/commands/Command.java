package seedu.duke.commands;

public abstract class Command {
    public static final int ADD_MODULE_COMMAND = 1;
    public static final int DEL_MODULE_COMMAND = 2;
    public static final int LIST_MODULE_COMMAND = 3;
    public static final int ENTER_MODULE_COMMAND = 4;
    public static final int PRINT_HELP_COMMAND = 5;
    public static final int EXIT_PROGRAM_COMMAND = 6;

    public static final int UNKNOWN_COMMAND = 99;

    public abstract Boolean execute();
}
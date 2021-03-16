package seedu.duke.command;

public class InvalidCommand extends Command {
    private CommandType commandType;
    private static final String ERROR_MESSAGE_FOR_ADD_COMMAND = "The syntax for add command is:\n"
            + "1. Add exercise record\nadd  t/E a/ACTIVITY_NAME  d/DURATION  [date/DD-MM-YYYY]\n"
            + "2. Add diet record\nadd t/D f/FOOD_NAME  w/WEIGHT  [date/DD-MM-YYYY]\n" + "3.Add sleep record\n"
            + "add  t/S  d/DURATION  [date/DD-MM-YYYY]" + "4.Add body weight record\nadd  t/W w/WEIGHT "
            + "[date/DD-MM-YYYY]\n";
    private static final String ERROR_MESSAGE_FOR_VIEW_COMMAND = "The syntax for view command is:\n"
            + "1. View exercise records\nview  t/E [a/ACTIVITY_NAME] [date/DD-MM-YYYY]\n"
            + "2. View diet records\nview t/D [f/FOOD_NAME] [date/DD-MM-YYYY]\n" + "3.View sleep records\n"
            + "view  t/S [date/DD-MM-YYYY]" + "4.View body weight records\nview  t/W [date/DD-MM-YYYY]\n";

    public InvalidCommand(String errorMessage) {
        feedback = errorMessage;
    }

    public InvalidCommand(CommandType commandType) {
        switch (commandType) {
        case ADD:
            feedback = ERROR_MESSAGE_FOR_ADD_COMMAND;
            break;
        case VIEW:
            feedback = ERROR_MESSAGE_FOR_VIEW_COMMAND;
            break;
        default:
            System.out.println("There is something wrong within the system.");
        }
        System.out.println(feedback);
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(feedback);
    }
}

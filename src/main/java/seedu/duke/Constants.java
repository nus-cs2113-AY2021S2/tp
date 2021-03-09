package seedu.duke;

public class Constants {
    public static String ADD_INFO_MESSAGE = "Adds a patient to the list\n"
            + "Command prefix: add\n"
            + "Argument(s): name, IC number\n"
            + "Usage: add name/<NAME> ic/<IC_NUMBER>\n"
            + "Example: add name/John Doe ic/S1234567A\n\n";
    public static String LIST_INFO_MESSAGE = "Shows the list of all patients\n"
            + "Usage: list\n\n";
    public static String LOAD_INFO_MESSAGE = "Selects the specified patient to add and retrieve records\n"
            + "Command prefix: load\n"
            + "Arguments(s): IC number\n"
            + "Usage: load <IC_NUMBER>\n"
            + "Example: load S1234567A\n\n";
    public static String RECORD_CONSULTATION_INFO_MESSAGE = "Adds a consultation record to the selected patient\n"
            + "Command prefix: record consultation\n"
            + "Arguments(s): consultation details\n"
            + "Usage: record consultation <DETAILS>\n"
            + "Example: record consultation fever\n\n";
    public static String RETRIEVE_INFO_MESSAGE = "Retrieves past consultation record from the selected patient\n"
            + "Usage: retrieve consultation\n\n";
    public static String EXIT_INFO_MESSAGE = "Exits the program\n"
            + "Usage: exit\n\n";
}

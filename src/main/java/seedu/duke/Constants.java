package seedu.duke;

public class Constants {
    // String constants for the main class
    public static final String EXIT_MESSAGE = "Goodbye, we hope to see you again!";
    public static final String WELCOME_MESSAGE = "Welcome to the Patient Manager.\n";
    public static final String INPUT_PROMPT = "Please input a command: ";

    // Help messages
    public static final String COMMAND_LIST_MESSAGE = "Here is a list of available commands:\n"
            + "  add\n  delete\n  list\n  load\n  record\n  retrieve\n  current\n  exit\n"
            + "Type 'help' followed by one or more commands for more details.\n"
            + "Example: help record";
    public static final String ADD_INFO_MESSAGE = "Add a patient to the list.\n"
            + "Command prefix: add\n"
            + "Argument(s): IC number\n"
            + "Usage: add IC_NUMBER\n"
            + "Example: add S1234567D\n";
    public static final String DELETE_INFO_MESSAGE = "Delete a patient from the list.\n"
            + "Argument(s): IC number\n"
            + "Usage: delete /p IC_NUMBER\n"
            + "Example: delete /p S1234567D\n\n"
            + "Delete a record from the list of records for the currently loaded patient.\n"
            + "Argument(s): Date\n"
            + "Usage: delete /r DATE\n"
            + "Example: delete /r 26/03/2021\n";
    public static final String LIST_INFO_MESSAGE = "Show the list of all patients.\n"
            + "Usage: list\n";
    public static final String LOAD_INFO_MESSAGE = "Select a specified patient to add and retrieve records.\n"
            + "Command prefix: load\n"
            + "Argument(s): IC number\n"
            + "Usage: load IC_NUMBER\n"
            + "Example: load S1234567D\n";
    public static final String RECORD_CONSULTATION_INFO_MESSAGE = "Add a consultation record to the selected patient.\n"
            + "Command prefix: record\n"
            + "Arguments(s): consultation details, symptom, diagnosis, prescription\n"
            + "Usage: record [CONSULTATION_DATE] [/s SYMPTOM] [/d DIAGNOSIS] [/p PRESCRIPTION]\n"
            + "Example: record /s fever\n";
    public static final String RETRIEVE_INFO_MESSAGE = "Retrieve past consultation record from the selected patient.\n"
            + "Usage: retrieve\n";
    public static final String CURRENT_INFO_MESSAGE = "Print out the current patient being loaded.\n"
            + "Usage: current\n";
    public static final String HELP_INFO_MESSAGE = "Displays a list of commands or information of selected commands.\n"
            + "Command prefix: help\n"
            + "Argument(s): commands\n"
            + "Usage: help [OPTIONAL_COMMANDS]\n"
            + "Example: help list add\n";
    public static final String EXIT_INFO_MESSAGE = "Exit the program.\n"
            + "Usage: exit\n";

    public static final String INVALID_COMMAND_MESSAGE = "Invalid command: %s";

    public static final String EMPTY_LIST_MESSAGE = "List is currently empty!";

    public static final String LONG_LINE = "----------------------------------------------------------------------";

    // Exception messages
    public static final String INDENT = "\t";

    public static final String INVALID_INPUT = "Input command and/or arguments are invalid";
    public static final String INVALID_INPUT_EMPTY_STRING = "Please enter a command for me to process.";
    public static final String INVALID_INPUT_UNKNOWN_COMMAND = "Invalid command provided.";
    public static final String INVALID_INPUT_INVALID_NRIC = "Please key in a valid NRIC number.";
    public static final String INVALID_INPUT_INVALID_NRIC_FIRST_LETTER =
            "Please ensure that NRIC starts with S,T,F or G";
    public static final String INVALID_INPUT_INVALID_NRIC_CHECKSUM =
            "NRIC does not pass the checksum test, please ensure NRIC is valid eg. G1234567X";
    public static final String INVALID_INPUT_PATIENT_EXISTED = "Patient already exists.";
    public static final String INVALID_INPUT_INVALID_DATE =
            "Please provide a valid date (format: dd/MM/yyyy).\n"
                    + "It should also be a valid date in the Gregorian calendar.";
    public static final String INVALID_FUTURE_DATE = "You cannot save a visit record for a future date.";
    public static final String INVALID_INPUT_UNKNOWN_DELETE_ARGUMENT =
            "Please use exactly one of /p or /r to indicate whether to delete a patient or a record.\n"
                    + "You may use the help command for more clarification.";
    public static final String INVALID_INPUT_EMPTY_NRIC_ARGUMENT = "Please key in NRIC number of patient to delete";
    public static final String INVALID_INPUT_EMPTY_DATE_ARGUMENT = "Please key in a date of record to delete";
    public static final String INVALID_INPUT_PATIENT_NOT_FOUND = "Patient with this IC number does not exist!";
    public static final String INVALID_INPUT_END_OF_FILE = "End of file reached, exiting application.";
    public static final String INVALID_INPUT_FORBIDDEN_SUBSTRING =
            "These substrings are not allowed in the input command:\n"
            + "~   `   %   #   @   !";

    public static final String DATA_NO_RECORD_FOUND = "No records found for the specified date.";
    public static final String DATA_NO_PATIENT_LOADED =
            "Please load a patient with the load command before adding or viewing records.";
    public static final String DATA_EMPTY_DESCRIPTION =
            "Please provide more details about the patient's visit.\n"
                    + "(At least one symptom, diagnosis or prescription must be specified.)";
    public static final String DATA_PATIENT_NOT_FOUND = "The patient with this IC number does not exist.";

    public static final String STORAGE = "Something wrong happened when trying to save/load data";
    public static final String STORAGE_FILE_CREATION_FAIL = "Failed to create a save file.";
    public static final String STORAGE_FILE_WRITE_FAIL = "Failed to write content to the save file.";
    public static final String STORAGE_FILE_NOT_FOUND = "Save file does not exist so we use an empty patient list!";

    public static final String UNKNOWN = "We have encountered an unknown error";

    // Number constants
    public static final int ID_NUMBER_OF_CHARACTERS = 9;
    public static final int INDEX_OF_FIRST_CHARACTER = 0;
    public static final int INDEX_OF_SECOND_CHARACTER = 1;
    public static final int INDEX_OF_EIGHTH_CHARACTER = 7;
    public static final int INDEX_OF_LAST_CHARACTER = 8;

    public static final int CHECKSUM_MOD = 11;
    public static final int CHECKSUM_NUMBER = 4;
    public static final int FIRST_DIGIT = 1;
    public static final int SECOND_DIGIT = 2;
    public static final int THIRD_DIGIT = 3;
    public static final int FOURTH_DIGIT = 4;
    public static final int FIFTH_DIGIT = 5;
    public static final int SIXTH_DIGIT = 6;
    public static final int LAST_DIGIT = 7;

    // Checksum letters for NRIC numbers
    public static final char[] ST_NRIC_CHECKDIGIT = {'J', 'Z', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A'};
    public static final char[] FG_NRIC_CHECKDIGIT = {'X', 'W', 'U', 'T', 'R', 'Q', 'P', 'N', 'M', 'L', 'K'};

    // Keys for the argument HashMap
    public static final String PAYLOAD_KEY = "payload";
    public static final String PATIENT_KEY = "p";
    public static final String RECORD_KEY = "r";
    public static final String SYMPTOM_KEY = "s";
    public static final String DIAGNOSIS_KEY = "d";
    public static final String PRESCRIPTION_KEY = "p";

    // Date format
    public static final String DATE_PATTERN = "dd/MM/uuuu";

    // Class path for command classes
    public static final String COMMAND_CLASS_PREFIX = "seedu.duke.command.";

    // Delimiters for storage class
    public static final String ID_DELIMITER = "~~";
    public static final String DATE_DELIMITER = "``";
    public static final String SYMPTOM_DELIMITER = "%%";
    public static final String DIAGNOSIS_DELIMITER = "##";
    public static final String PRESCRIPTION_DELIMITER = "@@";
    public static final String RECORDS_DELIMITER = "!R!";
    public static final String DETAILS_DELIMITER = "!D!";

    public static final String STORAGE_DEFAULT_PATH = "./pm.save";
}

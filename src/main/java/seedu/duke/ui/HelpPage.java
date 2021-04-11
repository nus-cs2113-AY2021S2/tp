package seedu.duke.ui;

import static seedu.duke.ui.Ui.DIVIDER;

/**
 * Handles all printing of help related command messages to the console.
 */
public class HelpPage {
    private static final String TAB_1SPACE = "\t";
    private static final String TAB_2SPACE = "\t\t";
    private static final String MAN_HEADER_ADD = "add a record to the program";
    private static final String MAN_SYNOPSIS_ADD = "add [OPTION] [ARGUMENT]";
    private static final String MAN_HEADER_LIST = "list all the records";
    private static final String MAN_SYNOPSIS_LIST = "list [OPTION]";
    private static final String MAN_HEADER_VIEW = "view the total amount";
    private static final String MAN_SYNOPSIS_VIEW = "view [OPTION]";
    private static final String MAN_HEADER_REMOVE = "remove a record in the program";
    private static final String MAN_SYNOPSIS_REMOVE = "remove [OPTION] [ARGUMENT]";
    private static final String MAN_HEADER_RETURN = "record a loan as returned";
    private static final String MAN_SYNOPSIS_RETURN = "return [OPTION] [ARGUMENT]";
    private static final String MAN_HEADER_EXIT = "terminate the program";
    private static final String MAN_SYNOPSIS_EXIT = "exit (no option/argument needed)";
    private static final String MAN_HEADER_CREDITSCORE = "check a person credit rating";
    private static final String MAN_SYNOPSIS_CREDITSCORE = "creditscore [ARGUMENT]";
    private static final String MAN_OPTION_RECORD_TYPE = "-e, -l, -s";
    private static final String MAN_OPTION_RECORD_TYPE_ALL = "-e, -l, -s, -a";
    private static final String MAN_OPTION_RECORD_TYPE_DESCRIPTION = "[ARGUMENT] used as record description";
    private static final String MAN_OPTION_RECORD_TYPE_LISTING = "used to list the chosen record type, "
            + "-a will list all records";
    private static final String MAN_OPTION_RECORD_TYPE_VIEWING = "used to view total amount of chosen record type, "
            + "-a will show all category amount";
    private static final String MAN_OPTION_AMOUNT = "-a";
    private static final String MAN_OPTION_AMOUNT_DESCRIPTION = "[ARGUMENT] positive non zero numeric "
            + "amount associated with the record";
    private static final String MAN_OPTION_DATE = "-d";
    private static final String MAN_OPTION_DATE_DESCRIPTION = "[ARGUMENT] date associated with the record";
    private static final String MAN_OPTION_DATE_RETURN_DESCRIPTION = "[ARGUMENT] date of loan return";
    private static final String MAN_OPTION_INDEX = "-i";
    private static final String MAN_OPTION_INDEX_DESCRIPTION = "[ARGUMENT] positive non zero integer "
            + "refer to the record ID displayed in list command";
    private static final String MAN_OPTION_PERSON = "-p ";
    private static final String MAN_OPTION_PERSON_DESCRIPTION = "[ARGUMENT] the person name";
    private static final String MAN_OPTION_PERSON_IN_ADD_DESCRIPTION = ", use only with '-l' option";
    private static final String MAN_ARGUMENT_CREDITSCORE_DESCRIPTION = "[ARGUMENT] name of the person "
            + "to check their credit score";
    private static final String MAN_FORMAT_ADD = "add {-e | -l | -s} <description> -a <amount> -d <date>";
    private static final String MAN_FORMAT_LIST = "list {-e | -l | -s | -a}";
    private static final String MAN_FORMAT_VIEW = "view {-e | -l | -s | -a}";
    private static final String MAN_FORMAT_RETURN = "return -i <record_id> -d <return_date>";
    private static final String MAN_FORMAT_REMOVE = "remove -i <record_id>";
    private static final String MAN_FORMAT_CREDITSCORE = "creditscore <person>";
    private static final String MAN_FORMAT_EXIT = "exit";
    private static final String MAN_HEADER_HELP = "see feature details";
    private static final String MAN_FORMAT_HELP = "help <feature>";

    /**
     * Prints the respective help messages based on the command given.
     * @param command contains the command that help is needed to be printed.
     */
    public static void printHelp(String command) {
        switch (command) {
        case "all":
            printManPageAllShort();
            break;
        case "add":
            printManPageAdd();
            break;
        case "list":
            printManPageList();
            break;
        case "view":
            printManPageView();
            break;
        case "remove":
            printManPageRemove();
            break;
        case "return":
            printManPageReturn();
            break;
        case "creditscore":
            printManPageCreditscore();
            break;
        case "exit":
            // Fallthrough
        default:
            printManPageExit();
        }
    }

    /**
     * Prints the man page header format.
     * @param header contains the description of the command.
     */
    public static void printManHeader(String header) {
        System.out.println(Ui.DIVIDER);
        System.out.println("NAME");
        System.out.println(TAB_1SPACE + header);
        System.out.println();
    }

    /**
     * Prints the man page synopsis format.
     * @param synopsis contains the availability options and argument.
     */
    public static void printManSynopsis(String synopsis) {
        System.out.println("SYNOPSIS");
        System.out.println(TAB_1SPACE + synopsis);
        System.out.println();
    }

    /**
     * Prints the entire man page for all commands.
     */
    public static void printManPageAllShort() {
        System.out.println(Ui.DIVIDER);
        System.out.printf("%-15s%-35s%-30s\n", "Command", "Description", "Format");
        System.out.println(Ui.DIVIDER);
        System.out.printf("%-15s%-35s%-30s\n", "add", MAN_HEADER_ADD, MAN_FORMAT_ADD);
        System.out.printf("%-15s%-35s%-30s\n", "list", MAN_HEADER_LIST, MAN_FORMAT_LIST);
        System.out.printf("%-15s%-35s%-30s\n", "view", MAN_HEADER_VIEW, MAN_FORMAT_VIEW);
        System.out.printf("%-15s%-35s%-30s\n", "return", MAN_HEADER_RETURN, MAN_FORMAT_RETURN);
        System.out.printf("%-15s%-35s%-30s\n", "remove", MAN_HEADER_REMOVE, MAN_FORMAT_REMOVE);
        System.out.printf("%-15s%-35s%-30s\n", "creditscore", MAN_HEADER_CREDITSCORE, MAN_FORMAT_CREDITSCORE);
        System.out.printf("%-15s%-35s%-30s\n", "exit", MAN_HEADER_EXIT, MAN_FORMAT_EXIT);
        System.out.printf("%-15s%-35s%-30s\n", "help", MAN_HEADER_HELP, MAN_FORMAT_HELP);
        System.out.println(Ui.DIVIDER);
    }

    /**
     * Prints the man page for add command.
     */
    public static void printManPageAdd() {
        printManHeader("add - " + MAN_HEADER_ADD);
        printManSynopsis(MAN_SYNOPSIS_ADD);
        printManDescriptionAdd();
    }

    /**
     * Prints the add command options and arguments description.
     */
    public static void printManDescriptionAdd() {
        System.out.println("DESCRIPTION");
        System.out.println(TAB_1SPACE + MAN_OPTION_RECORD_TYPE);
        System.out.println(TAB_2SPACE + MAN_OPTION_RECORD_TYPE_DESCRIPTION);
        System.out.println(TAB_1SPACE + MAN_OPTION_AMOUNT);
        System.out.println(TAB_2SPACE + MAN_OPTION_AMOUNT_DESCRIPTION);
        System.out.println(TAB_1SPACE + MAN_OPTION_DATE);
        System.out.println(TAB_2SPACE + MAN_OPTION_DATE_DESCRIPTION);
        System.out.println(TAB_1SPACE + MAN_OPTION_PERSON);
        System.out.println(TAB_2SPACE + MAN_OPTION_PERSON_DESCRIPTION + MAN_OPTION_PERSON_IN_ADD_DESCRIPTION);
        System.out.println(Ui.DIVIDER);
    }

    /**
     * Prints the man page for list command.
     */
    public static void printManPageList() {
        printManHeader("list - " + MAN_HEADER_LIST);
        printManSynopsis(MAN_SYNOPSIS_LIST);
        printManDescriptionList();
    }

    /**
     * Prints the list command options and arguments description.
     */
    public static void printManDescriptionList() {
        System.out.println("DESCRIPTION");
        System.out.println(TAB_1SPACE + MAN_OPTION_RECORD_TYPE_ALL);
        System.out.println((TAB_2SPACE + MAN_OPTION_RECORD_TYPE_LISTING));
        System.out.println(Ui.DIVIDER);
    }

    /**
     * Prints the man page for view command.
     */
    public static void printManPageView() {
        printManHeader("view - " + MAN_HEADER_VIEW);
        printManSynopsis(MAN_SYNOPSIS_VIEW);
        printManDescriptionView();
    }

    /**
     * Prints the view command options and arguments description.
     */
    public static void printManDescriptionView() {
        System.out.println("DESCRIPTION");
        System.out.println(TAB_1SPACE + MAN_OPTION_RECORD_TYPE_ALL);
        System.out.println((TAB_2SPACE + MAN_OPTION_RECORD_TYPE_VIEWING));
        System.out.println(DIVIDER);
    }

    /**
     * Prints the man page for remove command.
     */
    public static void printManPageRemove() {
        printManHeader("remove - " + MAN_HEADER_REMOVE);
        printManSynopsis(MAN_SYNOPSIS_REMOVE);
        printManDescriptionRemove();
    }

    /**
     * Prints the remove command options and arguments description.
     */
    public static void printManDescriptionRemove() {
        System.out.println("DESCRIPTION");
        System.out.println(TAB_1SPACE + MAN_OPTION_INDEX);
        System.out.println((TAB_2SPACE + MAN_OPTION_INDEX_DESCRIPTION));
        System.out.println(DIVIDER);
    }

    /**
     * Prints the man page for return command.
     */
    public static void printManPageReturn() {
        printManHeader("return - " + MAN_HEADER_RETURN);
        printManSynopsis(MAN_SYNOPSIS_RETURN);
        printManDescriptionReturn();
    }

    /**
     * Prints the return command options and arguments description.
     */
    public static void printManDescriptionReturn() {
        System.out.println("DESCRIPTION");
        System.out.println(TAB_1SPACE + MAN_OPTION_INDEX);
        System.out.println((TAB_2SPACE + MAN_OPTION_INDEX_DESCRIPTION));
        System.out.println(TAB_1SPACE + MAN_OPTION_DATE);
        System.out.println(TAB_2SPACE + MAN_OPTION_DATE_RETURN_DESCRIPTION);
        System.out.println(DIVIDER);
    }

    /**
     * Prints the man page for creditscore command.
     */
    public static void printManPageCreditscore() {
        printManHeader("creditscore - " + MAN_HEADER_CREDITSCORE);
        printManSynopsis(MAN_SYNOPSIS_CREDITSCORE);
        printManDescriptionCreditscore();
    }

    /**
     * Prints the creditscore command options arguments description.
     */
    public static void printManDescriptionCreditscore() {
        System.out.println("DESCRIPTION");
        System.out.println(TAB_1SPACE + MAN_ARGUMENT_CREDITSCORE_DESCRIPTION);
        System.out.println(DIVIDER);
    }

    /**
     * Prints the man page for exit command.
     */
    public static void printManPageExit() {
        printManHeader("exit - " + MAN_HEADER_EXIT);
        System.out.println("SYNOPSIS");
        System.out.println(TAB_1SPACE + MAN_SYNOPSIS_EXIT);
        System.out.println(DIVIDER);
    }
}

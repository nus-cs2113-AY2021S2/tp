package seedu.duke.ui;

import static seedu.duke.ui.Ui.DIVIDER;

public class HelpPage {
    private static final String TAB_1SPACE = "\t";
    private static final String TAB_2SPACE = "\t\t";
    private static final String MAN_HEADER_ADD = "add - add a record to the program";
    private static final String MAN_SYNOPSIS_ADD = "add [OPTION] [ARGUMENT]";
    private static final String MAN_HEADER_LIST = "list - list all the records of chosen record type";
    private static final String MAN_SYNOPSIS_LIST = "list [OPTION]";
    private static final String MAN_HEADER_VIEW = "view - view the total amount of chosen record type";
    private static final String MAN_SYNOPSIS_VIEW = "view [OPTION]";
    private static final String MAN_OPTION_RECORD_TYPE = "-e, -l, -s";
    private static final String MAN_OPTION_RECORD_TYPE_DESCRIPTION = "[ARGUMENT] used as record description";
    private static final String MAN_OPTION_RECORD_TYPE_LISTING = "used to list the chosen record types";
    private static final String MAN_OPTION_RECORD_TYPE_VIEWING = "used to view total amount of choose record type";
    private static final String MAN_OPTION_AMOUNT = "-a";
    private static final String MAN_OPTION_AMOUNT_DESCRIPTION = "[ARGUMENT] positive non zero numeric "
            + "amount associated with the record";
    private static final String MAN_OPTION_DATE = "-d";
    private static final String MAN_OPTION_DATE_DESCRIPTION = "[ARGUMENT] date associated with the record";
    private static final String MAN_NO_ARGUMENT = "arguments are not needed";

    public static void printHelp(String command) {
        switch (command) {
        case "help":
            printManPageMaster();
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
        case "exit":
            printManPageExit();
            break;
        default:
        }
    }

    public static void printManHeader(String header) {
        System.out.println("NAME");
        System.out.println(TAB_1SPACE + header);
        System.out.println();
    }

    public static void printManSynopsis(String synopsis) {
        System.out.println("SYNOPSIS");
        System.out.println(TAB_1SPACE + synopsis);
        System.out.println();
    }

    public static void printManPageMaster() {
        printManPageAdd();
        printManPageView();
        printManPageList();
        printManPageRemove();
        printManPageReturn();
        printManPageExit();
    }

    public static void printManPageAdd() {
        printManHeader(MAN_HEADER_ADD);
        printManSynopsis(MAN_SYNOPSIS_ADD);
        printManDescriptionAdd();
    }

    public static void printManDescriptionAdd() {
        System.out.println("DESCRIPTION");
        System.out.println(TAB_1SPACE + MAN_OPTION_RECORD_TYPE);
        System.out.println(TAB_2SPACE + MAN_OPTION_RECORD_TYPE_DESCRIPTION);
        System.out.println(TAB_1SPACE + MAN_OPTION_AMOUNT);
        System.out.println(TAB_2SPACE + MAN_OPTION_AMOUNT_DESCRIPTION);
        System.out.println(TAB_1SPACE + MAN_OPTION_DATE);
        System.out.println(TAB_2SPACE + MAN_OPTION_DATE_DESCRIPTION);
        System.out.println(Ui.DIVIDER);
    }

    public static void printManPageList() {
        printManHeader(MAN_HEADER_LIST);
        printManSynopsis(MAN_SYNOPSIS_LIST);
        printManDescriptionList();
    }

    public static void printManDescriptionList() {
        System.out.println("DESCRIPTION");
        System.out.println(TAB_1SPACE + MAN_OPTION_RECORD_TYPE);
        System.out.println((TAB_2SPACE + MAN_OPTION_RECORD_TYPE_LISTING));
        System.out.println(Ui.DIVIDER);
    }

    public static void printManPageView() {
        printManHeader(MAN_HEADER_VIEW);
        printManSynopsis(MAN_SYNOPSIS_VIEW);
        printManDescriptionView();
    }

    public static void printManDescriptionView() {
        System.out.println("DESCRIPTION");
        System.out.println(TAB_1SPACE + MAN_OPTION_RECORD_TYPE);
        System.out.println((TAB_2SPACE + MAN_OPTION_RECORD_TYPE_VIEWING));
        System.out.println(DIVIDER);
    }

    public static void printManPageRemove() {
        printManDescriptionRemove();
    }

    public static void printManDescriptionRemove() {
        System.out.println("DESCRIPTION");
        System.out.println(DIVIDER);
    }

    public static void printManPageReturn() {
        printManDescriptionReturn();
    }

    public static void printManDescriptionReturn() {
        System.out.println("DESCRIPTION");
        System.out.println(DIVIDER);
    }

    public static void printManPageExit() {
        System.out.println("SYNOPSIS");
        System.out.println(DIVIDER);
    }
}

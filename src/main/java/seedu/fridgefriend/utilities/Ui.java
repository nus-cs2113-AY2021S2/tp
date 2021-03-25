package seedu.fridgefriend.utilities;

import java.util.Scanner;

/**
 * Represents an object that deals with interactions with the user.
 */
public class Ui {
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Retrieves the next line of input provided by the user.
     * 
     * @return string of next input
     */
    public static String getNextLine() {
        String line = scanner.nextLine();    
        return line;
    }
    
    /**
     * Prints to user a message with an added border below it.
     * 
     * @param message message to be printed
     */
    public static void printMessage(String message) {
        System.out.println(message);
        System.out.println("-----------------------------------------------------------------");
    }

    public static void printWelcomeMessage() {
        String logo =
                "  ______    _     _            ______    _                _ \n"
                + " |  ____|  (_)   | |          |  ____|  (_)              | |\n"
                + " | |__ _ __ _  __| | __ _  ___| |__ _ __ _  ___ _ __   __| |\n"
                + " |  __| '__| |/ _` |/ _` |/ _ \\  __| '__| |/ _ \\ '_ \\ / _` |\n"
                + " | |  | |  | | (_| | (_| |  __/ |  | |  | |  __/ | | | (_| |\n"
                + " |_|  |_|  |_|\\__,_|\\__, |\\___|_|  |_|  |_|\\___|_| |_|\\__,_|\n"
                + "                     __/ |\n"
                + "                    |___/\n\n";
        String welcomeMessage = "Hello! I'm FridgeFriend!\n" + "What can I do for you?";
        printMessage(logo + welcomeMessage);
    }

    public static void printByeMessage() {
        String byeMessage = "Bye! Hope to see you again soon!";
        printMessage(byeMessage);
    }

    public static void printExceptionMessage(Exception exception) {
        String exceptionMessage = exception.getMessage();
        printMessage(exceptionMessage);
    }
    
}

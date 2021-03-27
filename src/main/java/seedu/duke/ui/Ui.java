package seedu.duke.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class Ui {
    private final PrintStream out = System.out;
    private final InputStream input = System.in;
    private final Scanner in = new Scanner(input);

    public final String lineSeparator = System.lineSeparator();
    public final String divider = "--------------------------------------------------------------------------";
    public final String spacing = "      ";
    public final String commandInputHeader = "> ";
    public final String inputHeader = "* ";
    public final String logo =  " /$$   /$$ /$$   /$$  /$$$$$$  /$$      /$$\n"
            + "| $$$ | $$| $$  | $$ /$$__  $$| $$$    /$$$\n"
            + "| $$$$| $$| $$  | $$| $$  \\__/| $$$$  /$$$$  /$$$$$$  /$$$$$$$$  /$$$$$$\n"
            + "| $$ $$ $$| $$  | $$|  $$$$$$ | $$ $$/$$ $$ |____  $$|____ /$$/ /$$__  $$\n"
            + "| $$  $$$$| $$  | $$ \\____  $$| $$  $$$| $$  /$$$$$$$   /$$$$/ | $$$$$$$$\n"
            + "| $$\\  $$$| $$  | $$ /$$  \\ $$| $$\\  $ | $$ /$$__  $$  /$$__/  | $$_____/\n"
            + "| $$ \\  $$|  $$$$$$/|  $$$$$$/| $$ \\/  | $$|  $$$$$$$ /$$$$$$$$|  $$$$$$$\n"
            + "|__/  \\__/ \\______/  \\______/ |__/     |__/ \\_______/|________/ \\_______/";
    public final String greetingMessage = "Hello! Welcome to NUSMaze" + lineSeparator
            + "Where do you want to go today?";
    public final String byeMessage = "Bye. Hope to see you again soon!";
    public final String helpMessage = "1. go:\n"
            + spacing + "finds the route to go from one block to another\n"
            + "2. history:\n"
            + spacing + "lists past 10 route searches\n"
            + "3. add note LOCATION/DESCRIPTION:\n"
            + spacing + "adds and tags a note to a particular location\n"
            + "4. list notes LOCATION:\n"
            + spacing + "list notes tagged to the given location\n"
            + "5. delete note LOCATION/NOTE INDEX:\n"
            + spacing + "deletes notes based on index number tagged to the given location";

    public String getUserCommandInput() {
        out.print(commandInputHeader);
        String userInput = in.nextLine();
        out.println(divider);
        return userInput;
    }

    public String getUserInput() {
        out.print(inputHeader);
        return in.nextLine();
    }

    public void showToUser(String... message) {
        assert message != null : "Message cannot be null";

        for (String m : message) {
            out.println(m);
        }
    }
}

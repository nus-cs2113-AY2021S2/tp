//@@author Rizavur

package seedu.duke.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * TextUi of the application.
 */
public class UiManager {
    private final Scanner in;
    private final PrintStream out;

    public UiManager() {
        this(System.in, System.out);
    }

    public UiManager(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    /** Returns the full command input by the user. */
    public String getUserCommandInput() {
        out.print(CommonMessage.COMMAND_INPUT_HEADER);
        String userInput = in.nextLine();
        out.println(CommonMessage.DIVIDER);
        return userInput;
    }

    /** Returns parameter inputs given by user. */
    public String getUserInput() {
        out.print(CommonMessage.INFO_INPUT_HEADER);
        return in.nextLine().trim();
    }

    /** Prints the messages that is to be delivered to the user. */
    public void showMessage(String... message) {
        for (String m : message) {
            out.println(m);
        }
    }

    /** Prints the messages that is to be delivered to the user with line divider below it. */
    public void showMessageWithDivider(String... message) {
        showMessage(message);
        out.println(CommonMessage.DIVIDER);
    }

    /** Prints the logo of the NusMaze. */
    public void showLogo() {
        showMessageWithDivider(CommonMessage.DIVIDER, CommonMessage.LOGO);
    }

    /** Prints the greeting message. */
    public void showGreetMessage() {
        showMessageWithDivider(CommonMessage.GREETING_MESSAGE);
    }

    /** Prints out a message informing the user that previous data has been successfully loaded. */
    public void showLoadSuccessMessage(String name) {
        showMessage(String.format(CommonMessage.SUCCESSFUL_LOAD, name));
    }
}

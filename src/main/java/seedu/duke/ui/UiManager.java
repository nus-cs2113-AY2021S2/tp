package seedu.duke.ui;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

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

    public String getUserCommandInput() {
        out.print(CommonMessage.COMMAND_INPUT_HEADER);
        String userInput = in.nextLine();
        out.println(CommonMessage.DIVIDER);
        return userInput;
    }

    public String getUserInput() {
        out.print(CommonMessage.INFO_INPUT_HEADER);
        return in.nextLine().trim();
    }


    public void showMessage(String... message) {
        for (String m : message) {
            out.println(m);
        }
    }

    public void showMessageWithDivider(String... message) {
        showMessage(message);
        out.println(CommonMessage.DIVIDER);
    }

    public void showLogo() {
        showMessageWithDivider(CommonMessage.LOGO);
    }

    public void showGreetMessage() {
        showMessageWithDivider(CommonMessage.GREETING_MESSAGE);
    }
}

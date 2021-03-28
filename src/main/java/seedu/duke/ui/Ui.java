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
    public final String commandInputHeader = "> ";
    public final String inputHeader = "* ";

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

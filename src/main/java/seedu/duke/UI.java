package seedu.duke;

import java.util.Scanner;
//@@chenling
public class UI {

    public UI() {
    }

    protected static String getString(Scanner in) {
        String userInput;
        userInput = in.nextLine();
        return userInput;
    }


}

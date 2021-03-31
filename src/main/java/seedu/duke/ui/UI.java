package seedu.duke.ui;

import seedu.duke.account.FitCenter;
import seedu.duke.account.User;
import seedu.duke.command.CommandResult;
import seedu.duke.common.Messages;
import seedu.duke.goal.Goal;

import java.util.Scanner;

import static seedu.duke.command.CommandRecordType.DIET;

public class UI {

    public static final String DIVIDER = "--------------------------------------------------------------------\n";
    public static final String DIVIDER_LINE_ONLY =
            "--------------------------------------------------------------------";
    private final Scanner sc;

    public UI() {
        sc = new Scanner(System.in);
    }

    public String getUserInput() {
        return sc.nextLine();
    }

    public void printGreetings() {
        System.out.print(DIVIDER
                + Messages.MESSAGE_WELCOME
                + DIVIDER);
    }

    public void printExitMessage() {
        System.out.print(DIVIDER
                + Messages.MESSAGE_BYE
                + DIVIDER);
    }

    public void printCommandResult(CommandResult commandResult) {
        System.out.println(DIVIDER
                + commandResult.getFeedback()
                + "\n"
                + DIVIDER_LINE_ONLY);
    }

    public void showFileErrorMessage() {
        System.out.println("The source file can't be accessed, please check your access settings.");
    }

    public static void printMessage(String message) {
        System.out.println(DIVIDER
                + message
                + "\n"
                + DIVIDER_LINE_ONLY);
      
    public void showFileParserErrorMessage() {
        System.out.println("The file contains invalid content that can't be recognized, please fix it\n"
                + "You can try to delete everything in the file but you will lose the information you had.");
    }

    public void showProgress(User user) {
        FitCenter fitCenter = user.getFitCenter();
        System.out.println(fitCenter.getAllGoalListStringAtLoading() + DIVIDER_LINE_ONLY);
    }
}

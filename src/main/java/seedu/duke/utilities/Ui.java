package seedu.duke.utilities;

import seedu.duke.email.Email;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Ui {
    private final Scanner in;
    private final PrintStream out;
    private static final String errorLine = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
    protected static final String logo = " _________   _____   _____   _____\n"
            + "|  _   _  | |  _  | |_   _| |  _  |\n"
            + "| | | | | | | | | |   | |   | | | |\n"
            + "| | | | | | | |_| |  _| |   | |_| |\n"
            + "|_| |_| |_| |_____| |___|   |_____|\n";

    private static final String oldPassword = "Please enter your old password:";
    private static final String newPassword = "Please enter your new password:";

    public void printPwdRequest() {
        printDivider();
        System.out.println("Please be careful!\n"
                + "     * Password should not contain any space.\n"
                + "     * Password should contain at least one digit(0-9).\n"
                + "     * Password length should be between 8 to 15 characters.\n"
                + "     * Password should contain at least one lowercase letter(a-z).\n"
                + "     * Password should contain at least one uppercase letter(A-Z).\n"
                + "     * Password should contain at least one special character ( @, #, %, &, !, $, etc….).");
    }

    public Ui() {
        this(System.in, System.out);
    }

    public Ui(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    public String getUserInput() {
        printDivider();
        System.out.println("Enter Command:");
        String inputLine = in.nextLine();
        while (inputLine.trim().isEmpty()) {
            inputLine = in.nextLine();
        }
        printDivider();
        return inputLine;
    }

    public String getResetPsw(String type) {
        if (type.equals("new")) {
            printPwdRequest();
            System.out.println(newPassword);
        }

        if (type.equals("old")) {
            System.out.println(oldPassword);
        }
        String inputLine = in.nextLine();
        while (inputLine.trim().isEmpty()) {
            inputLine = in.nextLine();
        }
        return inputLine;
    }

    public void printComposeUI() {
        System.out.println("Please enter the details below in the correct order:");
        System.out.println("To:");
        System.out.println("Subject:");
        System.out.println("Content:");
        System.out.println("You can send to multiple recipents by appending email address with \";\"");
        System.out.println("e.g: Alice@gmail.com;Bob@gmail.com");
        System.out.println("You should end content by typing \"/end\" in a newline");
        printDivider();
    }

    public void printEditEmail() {
        System.out.println("What would you like to edit? It must be one of [to, subject, content].");
    }

    public void printDivider() {
        System.out.println("____________________________________________________________");
    }

    public void printEmailDrafted(Email email) {
        printDivider();
        System.out.println("Email saved to draft " + "at " + email.getTime());
    }

    public void printEmailSent(Email email) {
        System.out.println("Email successfully sent to: " + email.getTo() + " at " + email.getTime());
    }

    public void printEmailsSorted(String sortType) {
        System.out.println("Emails are sorted according to " + sortType);
    }

    public void printEmailEditedMessage(String editType) {
        System.out.println("Email \"" + editType + "\" successfully edited.");
    }

    public void printFeedback(String feedback) {
        System.out.println(feedback);
        printDivider();
    }

    public void printMenu() {
        System.out.println("Hello! I'm MojoHR\n" + logo + "What can I do for you?");
        System.out.println("> Use the keyword \"LIST (type) \" to print the emails by types\n"
                + "!!! type must be one of: [allemails, inbox, archive, deleted, draft, junk, sent] !!!");
        System.out.println("> Use the keyword \"READ (index) \" to open the selected email");
        System.out.println("> Use the keyword \"COMPOSE \" to create a draft email");
        System.out.println("> Use the keyword \"EDIT (index) \" to edit email in the draft folder");
        System.out.println("> Use the keyword \"SEND (index/ multiple indices) \" "
                + "to send email(s) in the draft folder\n"
                + "!!! indices should be separated with a space !!!");
        System.out.println("> Use the keyword \"DELETE (index) \" to delete the selected email");
        System.out.println("> Use the keyword \"FIND (keyword) \" to find the  email by keywords");
        System.out.println("> Use the keyword \"ARCHIVE (index) \" to move the selected email to the archive folder");
        System.out.println("> Use the keyword \"TAG (index) (tag1) (tag2)...\" to select the email for tagging labels");
        System.out.println("> Use the keyword \"NUMBER (type)\" to count the emails by types\n"
                + "!!! type must be one of: [allemails, inbox, archive, deleted, draft, junk, sent] !!!");
        System.out.println("> Use the keyword \"SORT (type) \" to sort all emails by types\n"
                + "!!! type must be one of: [time, sender] !!!");
        System.out.println("> Use the keyword \"RESET\" to reset the your account password");
        System.out.println("> Use the keyword \"HELP\" to print the menu");
        System.out.println("> Use the keyword \"BYE\" to exit");
    }

    public void printNumberOfEmails(int totalEmails, String emailType) {
        if (emailType.equals("allemails")) {
            System.out.println("You have a total of " + totalEmails + " emails");
        } else {
            System.out.println("You have a total of " + totalEmails + " " + emailType.toUpperCase() + " emails");
        }
    }

    public static void showInvalidIdMessage(String type) {
        System.out.println("OOPS!!! The Email ID that you " + type + " is invalid.");
    }

    public void showInvalidCommandInputMessage() {
        System.out.println("OOPS!!! I'm sorry, but I don't know what that means :-(!");
    }

    public static void showInvalidListTypeMessage() {
        System.out.println("OOPS!!! The Email type that you enter is invalid.");
        System.out.println("It must be one of: [allemails, inbox, archive, deleted, draft, junk, sent]");
    }

    public static void showMessageForInvalidSortTypeInput() {
        System.out.println("OOPS!!! The type that you enter is invalid.");
        System.out.println("It must be one of: [sender, time]");
    }

    public static void showMessageForInvalidEditTypeInput() {
        System.out.println("OOPS!!! The type that you enter is invalid.");
        System.out.println("It must be one of: [to, subject, content]");
    }

    public static void showMessageForEmptySortType() {
        System.out.println("OOPS!!! The sort type is empty.");
        System.out.println("Please enter one of: [sender, time] after \"sort\".");
    }

    public static void printErrorMessage(String... messages) {
        System.out.println(errorLine);
        System.out.println("Error Message: ");
        for (String message : messages) {
            System.out.println(message);
        }
        System.out.println(errorLine);
    }

    public void printGoodBye() {
        System.out.println("Logging off... Hope to see you again in MojoHr!");
    }

    public static void showMissingInputMessage() {
        System.out.println("Draft not saved due to missing line");
    }

    public static void showMissingSubjectWarning() {
        System.out.println("Warning: No subject detected");
    }

    public static void showMissingContentWarning() {
        System.out.println("Warning: No content detected");
    }

    public static void showInvalidEmailAddressWarning() {
        System.out.println("Warning: Incomplete email address or invalid email domain.");
        System.out.println("Supported Email domains are: [gmail.com, yahoo.com, outlook.com, hotmail.com]");
    }
}

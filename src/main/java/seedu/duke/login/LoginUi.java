package seedu.duke.login;

import seedu.duke.exceptions.InvalidPasswordException;
import seedu.duke.utilities.Parser;
import seedu.duke.utilities.Ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import static seedu.duke.utilities.Parser.loginCheckEmailsValidity;

/**
 * This class is responsible for the logic of getting input and output from the user for their login information.
 */
public class LoginUi extends Ui {

    /**
     * Get userInput for new accounts, ensures the emails and password matches format required.
     * @return LoginInfo provided by user
     */
    public LoginInfo getNewUserLoginInfo() {
        Boolean loginMatch;
        LoginInfo loginInfo;
        while (true) {
            try {
                loginInfo = getUserInputForLogin();
                loginMatch = loginCheckEmailsValidity(loginInfo.getUserId());
                Parser.isValid(loginInfo.getPassword());
                if (loginMatch == false) {
                    continue;
                }
                break;
            } catch (InvalidPasswordException e) {
                System.out.print(e.getMessage());
                System.out.println(e.printMessage());
            }
        }
        return loginInfo;
    }

    /**
     * Gets the user choice on whether they will like to log in, register or exit application.
     *
     * @return login information
     */
    public LoginInfo getLoginInfo() {
        LoginController loginController = new LoginController();
        LoginInfo loginInfo = null;
        printLoginMenu();
        Scanner sc = new Scanner(System.in);
        try {
            int choice = sc.nextInt();
            switch (choice) {
            case 1:
                loginInfo = getUserInputForLogin();
                break;
            case 2:
                loginInfo = loginController.addUser();
                break;
            case 3:
                printGoodBye();
                System.exit(0);
                break;
            default:
                printErrorMessage("You need to enter an integer that is either 1, 2 or 3! Please try again!");
                getLoginInfo();
                break;
            }
        } catch (InputMismatchException e) {
            printErrorMessage("You need to enter an integer that is either 1, 2 or 3! Please try again!");
            loginInfo = getLoginInfo();
        }
        assert loginInfo != null : "loginInfo is still null ";
        return loginInfo;
    }

    /**
     * Prints the Login Menu.
     */
    public void printLoginMenu() {
        System.out.println(super.logo);
        System.out.println("Select either 1 or 2 or 3 (use numbers):\n"
                + "[Emails address are case sensitive!]\n"
                + "1. Log In\n"
                + "2. Create a new account\n"
                + "3. Exit");
        System.out.println("Enter choice:");
    }

    /**
     * Gets userInput for various purpose such a registering an email account and password.
     *
     * @return new LoginInfo Object contains email address and password
     */
    public LoginInfo getUserInputForLogin() {
        Scanner sc = new Scanner(System.in);
        String userId;
        System.out.println("Enter email address:");
        userId = sc.nextLine();
        System.out.println("Enter password:");
        String password = sc.nextLine();
        return new LoginInfo(userId, password);
    }
}

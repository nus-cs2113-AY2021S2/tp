package seedu.duke.login;

import seedu.duke.exceptions.WrongLoginInfoException;

import java.util.Scanner;

/**
 * This class is responsible for the login process.
 */
public class LoginController {
    /**
     * Provides login to verify login details provided by the user.
     *
     * @see LoginManager
     */
    private LoginManager loginManager;
    /**
     * A loginUi object responsible for handling input/output to the user.
     *
     * @see LoginUi
     */
    private LoginUi loginUi;
    /**
     * A Login info object responsible for storing the details of the user such as password and email address.
     */
    private LoginInfo loginInfo;

    /**
     * An object that handles database(LoginInfo.txt) for the LoginInfo provided by the users.
     */
    private LoginInfoFileManager loginInfoFileManager;

    /**
     * Creates a new LoginController Object that instantiates the LoginManager, LoginUi and LoginInfoFileManager object.
     */
    public LoginController() {
        loginManager = new LoginManager();
        loginUi = new LoginUi();
        loginInfoFileManager = new LoginInfoFileManager();
    }

    /**
     * runs the login controller by getting information from the user and verifying with our database,
     * verifies the login information and returns the login information
     * only if the user provided a correct login information.
     *
     * @return A LoginInfo object containing the email address and password that has been verified to be correct
     */
    public LoginInfo run() {
        LoginInfo providedLoginInfo;
        providedLoginInfo = loginUi.getLoginInfo();
        while (true) {
            try {
                loginManager.verifyLoginInfo(providedLoginInfo);
                break;
            } catch (NullPointerException | WrongLoginInfoException e) {
                loginUi.printErrorMessage(e.getMessage());
                providedLoginInfo = loginUi.getLoginInfo();
            }
        }
        return providedLoginInfo;
    }


    public void modifyLoginInfo(String emailAccount, String newPwd) {
        LoginInfo loginInfo = new LoginInfo(emailAccount, newPwd);
        loginManager.modifyLoginInfo(loginInfo);
    }

    /**
     * Gets the necessary information needed to create a new account and adds the new user.
     *
     * @return login info provided by the user
     */
    public LoginInfo addUser() {
        LoginInfo loginInfo;
        loginInfo = loginUi.getNewUserLoginInfo();
        if (checkUserIdExists(loginInfo.getUserId())) {
            loginUi.printErrorMessage("You already have an account. Please log in instead!");
            loginUi.getLoginInfo();
        }
        loginInfoFileManager.addLoginInfoForNewUser(loginInfo);
        return loginInfo;
    }

    /**
     * Checks if email address already exists for an existing account.
     *
     * @param userId The email address of the new user to be added
     * @return true if the email address of the new user to be added doesn't yet exist; false otherwise
     */
    public boolean checkUserIdExists(String userId) {
        for (LoginInfo loginInfo : loginInfoFileManager.retrieveLoginInfoList()) {
            if (loginInfo.getUserId().equals(userId)) {
                return true;
            }
        }
        return false;
    }
}

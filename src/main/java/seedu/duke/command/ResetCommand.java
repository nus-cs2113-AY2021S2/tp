package seedu.duke.command;

import seedu.duke.email.EmailManager;
import seedu.duke.exceptions.InvalidPasswordException;
import seedu.duke.login.LoginController;
import seedu.duke.utilities.Parser;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;

public class ResetCommand extends Command {
    public ResetCommand(String s) {
        super(s);
    }

    public void execute(EmailManager emails, Ui ui, Storage storage) {
        int n = 3;
        boolean isMatchPwd = false;
        while (n > 0) {
            String userInputPwd = ui.getResetPsw("old");
            String oldPwd = storage.getPwd();
            // if the old password is correct
            if (userInputPwd.trim().equals(oldPwd.trim())) {
                isMatchPwd = true;
                while (true) {
                    try {
                        String newPwd = ui.getResetPsw("new").trim();
                        if (newPwd.equals(oldPwd.trim())) {
                            throw new InvalidPasswordException(7);
                        }
                        Parser.isValid(newPwd);
                        // change password in user's json file
                        storage.changePwd(newPwd);
                        // update the LoginInfo in the text file
                        LoginController loginController = new LoginController();
                        loginController.modifyLoginInfo(storage.getEmailAccount(), newPwd);
                        System.out.println("Your password has changed successfully!");
                        break;
                    } catch (InvalidPasswordException e) {
                        System.out.print(e.getMessage());
                        System.out.println(e.printMessage());
                    }
                }
            }
            if (!isMatchPwd) {
                n--;
                if (n == 0) {
                    System.out.println("Sorry your old password is wrong for 3 times. Go back to the main page.");
                } else {
                    System.out.println("Sorry your old password is wrong. Please try again!(" + n + " times left!)");
                }
                ui.printDivider();
            } else {
                break;
            }
        }
    }
}

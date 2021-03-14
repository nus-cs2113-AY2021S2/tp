package admin;

import exceptions.DukeExceptions;
import ui.Ui;

public class AdminVerification {

    private static String actualPassword = "Password";
    private static Ui ui = new Ui();
    private static boolean isVerified = false;
    private static String inputPassword = null;

    public static void verifyInputPassword() {
        while (!isVerified) {
            try {
                inputPassword = ui.readCommand();
                if (!(inputPassword.equals(actualPassword))) {
                    throw new DukeExceptions("Wrong Password!");
                }
            } catch (DukeExceptions e) {
                ui.showError(e.getMessage());
                ui.adminPasswordReenter();
            }
            if (inputPassword.equals(actualPassword)) {
                isVerified = true;
            }
        }
    }
}
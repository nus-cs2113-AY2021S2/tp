package checkuser;

import exceptions.DukeExceptions;
import ui.Ui;

public class CheckUser {

    private boolean isPublicUser = false;
    private boolean isAdmin = false;
    private boolean isVerified = false;
    private static Ui ui = new Ui();

    public static boolean checkUserType(boolean isPublicUser) {
        while (true) {
            try {
                String input = Ui.readCommand();
                if (!(input.equals("1") | input.equals("2") | input.equals("exit"))) {
                    throw new DukeExceptions("Wrong input, enter either 1 or 2.");
                }
                if (input.equals("1")) {
                    return true;
                } else if (input.equals("2")) {
                    return false;
                } else {
                    ui.showGoodbye();
                    System.exit(0);
                }
            } catch (DukeExceptions e) {
                ui.showError(e.getMessage());
            }
        }
    }
}

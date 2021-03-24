package checkuser;

import ui.Ui;

public class CheckUser {

    private boolean isPublicUser = false;
    private boolean isAdmin = false;
    private boolean isVerified = false;

    public static boolean checkUserType(Ui ui) {
        while (true) {
            String input = Ui.readCommand();
            if (input.equals("1")) {
                return true;
            } else if (input.equals("2")) {
                return false;
            } else if (input.equals("exit")) {
                ui.showGoodbye();
                System.exit(0);
            } else {
                ui.showError("Wrong input, enter either 1 or 2.");
            }
        }
    }
}

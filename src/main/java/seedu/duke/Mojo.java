package seedu.duke;

import org.json.simple.parser.ParseException;
import seedu.duke.email.EmailManager;
import seedu.duke.login.LoginController;
import seedu.duke.login.LoginInfo;
import seedu.duke.utilities.Parser;
import seedu.duke.utilities.Storage;
import seedu.duke.utilities.Ui;

import java.io.IOException;

public class Mojo {
    /**
     * Main entry-point for the java.duke.Duke application.
     */
    private static Ui ui;
    private static EmailManager emails;
    private static Parser parser;
    private static Storage storage;

    public Mojo(String filePath, LoginInfo providedLoginInfo) throws NullPointerException {
        ui = new Ui();
        try {
            emails = new EmailManager(storage.load(filePath, providedLoginInfo.getUserId(),
                    providedLoginInfo.getPassword()));
        } catch (IOException e) {
            emails = new EmailManager();
            e.printStackTrace();
        } catch (ParseException e) {
            emails = new EmailManager();
            e.printStackTrace();
        }
        parser = new Parser();
    }

    public void run() {
        ui.printMenu();
        while (true) {
            String userCommand = ui.getUserInput();
            try {
                parser.parse(userCommand.trim());
                parser.getCmd().execute(emails, ui, storage);
            } catch (AssertionError e) {
                ui.showInvalidCommandInputMessage();
            }
        }
    }

    public static void main(String[] args) {
        storage = new Storage();
        storage.init();

        LoginController lc = new LoginController();
        LoginInfo providedLoginInfo = lc.run();
        String userId = providedLoginInfo.getUserId();

        try {
            new Mojo(userId + ".json", providedLoginInfo).run();
        } catch (NullPointerException e) {
            System.out.println("The form of your emails in json file is incorrect! Please check your json file.");
        }
    }
}



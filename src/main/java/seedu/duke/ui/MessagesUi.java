package seedu.duke.ui;

public class MessagesUi extends Ui {

    public MessagesUi() {
    }

    public void showLogo() {
        showToUser(divider, logo, divider);
    }

    public void showGreetMessage() {
        showToUser(greetingMessage, divider);
    }

    public void showByeMessage() {
        showToUser(byeMessage, divider);
    }

    public void showHelpMessage() {
        showToUser(helpMessage, divider);
    }
}

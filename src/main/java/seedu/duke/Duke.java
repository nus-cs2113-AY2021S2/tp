package seedu.duke;

public class Duke {
    public static void main(String[] args) {
        UiManager.showLogo();
        UiManager.showGreetMessage();

        InputManager inputManager = new InputManager();
        inputManager.inputLoop();
    }
}

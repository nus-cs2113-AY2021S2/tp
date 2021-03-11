package seedu.duke;

public class NusMaze {
    public static void main(String[] args) {
        UiManager.showLogo();
        UiManager.showGreetMessage();

        InputManager inputManager = new InputManager();
        inputManager.inputLoop();
    }
}

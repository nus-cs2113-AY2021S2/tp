package seedu.logic.instance;

import seedu.logic.command.Command;
import seedu.logic.command.NurseScheduleActions;
import seedu.logic.parser.NurseSchedulesParser;
import seedu.storage.NurseScheduleStorage;
import seedu.ui.NurseScheduleUI;

/**
 * Main entry-point for the NurseSchedules instance.
 */
public class NurseScheduleInstance {

    private NurseSchedulesParser parser;
    private NurseScheduleActions nurseSchedules;
    private NurseScheduleStorage storage;
    private NurseScheduleUI ui;

    /** Runs the program until termination. */
    public void run() {
        init();
        runCommandLoopUntilExit();
    }

    private void init() {
        this.parser = new NurseSchedulesParser();
        this.nurseSchedules = new NurseScheduleActions(storage.load());
        this.storage = new NurseScheduleStorage();
        this.ui = new NurseScheduleUI();

        ui.printNurseScheduleWelcomeMessage();
    }

    /** Reads the user command and executes it, until the user issues the exit command. */
    private void runCommandLoopUntilExit() {
        boolean isReturnToStartMenu = false;
        while (!isReturnToStartMenu) {
            ui.nurseSchedulePrompt();
            String line = parser.getUserInput().trim();
            Command c = parser.nurseParse(line, ui);
            c.execute(nurseSchedules, ui);
            storage.writeToFile(nurseSchedules);
            isReturnToStartMenu = c.isExit();
        }
    }
}

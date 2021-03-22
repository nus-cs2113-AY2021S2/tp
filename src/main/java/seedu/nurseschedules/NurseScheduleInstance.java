package seedu.nurseschedules;

import seedu.duke.exceptions.nurseschedules.WrongInputsException;
import seedu.duke.storage.NurseScheduleStorage;
import seedu.duke.menuparser.NurseSchedulesParser;
import seedu.duke.ui.NurseScheduleUI;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class NurseScheduleInstance {

    private NurseSchedulesParser parser;
    private NurseScheduleActions actions;
    private NurseScheduleStorage storage;

    List<NurseSchedule> nurseSchedules = new ArrayList<NurseSchedule>();

    /**
     * Main entry-point for the java.duke.Duke application.
     */
    public static void main() {
        new NurseScheduleInstance().run();
    }

    public void run() {
        start();
        runCommandLoopUntilExit();
    }

    private void start() {
        this.parser = new NurseSchedulesParser();
        this.actions = new NurseScheduleActions();
        this.storage = new NurseScheduleStorage();

        storage.load(nurseSchedules);

        NurseScheduleUI.printNurseScheduleWelcomeMessage();
    }

    private void runCommandLoopUntilExit() {
        boolean isRun = true;
        while (isRun) {
            NurseScheduleUI.nurseSchedulePrompt();
            String line = parser.getUserInput().trim();
            String command = parser.getFirstWord(line);

            switch (command) {
            case "add":
                try {
                    String[] details = parser.getDetails(line);
                    NurseScheduleUI.printAddedSchedule(details[1], parser.formatDate(line));
                    nurseSchedules.add(new NurseSchedule(details[0], details[1], details[2]));
                    storage.writeToFile(nurseSchedules);
                } catch (ParseException | WrongInputsException e) {
                    NurseScheduleUI.invalidInputsMessage();
                    NurseScheduleUI.addHelpMessage();
                }
                break;
            case "list":
                try {
                    actions.listSchedules(nurseSchedules, parser.getDetails(line));
                } catch (WrongInputsException e) {
                    NurseScheduleUI.invalidInputsMessage();
                    NurseScheduleUI.listHelpMessage();
                }
                break;
            case "delete":
                try {
                    actions.deleteSchedule(nurseSchedules, parser.getDetails(line));
                    storage.writeToFile(nurseSchedules);
                } catch (WrongInputsException e) {
                    NurseScheduleUI.invalidInputsMessage();
                    NurseScheduleUI.deleteHelpMessage();
                }
                break;
            case "help":
                NurseScheduleUI.printNurseScheduleHelpList();
                break;
            case "return":
                storage.writeToFile(nurseSchedules);
                NurseScheduleUI.returnToStart();
                isRun = false;
                break;
            default:
                NurseScheduleUI.invalidCommandMessage();
                break;
            }
        }
    }
}

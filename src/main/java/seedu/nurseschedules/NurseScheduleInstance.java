package seedu.nurseschedules;

import seedu.duke.exceptions.nurseschedules.WrongInputsException;
import seedu.duke.storage.NurseScheduleStorage;
import seedu.nurseschedules.parser.Parser;
import seedu.duke.ui.NurseScheduleUI;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class NurseScheduleInstance {

    private Parser parser;
    private NurseScheduleActions actions;
    private NurseScheduleStorage storage;
    private NurseScheduleUI ui;

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
        this.parser = new Parser();
        this.actions = new NurseScheduleActions();
        this.storage = new NurseScheduleStorage();
        this.ui = new NurseScheduleUI();

        storage.load(nurseSchedules);

        ui.printNurseScheduleWelcomeMessage();
    }

    private void runCommandLoopUntilExit() {
        boolean isRun = true;
        while (isRun) {
            ui.nurseSchedulePrompt();
            String line = parser.getUserInput().trim();
            String command = parser.getFirstWord(line);

            switch (command) {
            case "add":
                try {
                    String[] details = parser.getDetails(line);
                    ui.printAddedSchedule(details[1], parser.formatDate(line));
                    nurseSchedules.add(new NurseSchedule(details[0], details[1], details[2]));
                    storage.writeToFile(nurseSchedules);
                } catch (ParseException | WrongInputsException e) {
                    ui.invalidInputsMessage();
                    ui.addHelpMessage();
                }
                break;
            case "list":
                try {
                    actions.listSchedules(nurseSchedules, parser.getDetails(line));
                } catch (WrongInputsException e) {
                    ui.invalidInputsMessage();
                    ui.listHelpMessage();
                }
                break;
            case "delete":
                try {
                    actions.deleteSchedule(nurseSchedules, parser.getDetails(line));
                    storage.writeToFile(nurseSchedules);
                } catch (WrongInputsException e) {
                    ui.invalidInputsMessage();
                    ui.deleteHelpMessage();
                }
                break;
            case "help":
                ui.printNurseScheduleHelpList();
                break;
            case "return":
                storage.writeToFile(nurseSchedules);
                ui.returnToStart();
                isRun = false;
                break;
            default:
                ui.invalidCommandMessage();
                break;
            }
        }
    }
}

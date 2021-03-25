package seedu.logic.instance;

import seedu.exceptions.nurseschedules.EmptyListException;
import seedu.exceptions.nurseschedules.NurseIdNotFound;
import seedu.exceptions.nurseschedules.WrongInputsException;
import seedu.exceptions.staffexceptions.AbortException;
import seedu.logic.command.NurseScheduleActions;
import seedu.logic.parser.NurseSchedulesParser;
import seedu.model.object.NurseSchedule;
import seedu.storage.NurseScheduleStorage;
import seedu.ui.NurseScheduleUI;
import seedu.ui.UI;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main entry-point for the NurseSchedules instance.
 */
public class NurseScheduleInstance {

    private NurseSchedulesParser parser;
    private NurseScheduleActions actions;
    private NurseScheduleStorage storage;

    /** The list of nurse schedules. */
    List<NurseSchedule> nurseSchedules = new ArrayList<NurseSchedule>();

    public static void main() {
        new NurseScheduleInstance().run();
    }

    /** Runs the program until termination. */
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

    /** Reads the user command and executes it, until the user issues the exit command. */
    private void runCommandLoopUntilExit() {
        boolean isRun = true;
        while (isRun) {
            NurseScheduleUI.nurseSchedulePrompt();
            String line = parser.getUserInput().trim();
            String command = parser.getFirstWord(line);

            switch (command) {
            case "add":
                try {
                    actions.addSchedule(nurseSchedules, NurseScheduleUI.inputToCreateSchedule());
                    storage.writeToFile(nurseSchedules);
                } catch (AbortException | ParseException e) {
                    UI.abortInputErrorMessage();
                }
                break;
            case "list":
                try {
                    actions.listSchedules(nurseSchedules, parser.getDetails(line));
                } catch (WrongInputsException e) {
                    NurseScheduleUI.invalidInputsMessage();
                    NurseScheduleUI.listHelpMessage();
                } catch (EmptyListException e) {
                    System.out.println(e.getMessage());
                } catch (NurseIdNotFound e) {
                    System.out.println(e.getMessage());
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
                NurseScheduleUI.returningToStartMenuMessage();
                isRun = false;
                break;
            default:
                NurseScheduleUI.invalidCommandMessage();
                break;
            }
        }
    }
}

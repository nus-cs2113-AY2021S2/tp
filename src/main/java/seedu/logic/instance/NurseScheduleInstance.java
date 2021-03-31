package seedu.logic.instance;

import seedu.exceptions.ExcessInputException;
import seedu.exceptions.HealthVaultException;
import seedu.exceptions.InsufficientInputException;
import seedu.exceptions.NoInputException;
import seedu.exceptions.nurseschedules.CrossValidationError;
import seedu.exceptions.nurseschedules.InvalidIDTypeException;
import seedu.exceptions.nurseschedules.NurseIdNotFound;
import seedu.logic.command.Command;
import seedu.logic.command.NurseScheduleActions;
import seedu.logic.parser.NurseSchedulesParser;
import seedu.storage.NurseScheduleStorage;
import seedu.ui.NurseScheduleUI;
import seedu.ui.UI;

import java.io.IOException;

/**
 * Main entry-point for the NurseSchedules instance.
 */
public class NurseScheduleInstance {

    private NurseSchedulesParser parser;
    private NurseScheduleActions nurseSchedules;
    private NurseScheduleStorage storage;
    private NurseScheduleUI ui;

    public NurseScheduleInstance() {
        parser = new NurseSchedulesParser();
        storage = new NurseScheduleStorage();
        ui = new NurseScheduleUI();
    }

    /** Reads the user command and executes it, until the user issues the exit command. */
    public void runCommandLoopUntilExit() {
        try {
            nurseSchedules = new NurseScheduleActions(NurseScheduleStorage.load());
        } catch (IOException | NullPointerException | ArrayIndexOutOfBoundsException |
                NurseIdNotFound | InvalidIDTypeException e) {
            ui.corruptedFileErrorMessage();
            return;
        } catch (CrossValidationError e) {
            System.out.println(e.getMessage());
            return;
        }
        ui.printNurseScheduleWelcomeMessage();
        boolean isReturnToStartMenu = false;
        while (!isReturnToStartMenu) {
            try {
                String line = ui.getInput("NSchedule");
                Command c = parser.nurseParse(line, ui);
                ui.lineBreak();
                c.execute(nurseSchedules, ui);
                storage.writeToFile(nurseSchedules);
                isReturnToStartMenu = c.isExit();
                if (isReturnToStartMenu) {
                    nurseSchedules.clearSchedules();
                    UI.returningToStartMenuMessage();
                }
                ui.lineBreak();
            } catch (HealthVaultException e) {
                System.out.println(e.getMessage());
                ui.lineBreak();
            } catch (NullPointerException e) {
                //ui.invalidInputsMessage();
                //Command C can return as null if an error is triggered in parser
                //Null Pointer Exception may hence occur, the catch statement is to ensure it does not exit the loop.
            }
        }
    }
}

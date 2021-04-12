package seedu.logic.instance;

import seedu.exceptions.HealthVaultException;
import seedu.exceptions.InvalidDateException;
import seedu.exceptions.nurseschedules.InvalidiDTypeException;
import seedu.exceptions.nurseschedules.NurseCrossValidationError;
import seedu.exceptions.nurseschedules.NurseIdNotFound;
import seedu.exceptions.nurseschedules.PatientCrossValidationError;
import seedu.exceptions.nurseschedules.PatientIdNotFound;
import seedu.logger.HealthVaultLogger;
import seedu.logic.command.Command;
import seedu.logic.parser.NurseSchedulesParser;
import seedu.model.nurseschedule.NurseScheduleList;
import seedu.storage.NurseScheduleStorage;
import seedu.ui.NurseScheduleUI;
import seedu.ui.UI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main entry-point for the NurseSchedules instance.
 */
public class NurseScheduleInstance {

    private NurseSchedulesParser parser;
    private NurseScheduleList nurseSchedules;
    private NurseScheduleStorage storage;
    private NurseScheduleUI ui;
    public Logger logger = HealthVaultLogger.getLogger();

    /**
     * Constructor for NurseScheduleInstance.
     */
    public NurseScheduleInstance() {
        parser = new NurseSchedulesParser();
        storage = new NurseScheduleStorage();
        ui = new NurseScheduleUI();
    }

    /**
     * Reads the user command and executes it, until the user issues the exit command.
     */
    public void runCommandLoopUntilExit() {
        try {
            nurseSchedules = new NurseScheduleList(storage.load());
        } catch (IOException | NullPointerException | ArrayIndexOutOfBoundsException
                | NurseIdNotFound | InvalidiDTypeException | PatientIdNotFound | InvalidDateException e) {
            ui.corruptedFileErrorMessage();
            logger.log(Level.WARNING, "Error loading NurseSchedule.txt");
            return;
        } catch (NurseCrossValidationError e) {
            System.out.println(e.getMessage());
            logger.log(Level.WARNING, "Error loading Staff.txt");
            return;
        } catch (PatientCrossValidationError e) {
            System.out.println(e.getMessage());
            logger.log(Level.WARNING, "Error loading Patients.txt");
            return;
        }
        ui.printNurseScheduleWelcomeMessage();
        boolean isReturnToStartMenu = false;
        while (!isReturnToStartMenu) {
            logger.info("Nurse Schedule super loop started");
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
                    logger.info("Exiting nurse schedule instance");
                }
                ui.lineBreak();
            } catch (HealthVaultException e) {
                System.out.print(e.getMessage());
                ui.lineBreak();
            } catch (NullPointerException e) {
                //ui.invalidInputsMessage();
                //Command C can return as null if an error is triggered in parser
                //Null Pointer Exception may hence occur, the catch statement is to ensure it does not exit the loop.
                logger.log(Level.WARNING, "null command returned");
            } catch (Exception e) {
                logger.log(Level.WARNING, "Something went wrong that is not handled by HealthVault exception.");
                System.out.println("OOPS! Something went wrong!");
            }
        }
    }
}

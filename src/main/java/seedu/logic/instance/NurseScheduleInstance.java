package seedu.logic.instance;

import seedu.exceptions.HealthVaultException;
import seedu.logic.command.Command;
import seedu.logic.command.NurseScheduleActions;
import seedu.logic.parser.NurseSchedulesParser;
import seedu.storage.NurseScheduleStorage;
import seedu.ui.NurseScheduleUI;
import seedu.ui.UI;
import java.util.logging.*;

/**
 * Main entry-point for the NurseSchedules instance.
 */
public class NurseScheduleInstance {



    private NurseSchedulesParser parser;
    private NurseScheduleActions nurseSchedules;
    private NurseScheduleStorage storage;
    private NurseScheduleUI ui;
    public static Logger logger;



    public NurseScheduleInstance() {
        parser = new NurseSchedulesParser();
        nurseSchedules = new NurseScheduleActions(NurseScheduleStorage.load());
        storage = new NurseScheduleStorage();
        ui = new NurseScheduleUI();

        logger = Logger.getLogger(this.getClass().getName());
        LogManager.getLogManager().reset();
        logger.addHandler(storage.initLogger());
    }

    /** Reads the user command and executes it, until the user issues the exit command. */
    public void runCommandLoopUntilExit() {
        ui.printNurseScheduleWelcomeMessage();
        boolean isReturnToStartMenu = false;
        while (!isReturnToStartMenu) {
            //logger.log(Level.INFO, "loop!");
            logger.info("loop!");
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
                logger.info("end loop!");
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

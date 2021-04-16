package seedu.igraduate;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Paths;

import java.util.logging.Logger;

import seedu.igraduate.logic.command.Command;
import seedu.igraduate.logic.parser.Parser;
import seedu.igraduate.model.list.ModuleList;
import seedu.igraduate.storage.Storage;
import seedu.igraduate.ui.Ui;

import java.util.logging.LogManager;
import java.util.logging.Level;

/**
 * IGraduate program.
 */
public class IGraduate {
    private Storage storage;
    private ModuleList modules;
    private Ui ui;
    private Parser parser;

    private static final Logger LOGGER = Logger.getLogger(IGraduate.class.getName());

    //@@author kewenlok
    /**
     * Initialise logger configurations at the moment the program is run.
     */
    static {
        try {
            InputStream inputStream = IGraduate.class.getClassLoader().getResourceAsStream("logger.properties");
            LogManager.getLogManager().readConfiguration(inputStream);
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "An error occurred when trying to read logger configuration file.", e);
        }
    }

    /**
     * Instantiates Storage, ModuleList and Ui components of the program.
     *
     * @param filePath The file path at which module data file is located, if
     *                 exists.
     */
    public IGraduate(File filePath) {
        LOGGER.info("Initialising iGraduate Ui, Storage and ModuleList components...");
        ui = new Ui();
        parser = new Parser();
        storage = Storage.getStorage(filePath);
        try {
            modules = new ModuleList(storage.loadModulesFromFile());
            storage.saveModulesToFile(modules);
        } catch (Exception e) {
            ui.printErrorMessage(e);
            LOGGER.log(Level.WARNING, "An error occurred when trying to read module data file.", e);
            modules = new ModuleList();
            LOGGER.info("A new module list is created.");
        } finally {
            LOGGER.info("All components initialised successfully.");
        }

        assert modules.size() >= 0 : "Module list not initialised properly. ";
    }

    /**
     * Runs IGraduate program.
     */
    public void run() {
        ui.printWelcomeMessage();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.getCommand();
                ui.printBorderLine();
                Command c = parser.parseCommand(fullCommand);
                c.execute(modules, ui, storage);
                isExit = c.isExit();
            } catch (Exception e) {
                ui.printErrorMessage(e);
                LOGGER.log(Level.WARNING, "An error occurred when trying to execute command.", e);
            } finally {
                ui.printBorderLine();
            }
        }
    }

    public static void main(String[] args) {
        LOGGER.info("iGraduate starts.");
        File filePath = Paths.get("data/modules.json").toFile();
        try {
            new IGraduate(filePath).run();
        } finally {
            LOGGER.info("iGraduate exits.");
        }
    }
}

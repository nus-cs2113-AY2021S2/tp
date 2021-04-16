package seedu.easylog.storage;

import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Deals with logging function for the app.
 */
public class Logging {

    Logger logger = Logger.getLogger("easyLogLogs");
    FileHandler fh;

    /**
     * Setting up the logging environment.
     */
    public void setUpLogger() {
        // Reset logs from previous usage of the app
        LogManager.getLogManager().reset();

        // Do not log to console
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.OFF);
        logger.addHandler(ch);

        try {
            File logs = new File("easyLogLogs.txt");
            if (logs.createNewFile()) {
                // do nothing as just checking whether logs file exists, else create the logs file
            }
            fh = new FileHandler("easyLogLogs.txt");
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            fh.setLevel(Level.ALL);
            logger.addHandler(fh);
            logger.info("Logging to file started.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to log INFO message.
     * @param logMessage Message to be logged as INFO.
     */
    public void writeInfoLevelLog(String logMessage) {
        logger.setUseParentHandlers(false);
        logger.info(logMessage);
    }

    /**
     * Method to log WARNING message.
     * @param logMessage Message to be logged as WARNING.
     */
    public void writeWarningLevelLog(String logMessage) {
        logger.setUseParentHandlers(false);
        logger.warning(logMessage);
    }

    /**
     * Method to log SEVERE message.
     * @param logMessage Message to be logged as SEVERE.
     */
    public void writeSevereLevelLog(String logMessage) {
        logger.setUseParentHandlers(false);
        logger.severe(logMessage);
    }
}

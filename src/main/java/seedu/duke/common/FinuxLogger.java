package seedu.duke.common;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.IOException;

/**
 * The {@code Logger} for the Finux application.
 * This is used to log down some information that can be used by developers/testers.
 */
public class FinuxLogger {
    private static final String LOG_FILE = "finuxLog.txt";
    private static final String ERROR_MESSAGE = "Error occurred in setting up finux logger!";
    private Logger logger;

    public FinuxLogger(String loggerName) {
        try {
            logger = Logger.getLogger(loggerName);
            FileHandler logFileHandler = new FileHandler(LOG_FILE, true);
            logFileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(logFileHandler);
            logger.setUseParentHandlers(false);
        } catch (IOException | SecurityException e) {
            logger = null;
            System.out.println(ERROR_MESSAGE);
        }
    }

    /**
     * Logs the INFO level message.
     *
     * @param infoMsg the message to log.
     * @see java.util.logging.Level#INFO
     */
    public void logInfo(String infoMsg) {
        if (logger != null) {
            logger.info(infoMsg);
        }
    }

    /**
     * Logs the WARNING level message.
     *
     * @param warningMsg the message to log.
     * @see java.util.logging.Level#WARNING
     */
    public void logWarning(String warningMsg) {
        if (logger != null) {
            logger.warning(warningMsg);
        }
    }
}
